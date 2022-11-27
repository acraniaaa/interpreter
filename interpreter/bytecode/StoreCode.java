package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class StoreCode extends ByteCode {
  private String byteCode = "STORE";
  private int offset;
  private String variableName;

  public StoreCode(List<String> args) {
    this.offset = Integer.parseInt(args.get(0));
    this.variableName =  args.get(1);
  }

  public String toString() {
    return this.byteCode + " " + this.offset + " " + this.variableName;
  }
    
  public void execute(VirtualMachine vm) {
    vm.store( this.offset );
  }

  public int getOffset() {
    return this.offset;
  }

  public String getVariableName() {
    return this.variableName;
  }
    
}
