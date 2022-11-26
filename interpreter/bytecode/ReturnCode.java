package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

/*
 * RETURN <funcname> RETURN f<<2>>
 * Return from the current function. 
<funcname> is used as a comment 
to indicate the function.
 */
/*RETURN RETURN Generated for intrinsic functions. */
public class ReturnCode extends ByteCode {
  private String byteCode = "RETURN";
  private String functionName;
    

  public ReturnCode(List<String> args) {
    if(args.size() == 1) {
      this.functionName = args.get(0);    
    }
  }

  public String getFunctionName() {
    return this.functionName;
  }



  public String toString() {
    if(functionName == null) {
      return this.byteCode;
    } else {
      return this.byteCode + " " + this.functionName;        
    }
  }

  public void execute(VirtualMachine vm) {
    vm.popFrame();
    vm.returnToAddress();
  }
    
}
