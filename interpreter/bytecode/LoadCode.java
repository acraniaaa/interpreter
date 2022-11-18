package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

//LOAD n <id> LOAD 3 j
/*Push the value in the slot which is 
offset n from the start of the frame 
onto the top of the stack; <id> is 
used as a comment - it’s the 
variable’s name from which the data 
is loaded */
public class LoadCode extends ByteCode {
    private String byteCode;

    public LoadCode(List<String> asList) {
    }

    public String toString() {
        return byteCode;
    }
    
    public void execute(VirtualMachine vm) {
        // TODO Auto-generated method stub
        
    }
    
}
