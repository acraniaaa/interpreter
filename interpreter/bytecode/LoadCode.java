package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class LoadCode extends ByteCode {
  private int offset;
  private String variableName;

  public LoadCode(List<String> args) {
    this.offset = Integer.parseInt(args.get(0));
    this.variableName = args.get(1); 
  }

  public String toString() {
    return String.format("%-25s<load %s>",
      String.format("LOAD %d %s", this.offset, this.variableName),
      this.variableName
    );
  }
    
  public void execute(VirtualMachine vm) {
    vm.load( this.offset );
  }
    
}
