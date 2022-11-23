package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;
/*
 * FALSEBRANCH <label> ; FALSEBRANCH xyz<<3>>
 */
/*Pop the top of the stack; if it’s false 
(0) then branch to <label>, else 
execute the next byte code
 */
public class FalsebranchCode extends ByteCode {
    private String byteCode = "FALSEBRANCH ";
    private String arg;
    //resolve symbolic addressses; basically, tranform the label into an int
    //that contains the location of the label
    public FalsebranchCode(List<String> args) {
        this.arg += args.get(0);
    }

    public String toString() {
        return byteCode + arg;
    }
    
    public void execute(VirtualMachine vm) {
        vm.checkTopOfStack(); //will change this
        
    }

    public Object getBranchTarget() {
        return null;
    }
    
}
