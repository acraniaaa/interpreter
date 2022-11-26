package interpreter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import interpreter.bytecode.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class ByteCodeLoader {
  private BufferedReader source; 

  public ByteCodeLoader( String byteCodeFile ) throws IOException {
    source = new BufferedReader( new FileReader( byteCodeFile ) );
  }

  public Program loadCodes() {
    Program program = new Program();
    while( true ) {
      try {
        String[] fullByteCode = this.read().split(" ");
        List<String> args = new ArrayList<>();
        for(int i = 1; i < fullByteCode.length; i++) {
          args.add( fullByteCode[i] );
        }
        
        String byteCodeSubclass = "interpreter.bytecode." + CodeTable.get( fullByteCode[0] );
        ByteCode byteCode = 
        (ByteCode) Class
        .forName( byteCodeSubclass )
        .getConstructor( List.class )
        .newInstance( args );
        program.addCode( byteCode );

      } catch ( Exception e ) {
        break;
      }
    }

    program.resolveSymbolicAddresses();
    return program;
  }

  public String read() throws IOException {
    String nextLine = source.readLine();
    if( nextLine == null ) {
      throw new IOException();
    }
    return nextLine;
  }


}