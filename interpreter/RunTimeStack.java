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
      //TODO this is the aligned text thing, i need to figure out toString() first before doing this
  }
  /**
   * Outputs the current state of the stack.
   */
  //TODO this is wrong, and way too long. Change this and work on it
  public String toString() {
    /*
     * Stack<Integer> framePointersCopy = this.framePointers;
    String[] frames = new String[framePointersCopy.size()];
    for(int i = 0; i < framePointersCopy.size(); i++) {
      String frame = "[";
      int endFrame = framePointersCopy.pop();
      int startFrame = framePointersCopy.peek();
      for(int j = startFrame; j < endFrame - 1; j++) {
        frame += String.format("%d,", this.runStack.get(j));
      }
      frame += this.runStack.get(endFrame) + "]";
      frames[i] = frame;
    }
    String output = "";
    if(frames.length > 1) {
      for(int i = 0; i < frames.length-1; i++) {
        output += frames[i] + " ";
      }
    }
    output += frames[frames.length-1];
    
    return output;
    
     */
    return runStack.toString();
  }

  /**
   * Returns the top item on the runtime stack.
   */
  public int peek() throws StackUnderflowException {
    if(runStack.size() <= framePointers.peek()) {
      throw new StackUnderflowException();
    }
    return runStack.lastElement();
  }

  /**
   * Pops the top item from the runtime stack, returning the item.
   */
  public int pop() throws StackUnderflowException {
    if(runStack.size() <= framePointers.peek()) {
      throw new StackUnderflowException();
    }
    int lastElement = runStack.lastElement();
    runStack.remove(runStack.size()-1);
    System.out.println(runStack.toString());
    System.out.println(lastElement);
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
    runStack.add(i);
    return i;
  }

  /**
   * Start a new frame, where the parameter offset is the number of slots
   * down from the top of the RunTimeStack for starting the new frame.
   */
  public void newFrameAt(int offset) {
    framePointers.push(runStack.size() - offset);
  }

  /**
   * We pop the top frame when we return from a function; before popping, the
   * functions’ return value is at the top of the stack so we’ll save the value,
   * pop the top frame, and then push the return value.
   */
  public void popFrame() throws StackUnderflowException {
    if(framePointers.size() == 1) {
      throw new StackUnderflowException();
    }
    int returnValue = runStack.lastElement();
    while(runStack.size() > framePointers.peek()) {
      runStack.remove(runStack.lastElement());
    }
    framePointers.pop();
    runStack.add(returnValue);

  }

  /**
   * Used to store into variables.
   */
  public int store( int offset ) throws StackUnderflowException {
    int storedValue = this.pop();
    int index = framePointers.peek() + offset;
    this.runStack.insertElementAt(storedValue, index);
    this.runStack.removeElementAt(index + 1);
    return 0;
  }

  /**
   * Used to load variables onto the stack.
   */
  //TODO ask why store and load return int values
  public int load(int offset) {
    System.out.println("sdfa");
    if(framePointers.isEmpty()){
      runStack.add(offset, runStack.get(offset));
  }else {
      offset += framePointers.lastElement();
      runStack.add(runStack.get(offset));
      }
    return 0;
  }

  public void write() throws StackUnderflowException {
    System.out.println( this.peek() );
  }

  public void executeBinaryOperation(String arg) throws StackUnderflowException {
    int secondOperand = this.pop();
    int firstOperand = this.pop();
    if( arg.equals("+") ) {
      this.push( firstOperand + secondOperand );
    } else if( arg.equals("-") ) {
      this.push( firstOperand - secondOperand );
    } else if( arg.equals("*") ) {
      this.push( firstOperand * secondOperand );
    } else if( arg.equals("/") ) {
      this.push( firstOperand / secondOperand );
    } else if( arg.equals("==") ) {
      if( firstOperand == secondOperand ) {
        this.push( 1 );
      } else {
        this.push( 0 );
      }
    } else if( arg.equals("!=") ) {
      if( firstOperand == secondOperand ) {
        this.push( 0 );
      } else {
        this.push( 1 );
      }
    } else if( arg.equals("<") ) {
      if( firstOperand < secondOperand ) {
        this.push( 1 );
      } else {
        this.push( 0 );
      }
    } else if( arg.equals(">") ) {
      if( firstOperand > secondOperand ) {
        this.push( 1 );
      } else {
        this.push( 0 );
      }
    } else if( arg.equals("<=") ) { 
      if( firstOperand <= secondOperand ) {
        this.push( 1 );
      } else {
        this.push( 0 );
      }
    } else if( arg.equals(">=") ) {
      if( firstOperand >= secondOperand ) {
        this.push( 1 );
      } else {
        this.push( 0 );
      }
    } else if( arg.equals("|") ) {
      if( firstOperand == 0 && secondOperand == 0 ) {
        this.push( 0 );
      } else {
        this.push( 1 );
      }
    } else if( arg.equals("&") ) {
      if( firstOperand == 1 && secondOperand == 1 ) {
        this.push( 1 );
      } else {
        this.push( 0 );
      }
    }
  }
}