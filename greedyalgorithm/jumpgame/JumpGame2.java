package leetcode.greedyalgorithm.jumpgame;

/**
 * JumpGame2
 */
public class JumpGame2 {
  public int jump(int[] nums) {
    int farthest = 0;
    int left = 0, right = 0;
    int length = nums.length-1;
    int jumps = 0;
    while (right < length) {
      farthest = 0;
      for (int i = left; i <= right; i++) {
        farthest = Math.max(i + nums[i], farthest);
      }
      left = right + 1;
      right = farthest;
      jumps++;
    }
    return jumps;
  }

  public static void main(String[] args) {
    int[] nums = { 2, 3, 1, 1, 4 };
    //    int[] nums = { 1, 2, 1, 1, 1 };
    JumpGame2 jumpGame2 = new JumpGame2();
    System.out.println(jumpGame2.jump(nums));
  }
}
