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
   * Outputs the current state of the stack.
   */
  @SuppressWarnings("unchecked")
  public String toString() {
    Stack<Integer> framePointersCopy = (Stack<Integer>) this.framePointers.clone();
    Vector<String> frames = new Vector<>();
    int upperIndex = runStack.size() - 1;
    while( framePointersCopy.size() > 0 ) {
      int lowerIndex = framePointersCopy.pop();
      String currentFrame = "[";
      for(int i = lowerIndex; i < upperIndex; i++) {
        currentFrame += String.format("%d,", runStack.get(i));
      }
      if(upperIndex >= 0) {
        currentFrame += runStack.get(upperIndex) + "]";
      } else {
        currentFrame += "]";
      }
      frames.add(currentFrame);
      upperIndex = lowerIndex-1;
    }    
    
    String result = "";
    for(int i = frames.size()-1; i > 0; i--) {
      result += frames.get(i) + " ";
    }
    result += frames.firstElement();
    return result;
  }

  /**
   * Returns the top item on the runtime stack.
   */
  public int peek() throws StackUnderflowException {
    if(runStack.size() <= this.framePointers.peek()) {
      throw new StackUnderflowException();
    }
    return runStack.lastElement();
  }

  /**
   * Pops the top item from the runtime stack, returning the item.
   */
  public int pop() throws StackUnderflowException {
    if(runStack.size() <= this.framePointers.peek() ) {
      throw new StackUnderflowException();
    }
    int lastElement = runStack.lastElement();
    runStack.remove(runStack.size()-1);
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
    this.framePointers.push(runStack.size() - offset);
  }

  /**
   * We pop the top frame when we return from a function; before popping, the
   * functions’ return value is at the top of the stack so we’ll save the value,
   * pop the top frame, and then push the return value.
   */
  public void popFrame() throws StackUnderflowException {
    if( this.framePointers.size() == 1 ) {
      throw new StackUnderflowException();
    }
    int returnValue = runStack.lastElement();
    while(this.runStack.size() > this.framePointers.peek()) {
      this.runStack.remove( this.runStack.lastElement() );
    }
    this.framePointers.pop();
    this.runStack.add( returnValue );

  }

  /**
   * Used to store into variables.
   */
  public int store( int offset ) throws StackUnderflowException {
    int storedValue = this.pop();
    int index = this.framePointers.peek() + offset;
    this.runStack.insertElementAt(storedValue, index);
    if(this.runStack.size() == 1) {
      throw new StackUnderflowException();
    } else {
      this.runStack.removeElementAt(index + 1);
    }
    return storedValue;
  }

  /**
   * Used to load variables onto the stack.
   */
  public int load(int offset) {
    int loadedValue = this.runStack.get( offset );
    if( this.framePointers.isEmpty() ){
      this.runStack.add(offset, loadedValue );
  }else {
      offset += framePointers.lastElement();
      this.runStack.add( loadedValue );
      }
    return loadedValue;
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