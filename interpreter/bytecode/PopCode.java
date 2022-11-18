package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;
/*
 * POP n POP 5 
         POP 1
 */
//Pop top n levels of the runtime stack
public class PopCode extends ByteCode {
    private String byteCode = "POP ";

    public PopCode(List<String> args) {
        this.byteCode += args.get(0);
    }

    public String toString() {
        return byteCode;
    }
    
    public void execute(VirtualMachine vm) {
        
    }
    
}
