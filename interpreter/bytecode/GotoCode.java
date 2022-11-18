package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

/*
 * GOTO <label> GOTO xyz<<3>>
 */
public class GotoCode extends ByteCode {
    private String byteCode = "GOTO ";
    private String arg;

    public GotoCode(List<String> args) {
        this.arg = args.get(0);
    }

    public String toString() {
        return byteCode + arg;
    }
    
    public void execute(VirtualMachine vm) {
        // TODO Auto-generated method stub
        
    }
    
}
