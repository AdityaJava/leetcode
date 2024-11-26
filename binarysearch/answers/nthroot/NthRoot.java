package leetcode.binarysearch.answers.nthroot;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NthRoot {

    public int nthRoot(int power, int number) {
        int low = 1;
        int high = number;
        int mid = -1;
        int ans = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            ans = checkPower(power, mid, number);
            if (ans == 1) {
                return mid;
            } else if (ans == 2) {
                high = mid - 1;
            } else if (ans == -1) {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int checkPower(int power, int mid, int number) {
        BigDecimal ans = BigDecimal.valueOf(1);
        for (int i = 1; i <= power; i++) {
            ans = ans.multiply(BigDecimal.valueOf(mid));
            if (ans.compareTo(BigDecimal.valueOf(number)) == 1) {
                return 2;
            }
        }
        if (ans.equals( BigDecimal.valueOf(number))) {
            return 1;
        }
        //This means ans<number
        return -1;
    }

    public static void main(String[] args) {
//        int power = 3, number = 9;
//        int power = 2, number = 9;
//        int power = 9, number = 1953125;
        int power = 9, number = 262144;

        NthRoot nthRoot = new NthRoot();
        System.out.println(nthRoot.nthRoot(power, number));
    }
}
