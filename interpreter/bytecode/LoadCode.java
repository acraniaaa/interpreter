package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

//LOAD n <id> LOAD 3 j
/*Push the value in the slot which is 
offset n from the start of the frame 
onto the top of the stack; <id> is 
used as a comment - it’s the 
variable’s name from which the data 
is loaded */
public class LoadCode extends ByteCode {
  private String byteCode = "LOAD";
  private int offset;
  private String variableName;

  public LoadCode(List<String> args) {
    this.offset = Integer.parseInt(args.get(0));
    this.variableName = args.get(1); 
  }

  public String toString() {
    return this.byteCode + " " + this.offset + " " + this.variableName;
  }
    
  public void execute(VirtualMachine vm) {
    vm.load( this.offset );
  }
    
}
