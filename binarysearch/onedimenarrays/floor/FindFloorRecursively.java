package leetcode.binarysearch.onedimenarrays.floor;

public class FindFloorRecursively {

    private int findFloor(long arr[], int n, long x) {
        Integer answer = arr.length;
        answer = findFloorRecursively(arr, x, 0, arr.length - 1, answer);
        System.out.println(answer);
        return answer;
    }

    private int findFloorRecursively(long arr[], long x, int low, int high, Integer answer) {
        int median = (low + high) / 2;
        if (high < low) {
            if (answer == arr.length) {
                answer = -1;
            }
            return answer;
        }
        if (arr[median] == x) {
            answer = median;
        }
        if (arr[median] > x) {
            answer = findFloorRecursively(arr, x, low, median - 1, answer);
            return answer;
        } else {
            answer = median;
            answer = findFloorRecursively(arr, x, median + 1, high, answer);
            return answer;
        }
    }

    public static void main(String[] args) {
        long[] arr = {1, 2, 8, 10, 11, 12, 19};
//        int x = 0;
        int x = 5;
        FindFloorRecursively findFloorRecursively = new FindFloorRecursively();
        findFloorRecursively.findFloor(arr, arr.length, x);
    }
}
