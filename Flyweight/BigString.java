package Flyweight;

public class BigString {
  // 大きな文字の配列
  private BigChar[] bigchars;
  // コンストラクタ
  public BigString(String string) {
    bigchars = new BigChar[string.length()];
    BigCharFactory factory = BigCharFactory.getInstance();
    for (int i = 0; i < bigchars.length; i++) {
      bigchars[i] = factory.getBigChar(string.charAt(i));
    }
  }
  // 表示
  public void print() {
    for (int i = 0; i < bigchars.length; i++) {
      bigchars[i].print();
    }
  }
}