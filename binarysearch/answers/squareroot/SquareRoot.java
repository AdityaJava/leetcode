package leetcode.binarysearch.answers.squareroot;

public class SquareRoot {

    private static long floorSqrt(long n) {
        long low = 1;
        long high = n / 2;
        long mid = -1;
        long answer = -1;

        if (n == 1) return 1;

        if (n == 0) return 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if ((mid * mid) <= n) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        //SquareRoot.floorSqrt(5);
        System.out.println(SquareRoot.floorSqrt(1));
    }
}
