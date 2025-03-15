package Flyweight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BigChar {
  // 文字の名前
  private char charname;
  // 大きな文字を表現する文字列
  private String fontdata;

  public BigChar(char charname) {
    this.charname = charname;
    try {
      fontdata = new String(Files.readAllBytes(Paths.get("big" + charname + ".txt")));
    } catch (IOException e) {
      fontdata = charname + "?";
    }
  }
  public void print() {
    System.out.println(fontdata);
  }
}