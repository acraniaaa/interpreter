package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class CallCode extends ByteCode {
  private String byteCode = "CALL";
  private String functionName;
  private int branchTarget;

  public CallCode(List<String> args) { 
    this.functionName = args.get(0);    
  }

  public String toString() {
    return this.byteCode + " " + this.functionName;
  }
    
  public void execute(VirtualMachine vm) {
    vm.saveReturnAddress();
    vm.branchToTarget( this.branchTarget );
  }

  public String getFunctionName() {
    return this.functionName;
  }

  public void setBranchTarget( int branchTarget ) { 
    this.branchTarget = branchTarget;
  }
  public int getBranchTarget() {
    return this.branchTarget;
  }
    
}
