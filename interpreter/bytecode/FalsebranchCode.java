package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class FalsebranchCode extends ByteCode {
  private String byteCode = "FALSEBRANCH";
  private String label;
  private int branchTarget;

  public FalsebranchCode(List<String> args) {
    this.label = args.get(0);   
  }

  public String toString() {
    return this.byteCode + " " + this.label;
  }
    
  public void execute(VirtualMachine vm) {
    if(!vm.checkTopOfStack())  {
      vm.branchToTarget( this.branchTarget );
    }  
  }

  public String getLabel() {
    return this.label;
  }

  public void setBranchTarget(int branchTarget) {
    this.branchTarget = branchTarget;
  }

  public int getBranchTarget() {
    return this.branchTarget;
  }
    
}
