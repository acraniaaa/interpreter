package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

/*  ARGS n ARGS 4
 * 
 * Used prior to calling a function, 
where n is the number of arguments 
the function expects. 
This instruction is immediately 
followed by the CALL instruction; the 
function has n args so ARGS n 
instructs the interpreter to set up a 
new frame n down from the top, so it 
will include the arguments
 */
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
