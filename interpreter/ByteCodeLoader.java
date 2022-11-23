package interpreter;

import java.io.IOException;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;

public class ByteCodeLoader {
  private BufferedReader source; 
  private HashMap<Integer, String[]> programMap;
  private int lineNumber = 0;

  public ByteCodeLoader(String byteCodeFile) throws IOException {
    programMap = new HashMap<>();
    source = new BufferedReader( new FileReader( byteCodeFile ) );
  }

  public Program loadCodes() {

    while( true ) {
      try {
        String[] byteCode = this.read().split(" ");
        programMap.put(lineNumber, byteCode);
      } catch (Exception e) {
        break;
      }
    }
    Program program = new Program();
    program.setProgramMap(programMap);
    return program;
  }

  public String read() throws IOException {
    String nextLine = source.readLine();
    lineNumber++;
    if( nextLine == null ) {
      throw new IOException();
    }
    return nextLine;
  }


}