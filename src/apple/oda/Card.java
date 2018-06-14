package apple.oda;

public class Card {

  private int pack;
  private Crafts crafts;
  private Rarity rarity;
  private String name;
  private boolean premium;
  private boolean leaderSkin;

  public Card(int pack, Crafts crafts, Rarity rarity, String name) {
    this.pack = pack;
    this.crafts = crafts;
    this.rarity = rarity;
    this.name = name;
  }

  public int getPack() {
    return pack;
  }

  public Crafts getCrafts() {
    return crafts;
  }

  public Rarity getRarity() {
    return rarity;
  }

  public String getName() {
    return name;
  }

  public boolean isPremium() {
    return premium;
  }

  public void setPremium(boolean premium) {
    this.premium = premium;
  }

  public boolean isLeaderSkin() {
    return leaderSkin;
  }

  public void setLeaderSkin(boolean leaderSkin) {
    this.leaderSkin = leaderSkin;
  }

  @Override
  public String toString() {
    return getName();
  }

}
