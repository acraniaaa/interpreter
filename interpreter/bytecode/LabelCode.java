package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class LabelCode extends ByteCode {
  private String byteCode = "LABEL";
  private String label;

  public LabelCode(List<String> args) {
    this.label = args.get(0);  
  }

  public String toString() {
    return this.byteCode + " " + this.label;
  }
    
  public void execute(VirtualMachine vm) {}

  public String getLabel() {
    return this.label;
  }
  
    
}
