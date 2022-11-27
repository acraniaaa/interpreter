package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class LitCode extends ByteCode {
  private int litVal;
  private String litID;

  public LitCode(List<String> args) {
    this.litVal = Integer.parseInt(args.get(0));
    if(args.size() == 2) {
      this.litID = args.get(1);
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
      vm.push( this.litVal );
  }
    
}
