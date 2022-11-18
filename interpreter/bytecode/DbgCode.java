package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

//TODO remove all comments of bytecode to not lose points
//
public class DbgCode extends ByteCode {
    private String byteCode = "DBG ";
    private String arg;

    public DbgCode(List<String> args) {
        this.arg = args.get(0);
    }

    public String toString() {
        return byteCode + arg;
    }
    
    public void execute(VirtualMachine vm) {
        if(arg.equals("ON")) {
            vm.changeDebugStatus(true);
        } else if (arg.equals("OFF")) {
            vm.changeDebugStatus(false);
        }
    }
    
}
