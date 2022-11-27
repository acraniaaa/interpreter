package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

public class WriteCode extends ByteCode {
  private String byteCode = "WRITE";

  public WriteCode(List<String> args) {}
  public WriteCode() {}

  public String toString() {
    return this.byteCode;
  }
    
  public void execute(VirtualMachine vm) {
    vm.write();
  }
    
}
