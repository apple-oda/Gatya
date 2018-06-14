package apple.oda;

import java.util.Arrays;
import java.util.List;

import tool.Keyboard;
import tool.MyMath;

public class Gatya {

  /** ガチャ一回のカードを引く枚数 */
  private static final int ONE_GATYA_COUNT = 8;

  /** 欲しいカード */
  private Card selectedCard;

  /** ガチャの抽選で使う全カード */
  private CardManager cardManager;

  /** 使用ルピ */
  private int rupi;

  public Gatya() {
    init();
    play();
  }

  private void init() {
    cardManager = new CardManager();
  }

  public void play() {
    // タイトル
    title();
    // クラスの選択
    Crafts crafts = choiceCrafts();
    System.out.println(crafts.getLabel() + "を選択しました。");
    // 選択したクラスのレジェンドカード一覧を表示し欲しいカードを選ぶ
    selectedCard = choiceCard(crafts);
    System.out.println(selectedCard + "を選択しました。");
    System.out.println(selectedCard + "は第"
        + selectedCard.getPack() + "弾のカードパックです。");
  }

  /** タイトル表示 */
  private void title() {
    System.out.println("シャドバガチャシミュレーター");
  }

  /** クラスの選択 */
  private Crafts choiceCrafts() {
    System.out.println("クラスを番号で入力してください");
    List<Crafts> list = getCrafts();
    showCrafts(list);
    try {
      int craftsNumber = Keyboard.inputInt();
      return list.get(craftsNumber);
    } catch (IllegalArgumentException e) {
      System.out.println("不正なクラス名です。");
      System.out.println("ランダムで選択します。");
      return list.get(MyMath.random(0, list.size() - 1));
    }
  }

  /** 全クラスを取得 */
  private List<Crafts> getCrafts() {
    return Arrays.asList(Crafts.values());
  }

  /** 全クラスを表示 */
  private void showCrafts(List<Crafts> list) {
    for (int i = 0; i < list.size(); i++) {
      Crafts crafts = list.get(i);
      System.out.println("[" + i + "]" + crafts.getLabel());
    }
  }

  /** レジェンドカードを選択 */
  private Card choiceCard(Crafts crafts) {
    System.out.println("欲しいカードを番号で選択してください。");
    List<Card> list = getLegendCardList(crafts);
    showLegendCardList(list);
    try {
      int cardNumber = Keyboard.inputInt();
      return list.get(cardNumber);
    } catch (Exception e) {
      System.out.println("不正な値です。");
      System.out.println("ランダムで選択します。");
      return list.get(MyMath.random(0, list.size() - 1));
    }
  }

  /** レジェンドカードリストを取得 */
  private List<Card> getLegendCardList(Crafts crafts) {
    return cardManager.collectByCrafts(crafts)
        .collectByRarity(Rarity.Legend)
        .getList();
  }

  /** レジェンドカードリストを表示 */
  private void showLegendCardList(List<Card> list) {
    for (int i = 0; i < list.size(); i++) {
      Card card = list.get(i);
      System.out.println("[" + i + "]" + card.getName());
    }
  }

  //  public void gameMain() {
  //
  //    System.out.println("弾のカードパックを10回引きます。");
  //
  //    //    レジェンド　→　1.5％
  //    //    ゴールドレア　→　6.0％
  //    //    シルバーレア　→　25.0％
  //    //    ブロンズレア　→　67.5％
  //    //
  //    //    確定枠
  //    //    レジェンド　→　1.5％
  //    //    ゴールドレア　→　6.0％
  //    //    シルバーレア　→　92.5％
  //    //
  //    //    プレミア　→　8％
  //    WeightedRandom<Rarity> wr = new WeightedRandom<>();
  //    wr.add(Legend, 1.5);
  //    wr.add(Gold, 6);
  //    wr.add(Silver, 25);
  //    wr.add(Bronze, 67.5);
  //
  //    for (int i = 0; i < 10; i++) {
  //      for (int j = 0; j < 8; j++) {
  //        Rarity r = wr.getRandom();
  //        if (r == Rarity.Legend) {
  //          System.out.print(legendList.get(
  //              (int) (Math.random() * legendList.size())));
  //        } else {
  //          System.out.print(r);
  //        }
  //        System.out.print(" ");
  //      }
  //      System.out.println();
  //    }
  //
  //  }

  //  private List<Card> getbishopList() {
  //    List<Card> list = new ArrayList<>();
  //    list.add(new Card(8, BISHOP, Legend, "ケリュネイア"));
  //    list.add(new Card(8, BISHOP, Legend, "ツタンカーメン"));
  //    list.add(new Card(8, BISHOP, Legend, "盾の神・ブローディア"));
  //    list.add(new Card(7, BISHOP, Legend, "希望導く聖乙女・ジャンヌ"));
  //    list.add(new Card(7, BISHOP, Legend, "ヘヴンリーナイト"));
  //    list.add(new Card(6, BISHOP, Legend, "白翼の守護神・アイテール"));
  //    list.add(new Card(6, BISHOP, Legend, "邪教の権化"));
  //    list.add(new Card(5, BISHOP, Legend, "スノーホワイトプリンセス"));
  //    list.add(new Card(5, BISHOP, Legend, "黄金郷の獅子"));
  //    return list;
  //  }

}