package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

/*
 * GOTO <label> GOTO xyz<<3>>
 */
public class GotoCode extends ByteCode {
  private String byteCode = "GOTO";
  private String label;
  private int branchTarget;

  public GotoCode(List<String> args) {
    this.label = args.get(0);  
  }

  public String toString() {
    return this.byteCode + " " + this.label;
  }
    
  public void execute(VirtualMachine vm) {
    vm.branchToTarget( this.branchTarget );
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
