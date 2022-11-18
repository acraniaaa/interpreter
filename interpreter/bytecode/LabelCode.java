package interpreter.bytecode;

import java.util.List;

import interpreter.VirtualMachine;

/*LABEL <label> LABEL xyz<<3>> 
LABEL Read
Target for branches 
(FALSEBRANCH, GOTO, CALL) */
public class LabelCode extends ByteCode {
    private String byteCode = "LABEL ";
    private String arg;

    //TODO add a new variable for the argument, if necessary
    // this means separating the byteCode and argument. If using toString(), just add them both
    public LabelCode(List<String> args) {
        this.arg += args.get(0);
    }

    public String toString() {
        return byteCode + arg;
    }
    
    public void execute(VirtualMachine vm) {
        // TODO Auto-generated method stub
    }
    
}
