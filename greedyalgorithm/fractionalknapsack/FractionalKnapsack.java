package leetcode.greedyalgorithm.fractionalknapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * FractionalKnapsack
 */
class Item {
  Double val;
  Double wt;
  Double ratio;

  public Item(Double val, Double wt) {
    this.val = val;
    this.wt = wt;
    this.ratio = val / wt;
  }

  public Double getRatio() {
    return ratio;
  }

  public void setRatio(Double ratio) {
    this.ratio = ratio;
  }
}

public class FractionalKnapsack {

  double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
    List<Item> items = new ArrayList<>();
    for (int i = 0; i < val.size(); i++) {
      Item item = new Item(Double.valueOf(val.get(i)), Double.valueOf(wt.get(i)));
      items.add(item);
    }
    items.sort(Comparator.comparing(Item::getRatio).reversed());
    int length = 0;
    double valSum = 0;
    while (length < items.size()) {
      if (capacity >= items.get(length).wt) {
        valSum = valSum + items.get(length).val;
        capacity = capacity - items.get(length).wt.intValue();
      }
      else {
        valSum = valSum + items.get(length).ratio * capacity;
        break;
      }
      length++;
    }
    return valSum;
  }

  public static void main(String[] args) {
    List<Integer> val = Arrays.asList(60, 100, 120);
    List<Integer> wt = Arrays.asList(10, 20, 30);
    int capacity = 50;
    FractionalKnapsack fractionalKnapsack = new FractionalKnapsack();
    System.out.println(fractionalKnapsack.fractionalKnapsack(val, wt, capacity));
  }
}
