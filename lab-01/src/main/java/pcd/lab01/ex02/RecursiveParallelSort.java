package pcd.lab01.ex02;

import java.util.Arrays;
import java.util.Random;

public class RecursiveParallelSort {

    static final int VECTOR_SIZE = 400_000_00;
    private static Thread[] threads;

    public static void main(String[] args) {
        log("Generating array...");
        int[] v = genArray(VECTOR_SIZE);

        log("Array generated.");
        log("Sorting (" + VECTOR_SIZE + " elements)...");

        int nprocessor = Runtime.getRuntime().availableProcessors();
        log("Number of processors: " + nprocessor);

        threads = new Thread[nprocessor];
        long t0 = System.nanoTime();

        recursiveMerge(v, nprocessor);
        long t1 = System.nanoTime();
        log("Done. Time elapsed: " + ((t1 - t0) / 1000000) + " ms");
    }

    private static int[] genArray(int n) {
        Random gen = new Random(System.currentTimeMillis());
        var v = new int[n];
        for (int i = 0; i < v.length; i++) {
            v[i] = gen.nextInt();
        }
        return v;
    }

    private static void dumpArray(int[] v) {
        for (var l : v) {
            System.out.print(l + " ");
        }
        System.out.println();
    }

    private static void log(String msg) {
        System.out.println(msg);
    }

    private static void recursiveMerge(int[] v, int nthreads) {

        if (nthreads == 1) {
            Arrays.sort(v);
            return;
        }

        for (int i = 0; i < nthreads; i++) {
            int static_index = i;
            threads[i] = new Thread(() -> ThreadMerge(v, static_index * (v.length / nthreads),
                    (static_index + 1) * (v.length / nthreads)));
            threads[i].start();
        }

        for (int i = 0; i < nthreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        recursiveMerge(v, nthreads / 2);
    }

    private static void ThreadMerge(int[] array, int start, int finish) {
        // System.out.println("Start: " + start + " Finish: " + finish);
        Arrays.sort(array, start, finish);
    }
}
