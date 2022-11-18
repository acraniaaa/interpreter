package interpreter.bytecode;

import interpreter.VirtualMachine;
// HALT HALT
//Halt execution
public class HaltCode extends ByteCode {
    private String byteCode = "HALT";

    public String toString() {
        return byteCode;
    }
    
    public void execute(VirtualMachine vm) {
        vm.haltProgram();
    }
    
}
