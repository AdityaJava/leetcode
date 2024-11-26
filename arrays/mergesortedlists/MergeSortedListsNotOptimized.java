package leetcode.arrays.mergesortedlists;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedListsNotOptimized {

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {

        ArrayList<Integer> list3 = new ArrayList<>();

        int posArr1 = 0;
        int posArr2 = 0;

        while (posArr1 < arr1.length && posArr2 < arr2.length) {
            if (arr1[posArr1] < arr2[posArr2]) {
                if (!list3.contains(arr1[posArr1])) {
                    list3.add(arr1[posArr1]);
                }
                posArr1++;
            } else if (arr1[posArr1] == arr2[posArr2]) {
                if (!list3.contains(arr1[posArr1])) {
                    list3.add(arr1[posArr1]);
                }
                posArr1++;
                posArr2++;
            } else {
                if (!list3.contains(arr2[posArr2])) {
                    list3.add(arr2[posArr2]);
                }
                posArr2++;
            }
        }
        for (int i = posArr1; i < arr1.length; i++) {
            if (!list3.contains(arr1[posArr1])) {
                list3.add(arr1[posArr1]);
            }
            posArr1++;
        }


        for (int i = posArr2; i < arr2.length; i++) {
            if (!list3.contains(arr2[posArr2])) {
                list3.add(arr2[posArr2]);
            }
            posArr2++;
        }
        return list3;
    }


    public static void main(String[] args) {
//        int arr1[] = {1, 2, 3, 4, 5};
//        int arr2[] = {1, 2, 3, 6, 7};

//        -8 -3 -3 -2 0 1 2 2 6
//                -9 -9 0
        int arr1[] = {-8, -3, -3, -2, 0, 1, 2, 2, 6};
        int arr2[] = {-9, -9, 0};


        List<Integer> list3 = MergeSortedListsNotOptimized.findUnion(arr1, arr2, arr1.length, arr2.length);
        System.out.println("saa");
    }
}
