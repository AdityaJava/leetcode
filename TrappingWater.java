package leetcode;

/**
 * TrappingWater
 */
public class TrappingWater {

  public int trap(int[] height) {
    int leftMax = 0, rightMax = 0;
    int left = 0, right = height.length - 1;
    int total = 0;
    while (left < right) {
      if (height[left] <= height[right]) {
        if (height[left] < leftMax) {
          total = total + (leftMax - height[left]);
        }
        else {
          leftMax = height[left];
        }
        left++;
      }
      else {
        if (height[right] < rightMax) {
          total = total + (rightMax - height[right]);
        }
        else {
          rightMax = height[right];
        }
        right--;
      }
    }
    return total;
  }

  public static void main(String[] args) {
    int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

    TrappingWater trappingWater = new TrappingWater();

    System.out.println(trappingWater.trap(height));
  }
}
