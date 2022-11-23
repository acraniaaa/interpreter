package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

/*
 * CALL <funcname> CALL f CALL f<<3>>
 * Transfer control to the indicated 
function
 */
public class CallCode extends ByteCode {
    private String byteCode = "CALL ";
    private String arg;

    public CallCode(List<String> args) { 
        this.arg = args.get(0);
    }

    public String toString() {
        return byteCode + arg;
    }
    
    public void execute(VirtualMachine vm) {
        // TODO Auto-generated method stub
        
    }

    public Object getBranchTarget() {
        return null;
    }
    
}
