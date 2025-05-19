package pcd.lab01.ex01;

import static org.fusesource.jansi.Ansi.*;
import java.util.List;
import java.lang.Thread;
import java.util.Random;


/**
 * Simple program showing basic features
 * of J-ANSI lib.
 * <p>
 * To be run from a command line.
 */
public class TestScreen {
    final static int MAX_Y = 10;

    public static void main(String[] args) {

        int y = 0;
        Random random = new Random();
        Screen screen = Screen.getInstance();
        String sentence = "Mi  cadono le braccia";
        List<AuxLib.WordPos> wordPositions = AuxLib.getWordsPos(sentence);
        Thread[] threads = new Thread[wordPositions.size()];
        screen.clear();

        int i = 0;
        for(AuxLib.WordPos wp: wordPositions){
            int sleep = random.nextInt(500); // Genera un tempo tra 500 e 2000 ms
            threads[i] = new Thread(() -> MoveWord(wp, screen, sleep));
            threads[i].start();
            i++;
        }
    }

    public static void MoveWord(AuxLib.WordPos wordPos, Screen screen, int sleep) {
       int y = 0;
        while(y < MAX_Y){
            screen.writeStringAt(y, wordPos.pos(), Color.RED, wordPos.word());

            try{
                Thread.sleep(sleep); // Pausa casuale dentro la funzione
            }catch(InterruptedException e){
                continue;
            }

            screen.writeStringAt(y, wordPos.pos(), Color.BLACK, wordPos.word());
            y++;
        }

        screen.writeStringAt(y, wordPos.pos(), Color.RED, wordPos.word());

    }

}
