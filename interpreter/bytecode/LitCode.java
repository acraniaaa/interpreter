package interpreter.bytecode;

import java.util.List;
import java.util.Vector;

import interpreter.VirtualMachine;

// LIT n LIT 5
//Load the literal value n
/*
 * LIT 0 <id> LIT 0 i
 * 
 * This form of the LIT was generated 
to load 0 on the stack in order to 
initialize the variable i to 0 and 
reserve space on the runtime stack 
for i
 */
public class LitCode extends ByteCode {
    private String byteCode = "LIT";
    private List<String> args;

    //TODO i should probably use a vector. LIT and LOAD, and other bytecodes probably have more than 1 argument
    //I guess i can make 2 arg variables, but ehh
    public LitCode(List<String> args) {
        this.args = args;
    }

    public String toString() {
        String code = this.byteCode;
        for(int i  = 0; i < this.args.size(); i++) {
            code += String.format(" %s",this.args.get(i));
        }
        return code;
    }
    
    public void execute(VirtualMachine vm) {
        // TODO Auto-generated method stub
        
    }
    
}
