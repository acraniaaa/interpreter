package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

/* STORE n <id> STORE 2 i
 * Pop the top of the stack; store the 
value into the offset n from the start 
of the frame; <id> is used as a 
comment - it’s the variable’s name 
where the data is stored
 */
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
    
}
