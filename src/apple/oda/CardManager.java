package apple.oda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import tool.FileReader;

public class CardManager {
  public static final String CARDFILEPATH = "CardList01.csv";

  private List<Card> cardList;

  public CardManager() {
    this(fileToCardList());
  }

  public CardManager(List<Card> cardList) {
    this.cardList = cardList;
  }

  /** ファイルからカードリストを生成 */
  private static List<Card> fileToCardList() {
    // ファイル読み込み
    List<String> all = new FileReader(CARDFILEPATH).getResource();

    // カード生成
    List<Card> list = new ArrayList<>();
    for (String s : all) {
      String[] arr = s.split(",");
      int pack = Integer.parseInt(arr[0]);
      Crafts crafts = Crafts.valueOfLabel(arr[1]);
      Rarity rarity = Rarity.valueOfLabel(arr[2]);
      String name = arr[3];
      // カードを生成してカードリストに追加
      list.add(new Card(pack, crafts, rarity, name));
    }
    return list;
  }

  /** カードを取得 */
  public Card getCard(int index) {
    return cardList.get(index);
  }

  /** カードリストを取得 */
  public List<Card> getList() {
    return cardList;
  }

  /** リーダーで抽出 */
  public CardManager collectByCrafts(Crafts crafts) {
    return collect(c -> c.getCrafts() == crafts);
  }

  /** パックで抽出 */
  public CardManager collectByPack(int pack) {
    return collect(c -> c.getPack() == pack);
  }

  /** レアリティで抽出 */
  public CardManager collectByRarity(Rarity rarity) {
    return collect(c -> c.getRarity() == rarity);
  }

  /** 名前で抽出 */
  public CardManager collectByName(String name) {
    return collect(c -> c.getName() == name);
  }

  /** プレミアムで抽出 */
  public CardManager collectbyPremium(boolean premium) {
    return collect(c -> c.isPremium() == premium);
  }

  public CardManager collectByLeaderSkin(boolean leaderSkin) {
    return collect(c -> c.isLeaderSkin() == leaderSkin);
  }

  /** 条件式で抽出 */
  private CardManager collect(Predicate<? super Card> predicate) {
    List<Card> tmp = cardList.stream()
        .filter(predicate)
        .collect(Collectors.toList());
    return new CardManager(tmp);
  }

}
