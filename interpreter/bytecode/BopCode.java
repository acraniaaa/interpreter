package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

/*
 * BOP <binary op> BOP +
Pop top 2 levels of the stack and 
perform the indicated operation  
(+ - / * == != <= > >= < | &) 
The lower level in the stack is 
the first operand
 */
public class BopCode extends ByteCode {
    private String byteCode = "BOP ";
    private String arg;
    
    public BopCode(List<String> args) {
        this.arg = args.get(0);
    }

    public String toString() {
        return byteCode + arg;
    }
    
    public void execute(VirtualMachine vm) {
        // TODO Auto-generated method stub
        
    }
    
}
