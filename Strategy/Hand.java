package Strategy;

public enum Hand {
  // じゃんけんの手を表す3つのenum定数
  ROCK("グー", 0),
  SCISSORS("チョキ", 1),
  PAPER("パー", 2);

  // enumが持つフィールド
  private String name; // じゃんけんの手の名前
  private int handvalue; // じゃんけんの手の値

  // ての値から定数を取得するメソッド
  private static Hand[] hand = {
    ROCK, SCISSORS, PAPER
  };

  // コンストラクタ
  Hand(String name, int handvalue) {
    this.name = name;
    this.handvalue = handvalue;
  }

  // ての値から定数を取得するメソッド
  public static Hand getHand(int handvalue) {
    return hand[handvalue];
  }

  // thisがhよりも強いときtrue
  public boolean isStrongerThan(Hand h) {
    return fight(h) == 1;
  }

  // thisがhよりも弱いときtrue
  public boolean isWeakerThan(Hand h) {
    return fight(h) == -1;
  }

  // じゃんけんの手を比較するメソッド
  private int fight(Hand h) {
    if (this == h) {
      return 0;
    } else if ((this.handvalue + 1) % 3 == h.handvalue) {
      return 1;
    } else {
      return -1;
    }
  }

  // じゃんけんの「手」の文字列表現を返す
  public String toString() {
    return name;
  }
}