package interpreter;
import java.util.HashMap;

public class CodeTable {
  private static HashMap<String, String> ByteCodeMap = new HashMap<>();

  public static void init () {
    ByteCodeMap.put("ARGS", "ArgsCode");
    ByteCodeMap.put("BOP", "BopCode");
    ByteCodeMap.put("CALL", "CallCode");
    ByteCodeMap.put("DBG", "DbgCode");
    ByteCodeMap.put("FALSEBRANCH","FalsebranchCode");
    ByteCodeMap.put("GOTO", "GotoCode");
    ByteCodeMap.put("HALT", "HaltCode");
    ByteCodeMap.put("LABEL", "LabelCode");
    ByteCodeMap.put("LIT", "LitCode");
    ByteCodeMap.put("LOAD", "LoadCode");
    ByteCodeMap.put("POP", "PopCode");
    ByteCodeMap.put("READ", "ReadCode");
    ByteCodeMap.put("RETURN", "ReturnCode");
    ByteCodeMap.put("STORE", "StoreCode");
    ByteCodeMap.put("WRITE", "WriteCode");
  }

  public static String get(String code) {
    return ByteCodeMap.get( code );
  }
}