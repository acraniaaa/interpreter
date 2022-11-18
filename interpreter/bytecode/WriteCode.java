package interpreter.bytecode;

import interpreter.VirtualMachine;

/*
 * WRITE WRITE
Write the value on top of the 
stack to the output, leaving the 
value on the top of the stack
 */
public class WriteCode extends ByteCode {
    private String byteCode;

    public String toString() {
        return byteCode;
    }
    
    public void execute(VirtualMachine vm) {
        // TODO Auto-generated method stub
        
    }
    
}