package tool;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 重み付き乱数
 * @author apple_oda
 * @param <T>
 */
public class WeightedRandom<T> {
  private Map<T, Number> map;

  public WeightedRandom() {
    map = new HashMap<>();
  }

  /** 要素とその要素が当選する確率（重み）を追加する */
  public void add(T t, Number weight) {
    map.put(t, weight);
  }

  /**
   * addされた全ての要素から抽選を行う
   * 一度もaddされてなかったらnullを返す
   * @return 当選した要素
   */
  public T getRandom() {
    // 当選の乱数生成
    double prob = Math.random();

    // 確率（重み）の合計を取得
    double totalWeight = getTotalWeight();

    for (Entry<T, Number> me : map.entrySet()) {
      // 全ての事象を1とした重みに変換
      // 当選の乱数から上記の重みを引いていく
      prob -= me.getValue().doubleValue() / totalWeight;

      // 引いて行って当選の乱数を0未満にした重みが当選
      // その重みを持っている要素を返す
      if (prob < 0) {
        return me.getKey();
      }
    }
    return null;
  }

  /** 重みの合計を返す */
  public double getTotalWeight() {
    double result = 0;
    for (Number n : map.values()) {
      result += n.doubleValue();
    }
    return result;
  }
}
