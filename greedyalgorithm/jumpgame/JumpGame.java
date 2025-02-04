package leetcode.greedyalgorithm.jumpgame;

/**
 * JumpGame
 */
public class JumpGame {

  public boolean canJump(int[] nums) {
    if (nums.length == 1 || nums.length == 0) {
      return true;
    }
    int maxIndex = 0;
    int indexTillItCanGo = 0;
    for (int i = 0; i < nums.length; i++) {
      indexTillItCanGo = (nums[i] + i);
      if (maxIndex < indexTillItCanGo) {
        maxIndex = indexTillItCanGo;
      }
      if (maxIndex == (nums.length - 1)) {
        return true;
      }
      if (maxIndex == i) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] nums = { 2, 3, 1, 1, 4 };
    //    int[] nums = { 3, 2, 1, 0, 4 };

    JumpGame jumpGame = new JumpGame();
    System.out.println(jumpGame.canJump(nums));
  }
}
