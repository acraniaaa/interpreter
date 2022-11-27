package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class BopCode extends ByteCode {
  private String byteCode = "BOP";
  private String arg;
    
  public BopCode(List<String> args) {
    this.arg = args.get(0);  
  }

  public String toString() {
    return byteCode + " " + arg;
  }
    
  public void execute(VirtualMachine vm) {
    vm.executeBinaryOperation(arg);
        
  }
    
}
