package interpreter;

import java.util.Stack;
import java.util.Vector;

import interpreter.errors.StackUnderflowException;

public class RunTimeStack {

  private Stack<Integer> framePointers;
  private Vector<Integer> runStack;

  public RunTimeStack() {
    runStack = new Vector<>();
    framePointers = new Stack<>();
    framePointers.push(0);
  }

  /**
   * The purpose of this function is to dump the RunTimeStack for the 
   * purpose of debugging.
   */
  public void dump() {

  }
  /**
   * Outputs the current state of the stack.
   */
  public String toString() {
    String string = "[";
    for(int i = 0; i < runStack.size()-1; i++) {
      string += String.format("%d,", runStack.get(i));
    }
    string += runStack.lastElement() + "]";
    
    return string;
  }

  /**
   * Returns the top item on the runtime stack.
   */
  public int peek() throws StackUnderflowException {
    return runStack.get(runStack.lastElement());
  }

  /**
   * Pops the top item from the runtime stack, returning the item.
   */
  public int pop() throws StackUnderflowException {
    int lastElement = runStack.lastElement();
    runStack.remove(runStack.lastElement());
    return lastElement;
  }

  /**
   * Push an item on to the runtime stack, returning the item that was just 
   * pushed.
   */
  public int push(int item) {
    runStack.add(item);
    return item;
  }

  /**
   * This second form with an Integer parameter is used to load literals onto the
   * stack.
   */
  public Integer push(Integer i) {
    return 0;
  }

  /**
   * Start a new frame, where the parameter offset is the number of slots
   * down from the top of the RunTimeStack for starting the new frame.
   */
  public void newFrameAt(int offset) {

  }

  /**
   * We pop the top frame when we return from a function; before popping, the
   * functions’ return value is at the top of the stack so we’ll save the value,
   * pop the top frame, and then push the return value.
   */
  public void popFrame() throws StackUnderflowException {

  }

  /**
   * Used to store into variables.
   */
  public int store(int offset) throws StackUnderflowException {
    return 0;
  }

  /**
   * Used to load variables onto the stack.
   */
  public int load(int offset) {
    return 0;
  }
}