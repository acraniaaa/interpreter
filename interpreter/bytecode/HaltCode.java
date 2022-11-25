package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;
// HALT HALT
//Halt execution
public class HaltCode extends ByteCode {
  private String byteCode = "HALT";

  public HaltCode(List<String> args) {}
  
  public HaltCode() {}


  public String toString() {
    return byteCode;
  }
    
  public void execute(VirtualMachine vm) {
    vm.haltProgram();
  }
    
}
