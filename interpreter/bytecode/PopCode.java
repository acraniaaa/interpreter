package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class PopCode extends ByteCode {
  private String byteCode = "POP";
  private int amountToPop;

  public PopCode(List<String> args) {
    this.amountToPop = Integer.parseInt(args.get(0)); 
  }

  public String toString() {
    return this.byteCode + " " + this.amountToPop;
  }
    
  public void execute(VirtualMachine vm) {
    vm.pop( this.amountToPop );
  }
    
}
