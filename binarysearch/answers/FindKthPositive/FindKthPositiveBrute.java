package leetcode.binarysearch.answers.FindKthPositive;

public class FindKthPositiveBrute {
    // assume you have an empty array and we have some k value, say k = 4the missing number, so in this case the missing value would be 4
    //
    //Case 1:- where the value at a index in the array < k
    // now just consider the empty array again and we added a number smaller than k to it, say 2,
    // so now when we again try to find the 4th missing number we would get it as 5 ( as 1 3 4 5 , as 2 already present in
    // the array, hence the missing value shifts by one position ahead and 5 is the 4th missing value),
    // hence whenever we get a number in the array smaller than k, the kth missing value shifts by position ahead
    //
    //Case2 :- where value at a index in array > k
    //
    //now consider empty array again and we added a number greater than k, assume k = 4 and we added 7 to it,
    // here the kth missing element will be 4 itself, as even though seven was added -
    // it indicated that the array might or might not contain the first 6 numbers and as the
    // k = 4 value is lesser than 7, so this kth value would also come under missing value,
    // and as 7 > k, so no effect on k occur. So k is the missing element
    public int findKthPositiveBrute(int[] arr, int k) {
        int originalK = k;
        if (k < arr[0]) {
            return k;
        }

        for (int element : arr) {
            if (element <= k) {
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
//        int[] arr = {2, 3, 4, 7, 11};
//        int k = 5;
//
        int[] arr = {1, 2, 3, 4};
        int k = 2;

//        int[] arr = {5, 6, 7, 8, 9};
//        int k = 9;

        FindKthPositiveBrute findKthPositiveBrute = new FindKthPositiveBrute();
        System.out.println(findKthPositiveBrute.findKthPositiveBrute(arr, k));
    }
}
