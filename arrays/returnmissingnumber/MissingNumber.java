package leetcode.arrays.returnmissingnumber;

//https://leetcode.com/problems/missing-number/
/*
Video Link :- https://youtu.be/bYWLJb3vCWY?t=627
^ = XOR in Java
2 ^ 2 = 0
2 ^ 0 = 2

So for list [0,1,3]

Original list will be [0,1,2,3]

[0 ^ 1 ^ 3] ^ [0 ^ 1 ^ 2 ^ 3] = [[0^0] ^ [1^1] ^ [3^3] ^ [2]] = 0 ^ 0 ^ 0 ^ 2 = 2 = Missing Number
 */

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int numbersTo = nums.length;

        int[] actualNumbers = new int[numbersTo+1];
        for (int i = 0; i <= numbersTo; i++) {
            actualNumbers[i] = i;
        }

        int xorOfActualNumbers = 0;
        for (int actualNumber : actualNumbers) {
            xorOfActualNumbers = actualNumber ^ xorOfActualNumbers;
        }

        int xorOfGivenNumbers = 0;
        for (int number : nums) {
            xorOfGivenNumbers = number ^ xorOfGivenNumbers;
        }
        int missingNumber = xorOfActualNumbers ^ xorOfGivenNumbers;
        return missingNumber;

    }


    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        MissingNumber.missingNumber(nums);
    }

}
