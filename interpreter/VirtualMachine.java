/**
 * DO NOT provide a method that returns components contained WITHIN the VM (this
 * is the exact situation that will break encapsulation) - you should request
 * that the VM performs operations on its components. This implies that the VM
 * owns the components and is free to change them, as needed, without breaking
 * clients' code (e.g., suppose I decide to change the name of the variable that
 * holds my runtime stack - if your code had referenced that variable then your
 * code would break. This is not an unusual situation - you can consider the
 * names of methods in the Java libraries that have been deprecated).
 *
 * Consider that the VM calls the individual ByteCodes' execute method and
 * passes itself as a parameter. For the ByteCode to execute, it must invoke
 * one or more methods in the runStack. It can do this by executing
 * VM.runStack.pop(); however, this does break encapsulation. To avoid this,
 * you'll need to have a corresponding set of methods within the VM that do
 * nothing more than pass the call to the runStack. e.g., you would want to
 * define a VM method:
 *     public int popRunStack() {
 *       return runStack.pop();
 *     }
 * called by, e.g.,
 *     int temp = VM.popRunStack();
 */
package interpreter;

import interpreter.bytecode.*;
import interpreter.errors.StackUnderflowException;

import java.util.Stack;

public class VirtualMachine {

  private int pc;
  private RunTimeStack runTimeStack;
  private Stack<Integer> returnAddresses;
  private boolean isRunning;
  private boolean isOutputting;
  private Program program;
  private int lastStoredValue;
  private int lastOffset;

  public VirtualMachine(Program program) {
    this.program = program;
  }

  public void executeProgram() {
    pc = 0;
    runTimeStack = new RunTimeStack();
    returnAddresses = new Stack<>();
    isRunning = true;
    isOutputting = false;

    while ( isRunning ) {
      ByteCode code = program.getCode(pc);
      code.execute(this);
      if( isOutputting ) {
        if( code.toString().contains("DBG") ) {
          this.pc++;
          continue;
        }
        try {
          this.debug(code);
        } catch (StackUnderflowException e) {}
      }
      this.pc++;
    }

  }

  public void debug(ByteCode code) throws StackUnderflowException {
    if(code.toString().contains("RETURN")) {
      ReturnCode returnCode = (ReturnCode)code;
      String functionName = returnCode.getFunctionName();
      String baseID = getBaseID(functionName);
      System.out.println(String.format("%-25send %s: %d",
        String.format("RETURN %s", functionName),
        baseID,
        this.runTimeStack.peek()
        )
      );

    }
    else if(code.toString().contains("CALL")) {
      CallCode callCode = (CallCode)code;
      String functionName = callCode.getFunctionName();
      String baseID = getBaseID(functionName);
      String args = "";
      String runTimeStackString = runTimeStack.toString();
      if(this.lastOffset > 0) {
        for(int i = runTimeStackString.length()-2; i > 0; i--) {
          if(runTimeStackString.charAt(i) == '[') {
            break;
          }
          args += runTimeStackString.charAt(i);
        }
        args = new StringBuilder(args).reverse().toString();
      }
      
      System.out.println(String.format("%-25s%s(%s)",
        String.format("CALL %s", functionName),
        baseID,
        args
        )
      );
    }
    else if(code.toString().contains("STORE")) {
      StoreCode storeCode = (StoreCode)code;
      System.out.println(String.format("%-25s%s = %d",
        String.format("STORE %d %s", storeCode.getOffset(), storeCode.getVariableName()),
        storeCode.getVariableName(),
        this.lastStoredValue
        )
      );
    } 
    else {
      System.out.println(code.toString());
    }

    System.out.println(this.runTimeStack.toString());

  }

  public String getBaseID(String functionName) {
    String baseID = "";
      for(int i = 0; i < functionName.length(); i++) {
        if(functionName.charAt(i) == '<') {
          break;
        }
        baseID += functionName.charAt(i);
      }
    return baseID;
  }

  public boolean checkTopOfStack() {
    boolean result = false;
    try {
      if( runTimeStack.pop() == 0 ) {
        result = false;
      } else {
        result = true;
      }
    } catch (StackUnderflowException e) {}
    return result;
  }

  public void saveReturnAddress() {
    this.returnAddresses.add(this.pc);
  }

  public void returnToAddress() {
    pc = returnAddresses.pop();
  }

  public void popFrame() {
    try {
      runTimeStack.popFrame();
    } catch (StackUnderflowException e) {}
  }

  public void pop( int amountToPop ) {
    for(int i = 0; i < amountToPop; i++) {
      try {
        runTimeStack.pop();
      } catch (StackUnderflowException e) {}
    }
  }
  public void branchToTarget(int branchTarget) {
    this.pc = branchTarget;
  }

  public void changeDebugStatus(boolean debugStatus) {
    this.isOutputting = debugStatus;
  }

  public void haltProgram() {
    this.isRunning = false;
  }
  
  public void createNewFrame( int offset ) {
    this.runTimeStack.newFrameAt( offset );
    this.lastOffset = offset;
  }

  public void loadLiteralValue( int litValue ) { 
    this.runTimeStack.push( litValue );
  }

  public void executeBinaryOperation(String arg) {
    try {
      this.runTimeStack.executeBinaryOperation( arg );
    } catch (StackUnderflowException e) {}
  }

  public void load( int offset ) { 
    runTimeStack.load( offset );
  }

  public void store( int offset ) {
    try {
      this.lastStoredValue = runTimeStack.store( offset );
    } catch (StackUnderflowException e) {}
  }

  public void write() {
    try {
      this.runTimeStack.write();
    } catch (StackUnderflowException e) {}
  }

}
