package apple.oda;

public enum Crafts {
  ELF("エルフ"), ROYAL("ロイヤル"), WITCH("ウィッチ"),
  DRAGON("杉田"), NECROMANCER("ネクロマンサー"),
  VAMPIRE("ヴァンパイア"), BISHOP("ビショップ"), NEMESIS("ネメシス"),
  NEUTRAL("ニュートラル");

  private final String label;

  private Crafts(final String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  /** label から、定数オブジェクトを逆引きするメソッド */
  public static Crafts valueOfLabel(String label) {
    for (Crafts c : values()) {
      if (label.equals(c.getLabel())) { // label が一致するものを探す
        return c;
      }
    }
    throw new IllegalArgumentException();
  }

  @Override
  public String toString() {
    return getLabel();
  }

}
