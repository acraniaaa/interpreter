package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

// LIT n LIT 5
//Load the literal value n
/*
 * LIT 0 <id> LIT 0 i
 * 
 * This form of the LIT was generated 
to load 0 on the stack in order to 
initialize the variable i to 0 and 
reserve space on the runtime stack 
for i
 */
public class LitCode extends ByteCode {
  private int litVal;
  private String litID;

  public LitCode(List<String> args) {
    this.litVal = Integer.parseInt(args.get(0));
    if(args.size() == 2) {
      litID = args.get(1);
    }
  }

  public String toString() {
    if(litID == null) {
      return String.format("%-25sint %d",
        String.format("LIT %d", this.litVal), 
        this.litVal
      );
    } else {
      return String.format("%-25sint %s = %d",
        String.format("LIT %d %s", this.litVal, this.litID), 
        this.litID,
        this.litVal
      );
    }
  }
    
    public void execute(VirtualMachine vm) {
      vm.loadLiteralValue( litVal );
  }
    
}
