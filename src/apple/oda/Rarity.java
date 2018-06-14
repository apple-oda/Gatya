package apple.oda;

public enum Rarity {
  Legend("レジェンド"), Gold("ゴールド"),
  Silver("シルバー"), Bronze("ブロンズ");

  private final String label;

  private Rarity(final String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  /** label から、定数オブジェクトを逆引きするメソッド */
  public static Rarity valueOfLabel(String label) {
    for (Rarity c : values()) {
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
