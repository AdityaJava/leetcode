package leetcode.arrays.LongestSubArraywithSumK;

public class LongestSubArrayWithSumK {

    private static int findLongestSubArrayWithSumK(int A[], int N, int K) {
        int left = 0;
        int right = 0;
        int sum = A[0];
        int maxLength = 0;
        int newLength = 0;

        while (right < N) {
            while (sum > K && left <= right) {
                sum -= A[left];
                left++;
            }

            if (sum == K) {
                maxLength = getMaxlength(maxLength, right - left + 1);
            }

            right++;
            if (right < N) {
                sum += A[right];
            }
        }
        return maxLength;
    }

    private static int getMaxlength(int maxLength, int newLength) {
        return maxLength < newLength ? newLength : maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};

        System.out.println(LongestSubArrayWithSumK.findLongestSubArrayWithSumK(arr, arr.length, 15));

    }
}
