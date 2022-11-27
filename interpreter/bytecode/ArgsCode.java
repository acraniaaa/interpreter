package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class ArgsCode extends ByteCode {
  private String byteCode = "ARGS";
  private int numOfArgs;

  public ArgsCode(List<String> args) {
    this.numOfArgs = Integer.parseInt(args.get(0));
  }

  public String toString() {
    return byteCode + " " + numOfArgs;
  }
    
  public void execute(VirtualMachine vm) {
    vm.createNewFrame(numOfArgs);
  }


}
