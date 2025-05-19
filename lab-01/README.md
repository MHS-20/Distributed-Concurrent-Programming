PCD a.y. 2024-2025 - ISI LM UNIBO - Cesena Campus

# Lab Activity #01 - 20250224


### Multithreaded programming in Java - Basics & Design discipline

- Java Thread Basic API overlook – module-lab-1.1
	- How to define / create / spwan threads
	- A look at basic methods/mechanisms and Java System API  
	- Example: `pcd.lab01.hello`
- Focus on design: active & passive components    
	- Active and passive components discipline
		- an active component <=> a control flow
		- passive components => accessed by active components (control flow) 
	- Consequences (constraints/discipline)
		- no public methods for active components
		- protected and private methods to modularise (internal) actions
- **Worl-in-Lab #1**
	- Preparation
		- Consider the `pcd.lab01.ex01` example 
			- `Screen`class based on [JANSI library](https://github.com/fusesource/jansi)
			- `TestScreen` example
	- Exercise
		- Build a simple multithreaded program implementing the "falling words" animation on the console
			- given a sentence written on top of the screen (e.g. `This is a simple sentence with words ready to fall` written at (0, 10)), each word of the sentence should move down, concurrently 
				- each word should have a different speed
				- all words should stop at the botton of the screen
		- Useful lib: `AuxLib` and its simple usage example: `TestAuxLib`

### About Performance

- First look at performance – module-lab-1.2
	- how many threads?
	- A first tool for profiling concurrent programs: JConsole
	- how thread behaviour can affect CPU usage & reactivity
		- an example: `pcd.lab01.bballs` (bouncing balls)
		- Threads with non terminating behaviour (`BallAgent`)



- **Work-in-Lab #2**
	- Preparation
		- program `pcd.lab01.ex02` - it creates and sorts an array
	- Exercise
		- Create a concurrent version exploiting 2 threads and measure the speedup
		- Generalise the solution to scale with the number of cores

