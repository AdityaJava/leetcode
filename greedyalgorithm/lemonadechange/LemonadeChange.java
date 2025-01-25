package leetcode.greedyalgorithm.lemonadechange;

/**
 * LemonadeChange
 */
public class LemonadeChange {
  public boolean lemonadeChange(int[] bills) {
    int numberOfFives = 0, numberOfTens = 0;
    for (int i = 0; i < bills.length; i++) {
      if (bills[i] == 5) {
        numberOfFives++;
      }
      else if (bills[i] == 10) {
        if (numberOfFives != 0) {
          numberOfFives--;
          numberOfTens++;
        }
        else {
          return false;
        }
      }
      else if (bills[i] == 20) {
        if (numberOfTens != 0 && numberOfFives != 0) {
          numberOfFives--;
          numberOfTens--;
        }
        else if (numberOfFives >= 3) {
          numberOfFives -= 3;
        }
        else {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    //    int[] bill = { 5, 5, 5, 10, 20 };
    int[] bill = { 5, 5, 10, 10, 20 };
    LemonadeChange lemonadeChange = new LemonadeChange();
    System.out.println(lemonadeChange.lemonadeChange(bill));
  }
}
