package interpreter.bytecode;

import interpreter.VirtualMachine;

/* STORE n <id> STORE 2 i
 * Pop the top of the stack; store the 
value into the offset n from the start 
of the frame; <id> is used as a 
comment - it’s the variable’s name 
where the data is stored
 */
public class StoreCode extends ByteCode {
    private String byteCode;

    public String toString() {
        return byteCode;
    }
    
    public void execute(VirtualMachine vm) {
        // TODO Auto-generated method stub
        
    }
    
}