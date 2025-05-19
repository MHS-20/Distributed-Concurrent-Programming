PCD a.y. 2024-2025 - ISI LM UNIBO - Cesena Campus

# Lab Activity #02 - 20250303

### Previous Lab Activity - Exercise solutions 

- Solution to Exercise 01
	- Exploiting Concurrent Thinking: naturally decomposing the problem to reduce complexity, using an active component (thread) for each word (`WordFallingAgent`)
- Solution to Exercise 02 
	- Simple solution with 2 threads + General solution with N threads
		- Enhancing JVM heap memory if needed: -Xms, -Xmx options (e.g. -Xms2G -Xmx4G)
	- Measuring speed-up and efficiency
	- ideas for improving the approach

### Thread Safety and Critical Sections in Java - First Look 

- module-lab-1.3 - Thread Safety
- Critical sections using low-level Java primitives - `pcd.lab02.cs_raw`
	- What's the sequence that will never be printed on standart output?
- **Work-in-Lab #01** -  Thread safety - lost update
	- Check lost update problem in `pcd.lab02.lost_updates`
	- Implement a solution based on basic Java low-level mechanism
- **Work-in-Lab #02** -  Thread safety - check and act
	- Check check & act problem in `pcd.lab02.check_act`
	- Implement a solution, based on basic Java low-level mechanism 

### Model Checking with Java Path Finder (JPF): A First Look

- [About JPF](https://github.com/javapathfinder/jpf-core)
	- [Main docs](https://github.com/javapathfinder/jpf-core/wiki)
	- [NASA web site](https://ti.arc.nasa.gov/tech/rse/vandv/jpf/)
	- [Old JPF sourceforge web site](http://javapathfinder.sourceforge.net/)
- JPF Design and Details
	- [Relationship between JPF and JVM](https://github.com/javapathfinder/jpf-core/wiki/Model-Java-Interface)
	- [Understanding JPF output](https://github.com/javapathfinder/jpf-core/wiki/Understanding-JPF-output)
	- [Top-level design](https://github.com/javapathfinder/jpf-core/wiki/Search-Strategies)
	- [A full perspective about using JPF](https://github.com/javapathfinder/jpf-core/wiki/Different-applications-of-JPF)

- Installing/Configuring JPF 
	- Following instructions from [JPF web site](https://github.com/javapathfinder/jpf-core/wiki/How-to-install-JPF)
		- works only with **JDK 1.8** 
	- [Gradle project template](https://github.com/pslab-unibo/jpf-template-project/tree/master) (G. Aguzzi)[**Recommended**] 
		- This is a template for using JPF with Gradle. It contains a build script that configures JPF and its dependencies, and a sample class that can be used to run JPF on a simple Java program.
		- To setup:
			- first clone the project:  
`git clone https://github.com/pslab-unibo/jpf-template-project.git`
			- to verify that everything is working:  
`./gradlew runVerifyAll`
		- Detailed usage instructions can be found on the web site.
	- [JPF lightweight environment repo](https://github.com/pcd-2024-2025/jpf-workspace) 
		- A customised lightweight repository including JPF binaries is available on the PCD course github organisation
			- details in the [README](https://github.com/pcd-2024-2025/jpf-workspace)
		- Requires **JDK 8** to be installed locally (e.g. from [here](https://www.oracle.com/it/java/technologies/downloads/))  
	- [JPF lightweight environment repo with Docker](https://github.com/pcd-2024-2025/jpf-docker) 
		- The same customised lightweight repository as above, but to be used with Docker and not requiring a local JDK 8