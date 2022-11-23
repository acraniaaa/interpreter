package interpreter;

import interpreter.bytecode.ByteCode;
import java.util.HashMap;

public class Program {
  private HashMap<Integer, String[]> programMap;
  
  public ByteCode getCode(int programCounter) {
    return null;
  }

  public void resolveSymbolicAddresses() {
    
  }

  public void addCode(ByteCode bytecode) {
  }

  public void setProgramMap(HashMap<Integer,String[]> programMap) {
    this.programMap = programMap;
  }
}