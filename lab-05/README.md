PCD a.y. 2024-2025 - ISI LM UNIBO - Cesena Campus

# Lab Activity #05 - 20250324

v.1.0.0-20250322

### From Threads to Tasks

- module-lab-1.7 - Task-Oriented Programming in Java  
   - `Executor` Framework  
      - Examples
  	      - Matmul example – `pcd.lab05.executors.matmul`
  	      - Quadrature problem example, with different strategies to collect results
  	         - collecting results with monitor + shutdown mechanism to synch – `pcd.lab05.executors.quad1_basic`
  	         - collecting results only with monitor - `pcd.lab06.executors.quad2_withsynch`
  	         - without monitors, using futures - `pcd.lab05.executors.quad2_withfuture`
  	   - Beware of deadlocks using Executors – example: `pcd.lab05.executors.deadlock`
  	      - Why is there a deadlock? Discussion
      -  Improving structure in task-oriented programming
         -  `ForkJoin` executor           
             -  example – `pcd.lab05.executors.fj`   
         - Structured Concurrency (JEP 437)    

### Virtual Threads 

- module-lab-1.8 - Virtual Threads
   - Examples – `pcd.lab05.vt`


### Multi-threaded programs with GUI

- module-lab-1.9 - GUI Frameworks and Concurrency
- Revisiting the Model-View-Controller Architecture - design discipline to avoid problems
   - Poor responsiveness problem  - `pcd.lab05.mvc.v1_unresponsive`
   - Deadlocks problem - `pcd.lab05.mvc.v2_deadlock`
   - Correct approach - `pcd.lab05.mvc.v3_good`
- MVC with threads: Examples
   - Chrono example 
      - MVC designed with active components - `pcd.lab05.chrono.v1_basic`
      - Refined version (more strict discipline about active and passive components) -   
`pcd.lab05.chrono.v2_strict`
   - Mandelbrot Viewer example
      - Objective: creating a viewer for the [Mandelbrot set](https://en.wikipedia.org/wiki/Mandelbrot_set)   
      - Steps
         - Non responsive sequential solution - `pcd.lab05.mandelbrot.v1_not_reactive`
         - Responsive but still sequential solution - `pcd.lab05.mandelbrot.v2_reactive_but_sequential`
            - Separate thread for doing the computation (MandelbrotComputingAgent)
            - Stop flag 
         - Concurrent design - first version - `pcd.lab05.mandelbrot.v3_reactive_and_concurrent`
            - Simple Master/Workers architecture - master (and workers) created on the fly, static allocation
         - Concurrent design, refined version - `pcd.lab05.mandelbrot.v4_reactive_concurrent_extended`
            - Master/Workers architecture with bag of tasks


### Work-in-Lab - Assignment #01
