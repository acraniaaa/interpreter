package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

public class HaltCode extends ByteCode {
  private String byteCode = "HALT";

  public HaltCode(List<String> args) {}
  
  public HaltCode() {}


  public String toString() {
    return this.byteCode;
  }
    
  public void execute(VirtualMachine vm) {
    vm.haltProgram();
  }
    
}
