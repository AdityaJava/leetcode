package leetcode.arrays.subarraywithgivenxor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.interviewbit.com/problems/subarray-with-given-xor/
public class SubArrayWithGivenXOR {
    private int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> prefixXOR = new HashMap<>();
        int xr = 0;
        int x = 0;
        int count = 0;
        prefixXOR.put(0, 1);
        for (int i = 0; i < A.size(); i++) {
            xr = xr ^ A.get(i);
            x = xr ^ B;
            if (prefixXOR.containsKey(x)) {
                count = count + prefixXOR.get(x);
            }
            if (prefixXOR.containsKey(xr)) {
                prefixXOR.put(xr, prefixXOR.get(xr) + 1);
            } else {
                prefixXOR.put(xr, 1);
            }

        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4, 2, 2, 6, 4));
        int b = 6;

//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
//        int b = 0;

        SubArrayWithGivenXOR subArrayWithGivenXOR = new SubArrayWithGivenXOR();

        System.out.println(subArrayWithGivenXOR.solve(A, b));
    }
}
