package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

public class DbgCode extends ByteCode {
  private String byteCode = "DBG";
  private int debugState;

  public DbgCode(List<String> args) {
    this.debugState = Integer.parseInt(args.get(0));
  }

  public String toString() {
    if( this.debugState == 1 ) {
      return this.byteCode + " ON";
    }
    return this.byteCode + " OFF";
  }
    
  public void execute(VirtualMachine vm) {
    if( this.debugState == 1 ) {
      vm.changeDebugStatus(true);
    } else {
      vm.changeDebugStatus(false);
    }
  }
    
}
