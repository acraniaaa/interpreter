package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;
/*
 * FALSEBRANCH <label> ; FALSEBRANCH xyz<<3>>
 */
/*Pop the top of the stack; if it’s false 
(0) then branch to <label>, else 
execute the next byte code
 */
public class FalsebranchCode extends ByteCode {
  private String byteCode = "FALSEBRANCH";
  private String label;
  private int branchTarget;
  //resolve symbolic addressses; basically, tranform the label into an int
  //that contains the location of the label
  public FalsebranchCode(List<String> args) {
    this.label = args.get(0);   
  }

  public String toString() {
    return this.byteCode + " " + this.label;
  }
    
  public void execute(VirtualMachine vm) {
    if(!vm.checkTopOfStack())  {
      vm.branchToTarget(branchTarget);
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
