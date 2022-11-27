[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-9f69c29eadd1a2efcce9672406de9a39573de1bdf5953fef360cfc2c3f7d7205.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=9209808)
# Assignment 4 Documentation

Author: Ivan Ramos

## Project Introduction

In the Interpreter project, my task was to add and implement 15 new bytecode classes that inherit the ByteCode abstract class, as well as creating classes to be able to read in a *.x.cod* file that processes these ByteCodes and their arguments, if applicable. I then added functionality to these bytecodes through the use of the VirtualMachine and RunTimeStack classes.

## Execution and Development Environment

- Java version: 18.0.2.1
- Development Environment: IDE/Codespaces - Visual Studio Code

### Class Diagram
![image](https://user-images.githubusercontent.com/49260712/204121216-3566008f-ee33-4065-9cc3-d84d69619e1f.png)
![image](https://user-images.githubusercontent.com/49260712/204122272-6342b6f7-788c-436c-95fa-e7f23891f8a3.png)

ByteCodeLoader, Program and VirtualMachine are all pointing to the *bytecode* package, and the *bytecode* package points to VirtualMachine.

## Scope of work and Project Discussion

Include a list of the tasks and requirements you completed, with a discussion of each task.
### Task 1
One of the first tasks I worked on was populating the *bytecode* package with 15 subclasses that each inherit the ByteCode abstract class, for the purpose of just being able to read in these bytecodes, and then later on I can add functionality to them. 

### Task 2
My second task was to work on building up the CodeTable, ByteCodeLoader and Program classes to able to read in these bytecodes. The first 4 bytecodes I implemented were LABEL, FALSEBRANCH, GOTO, and CALL, since these were the bytecodes that require use of the resolveSymbolicAddresses() method; they were implemented first for testing purposes.

### Task 3
The third task was to work on implementing the RunTimeStack. This involved creating methods in the VirtualMachine class that would be called by each individual bytecode as needed, to pass certain instructions and data from the bytecode to the RunTimeStack. For this part of the project, I implemented each bytecode 1 by 1 so that I can test if they work or not, and make adjustments. During this part, I tried my best to not break encapsulation.

## Results and Conclusions

### What I Learned
As usual, I learn a lot from these projects. This project, specifically, had an emphasis on encapsulation and data hiding, which isn't my strong suit; I'm used to using getter and setter methods everywhere needed. This project helped me learn more about encapsulation. For example, instead of each bytecode taking information from the virtual machine and runtime stack and outputting the result, the bytecode passes its own information down to the virtual machine and runtime stack where it will be processed and kept there. 

### What I Could Do Better
I still don't feel too confident with encapsulation. For some reason, I have the feeling I messed up somewhere, or there's a method I wrote that could've been written in a different way. I tried my best to also implement the single responsibility principle, and not have methods that span a billion lines down. For example, I broke up my debug method into 3 other parts, 1 for each "special" bytecode's debug output (call, store, and return), as well as a helper method, getBaseID, since I noticed that these bytecodes have a base ID.

### Challenges I Encountered
For some reason, I had a lot of trouble implementing the toString() method in the RunTimeStack class, which was supposed to print out the run stack and the varying amount of frames. My first idea was to just iterate through the framePointers stack and print out the literals from one frame pointer to the next, but I quickly realized I couldn't do that because it's a *stack*. The last time I used a method that defeated the purpose of a stack, I got chewed out for it (my implementation on assignment 0). So, I just created a copy of the stack and iterated backwards, by popping a frame pointer in each iteration. After there were no frame pointers, I just reversed the string, since I was going backwards and all. 
