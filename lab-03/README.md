PCD a.y. 2024-2025 - ISI LM UNIBO - Cesena Campus

# Lab Activity #03 - 20250310

v.0.9-20250309

### Locks and Semaphores in Java

- module-lab-1.4 - Thread Coordination in Java - Library Support
	- `Lock` interface and `ReentrantLock` class
		- Implementing a critical section: `pcd.lab03.cswithlocks`
		- How to verify the program with **JPF** (see [Lab Activity #02](https://github.com/pcd-2024-2025/lab-02) for JPF setup)
			- simplifying the program: `pcd.lab03.cswithlocks_jpf` 
			- instrument the program to exploit assertions
	- `Semaphore` class 
		- Implementing a critical section with semaphores: `pcd.lab03.cswithsem`

- **Work-in-Lab** -  Thread synchronisation with semaphores
	- Preparation
		- Consider the `pcd.lab03.ex01_syncwithsem.TestPingPong` program
			- `Pinger` and `Ponger` agents, concurrently printing ping and pong
	- Exercise  
		- Make `Pinger` and `Ponger` synchronised using semaphores, so that they alternate in printing ping and pong
		- What correctness properties? How to specify and check them with JPF?

### New Tool: VisualVM profiler
 
- [VisualVM](https://visualvm.github.io/)
	- useful also to track thread behaviour/state (blocked, not blocked)

