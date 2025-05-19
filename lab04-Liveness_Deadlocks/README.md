PCD a.y. 2024-2025 - ISI LM UNIBO - Cesena Campus

# Lab Activity #04 - 20250317

v.1.0.0-20250316

### Thread Liveness & Deadlocks

- module-lab-1.5 - Thread Liveness & Deadlocks
  - Warm-up exercise: make the simplest deadlock in Java
     -  pcd.lab04.liveness.deadlock_simplest.TestDeadlockedResource
	  - Analysis using VisualVM
	  - Verification using JPF 
  - More complex example: AccountManager in pcd.lab03.liveness.accounts 
     - requirements
       - no race conditions in updating individual accounts
       - transfer between accounts should be atomic 
       - maximising concurrency
          - two transactions involving distinct couples of accounts should be served concurrently
   - Deadlocks when implementing MVC and Observer pattern
     - pcd.lab04.liveness.deadlock_obs.TestObsPatternDeadlock

### How to Implement Monitors in Java

- module-lab-1.6 - Implementing Monitors in Java
  - Testing raw behavior of `wait`, `notify`
  - SynchCell example 
     - `pcd.lab04.monitors.SynchCell`, `pcd.lab04.monitors.SynchCell2`   
  - Notes about the exception  java.lang.IllegalMonitorStateException
     - example `pcd.lab04.TestIllegalMonitorStateEx`
  - Bounded-Buffer implementation example in Producers-Consumers  
     - `pcd.lab04.monitors.BoundedBuffer1`, `pcd.lab05.monitors.BoundedBuffer2`
- Work-in-Lab
  - Exercise #1 -  Implementing Barrier monitor - `pcd.lab04.monitors.ex_barrier`
  - Exercise #2 -  Implementing Latch monitor - `pcd.lab04.monitors.ex_latch`
- Testing signalling discipline semantics in Java
  - the S&C signalling discipline effects - different behaviours 
     - pcd.lab04.monitors.TestSemantics1 (raw monitor impl)
         - Thread #1 is the first to enter the monitor
         - Thread #2 and Thread #3 arrive after Thread #1 is already inside
         - Thread #3 requests to enter after Thread #2
         - Thread #1 executes a wait inside the monitor before Thread #3 requests to enter
     - pcd.lab04.monitors.TestSemantics2 (raw monitor impl, different timings)
         - Like previous case, but Thread #3 requests to enter before Thread #1 executes the wait, so it is already in the entry set when Thread #1 executes the wait   
     - pcd.lab04.monitors.TestSemantics3  
         - monitor impl. Based on Locks+Cond   

### Work-in-Lab - Assignment #01

- Note: source updated, improved correctness
  - for every frame, first compute all velocities, then update all positions