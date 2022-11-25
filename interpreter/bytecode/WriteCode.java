package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;
/*
 * WRITE WRITE
Write the value on top of the 
stack to the output, leaving the 
value on the top of the stack
 */
public class WriteCode extends ByteCode {
  private String byteCode = "WRITE";

  public WriteCode(List<String> args) {}
  public WriteCode() {}

  public String toString() {
    return byteCode;
  }
    
  public void execute(VirtualMachine vm) {
    vm.write();
  }
    
}
