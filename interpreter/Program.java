package interpreter;

import interpreter.bytecode.*;
import java.util.HashMap;
import java.util.Vector;

public class Program {
  private Vector<ByteCode> bytecodes = new Vector<>();
  
  public ByteCode getCode(int programCounter) {
    return this.bytecodes.get(programCounter);
  }

  public void resolveSymbolicAddresses() {
    HashMap<String, Integer> addresses = new HashMap<>();

    for(int i = 0; i < this.bytecodes.size(); i++) {
      if( this.bytecodes.get(i).toString().contains("LABEL") ) {
        addresses.put(
          ( ( LabelCode )this.bytecodes.get(i) ).getLabel(),
          i
        );
      }
    }

    for(int i = 0; i < this.bytecodes.size(); i++) {
      ByteCode byteCode = this.bytecodes.get(i); 
      String byteCodeSubclass = byteCode.toString();
      if( byteCodeSubclass.contains("FALSEBRANCH") ) {
        FalsebranchCode falsebranchByteCode = ( FalsebranchCode ) byteCode;
        String label = falsebranchByteCode.getLabel();
        if( addresses.get( label ) == null) {
          continue;
        }
        falsebranchByteCode.setBranchTarget( addresses.get( label ) );
      }
      if( byteCodeSubclass.contains("GOTO") ) {
        GotoCode gotoByteCode = ( GotoCode )byteCode;
        String label = gotoByteCode.getLabel();
        if( addresses.get( label ) == null) {
          continue;
        }
        gotoByteCode.setBranchTarget( addresses.get( label ) );
      }
      if( byteCodeSubclass.contains("CALL") ) {
        CallCode callByteCode = ( CallCode )byteCode;
        String functionName = callByteCode.getFunctionName();
        if( addresses.get( functionName ) == null) {
          continue;
        }
        callByteCode.setBranchTarget( addresses.get( functionName ) );
      }
      
    }

  }

  public void addCode(ByteCode bytecode) {
    bytecodes.add(bytecode);
  }
}