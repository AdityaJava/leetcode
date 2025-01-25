package leetcode.greedyalgorithm.minimumcoins;

import java.util.Arrays;
import java.util.Collections;

/**
 * MinimumCoins
 */
public class MinimumCoins {

  public int minCoins(int coins[], int sum) {
    int i = 0;
    int coinCount = 0;
    Integer[] coinsI = Arrays.stream(coins).boxed().toArray(Integer[]::new);
    Arrays.sort(coinsI, Collections.reverseOrder());
    while (sum > 0 && i < coinsI.length) {
      if (coinsI[i] <= sum) {
        sum = sum - coinsI[i];
        coinCount++;
      }
      else {
        i++;
      }
    }
    return sum == 0 ? coinCount : -1;
  }

  public static void main(String[] args) {
    //    int coins[] = { 9, 6, 5, 1 }, sum = 19;
    int coins[] = { 936, 917, 205, 483, 345, 307, 117, 20, 679, }, sum = 662;

    MinimumCoins minimumCoins = new MinimumCoins();
    System.out.println(minimumCoins.minCoins(coins, sum));
  }
}
