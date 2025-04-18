package leetcode.greedyalgorithm.assigncookies;

import java.util.Arrays;

/**
 * AssignCookies
 */
public class AssignCookies {


  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int greedPointer = 0;
    int satisfactionPointer = 0;
    while (greedPointer < g.length && satisfactionPointer < s.length) {
      if (s[satisfactionPointer] >= g[greedPointer]) {
        satisfactionPointer++;
        greedPointer++;
      }
      else {
        satisfactionPointer++;
      }
    }
    return greedPointer;
  }

  public static void main(String[] args) {
    //    int[] g = { 1, 2, 3 };
    //    int[] s = { 1, 1 };

    int[] g = { 10, 9, 8, 7 };
    int[] s = { 5, 6, 7, 8 };

    AssignCookies assignCookies = new AssignCookies();
    System.out.println(assignCookies.findContentChildren(g, s));
  }
}
