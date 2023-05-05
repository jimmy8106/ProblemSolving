package problems;

public class LeetCode152MaximumProductSubarray {
  public static void main(String[] args) {
    int[] nums = { 2, 3, - 2, 4 };
    int[] nums2 = { 4, 1, 0, -2, 4, -7, 1, 0, 8, 1, -10, -1 };
    System.out.println(maxProduct(nums));
    System.out.println(maxProduct(nums2));
  }

  public static int maxProduct(int[] nums) {
    // Ãþ¦üleetcode.53
    int maxP = nums[0];
    int minP = nums[0];
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int temp = maxP;
      maxP = Math.max(nums[i], Math.max(maxP * nums[i], minP * nums[i]));
      minP = Math.min(nums[i], Math.min(temp * nums[i], minP * nums[i]));
      result = Math.max(result, maxP);
    }
    return result;
  }
}
