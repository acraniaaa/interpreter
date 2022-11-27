package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;
import java.util.Scanner;
/*
 * READ READ
Read an integer - prompt the 
user for input, and put the value 
just read on the top of the stack
 */
public class ReadCode extends ByteCode {
  private String byteCode = "READ";
  
  public ReadCode(List<String> args) {}

  public ReadCode() {}

  public String toString() {
    return this.byteCode;
  }
    
  public void execute(VirtualMachine vm) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a value: ");
    int input = scanner.nextInt();
    vm.push( input );
    scanner.close();
  }
    
}
