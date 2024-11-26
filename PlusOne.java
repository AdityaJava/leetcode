package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class PlusOne {

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = new int[]{9, 9, 9};
        plusOne.plusOne(digits);
    }

    public int[] plusOne(int[] digits) {
        int numberToAdd = 1;
        int sum = 0;
        List<Integer> digitList = Arrays.stream(digits).boxed().collect(Collectors.toList());
        List<Integer> newList = new ArrayList<>();
        int carry = 0;
        for (int i = digitList.size() - 1; i > -1; i--) {
            if (i == (digitList.size() - 1)) {
                sum = digitList.get(i) + 1;
            } else {
                sum = digitList.get(i) + carry;
            }
            carry = sum / 10;
            newList.add(sum > 9 ? sum % 10 : sum);
            sum = 0;
        }
        if (carry != 0) {
            newList.add(carry);
        }
        Collections.reverse(newList);
        return newList.stream().mapToInt(Integer::intValue).toArray();
    }

}