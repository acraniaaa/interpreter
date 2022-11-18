package interpreter.bytecode;

import interpreter.VirtualMachine;

/*
 * RETURN <funcname> RETURN f<<2>>
 * Return from the current function. 
<funcname> is used as a comment 
to indicate the function.
 */
/*RETURN RETURN Generated for intrinsic functions. */
public class ReturnCode extends ByteCode {
    private String byteCode;

    public String toString() {
        return byteCode;
    }

    public void execute(VirtualMachine vm) {
        // TODO Auto-generated method stub
        
    }
    
}
