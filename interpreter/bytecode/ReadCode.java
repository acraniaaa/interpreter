package interpreter.bytecode;

import interpreter.VirtualMachine;

/*
 * READ READ
Read an integer - prompt the 
user for input, and put the value 
just read on the top of the stack
 */
public class ReadCode extends ByteCode {
    private String byteCode;
    
    public String toString() {
        return byteCode;
    }
    
    public void execute(VirtualMachine vm) {
        // TODO Auto-generated method stub
        
    }
    
}
