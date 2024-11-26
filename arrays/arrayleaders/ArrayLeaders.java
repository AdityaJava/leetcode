package leetcode.arrays.arrayleaders;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders {
    private ArrayList<Integer> leaderInArray(int n, int[] nums) {
        int leader = nums[n - 1];
        ArrayList<Integer> leaders = new ArrayList<>();

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= leader) {
                leaders.add(leader);
                leader = nums[i];
            }
        }
        leaders.add(leader);
        Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
//        int arr[] = {9985, 9985, 8736, 8543, 7987, 6259 3725 867};
        ArrayLeaders arrayLeaders = new ArrayLeaders();
        arrayLeaders.leaderInArray(arr.length, arr).forEach(e -> {
            System.out.println(e);
        });
    }
}
