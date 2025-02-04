package leetcode.greedyalgorithm.minimumplatforms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * MinimumPlatforms
 */
public class MinimumPlatforms {

  static int findPlatform(int arr[], int dep[]) {
    List<Platform> platformList = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      Platform platform = new Platform(arr[i], dep[i]);
      platformList.add(platform);
    }
    Collections.sort(platformList, (Platform p1, Platform p2) -> Integer.compare(p1.arrival, p2.arrival));
    //    platformList = platformList.stream().sorted(Comparator.comparing((Platform p) -> p.arrival)).collect(Collectors.toList());
    int platformCount = 1;
    int endingDep = -1;
    for (Platform platform : platformList) {
      if (endingDep > platform.arrival) {
        platformCount++;
      }
      endingDep = platform.departure;
    }
    return platformCount;
  }

  public static void main(String[] args) {
    //    int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
    //    int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };

    int[] arr = { 1114, 825, 357, 1415, 54 };
    int[] dep = { 1740, 1110, 2238, 1535, 2323 };

    System.out.println(MinimumPlatforms.findPlatform(arr, dep));
  }
}
