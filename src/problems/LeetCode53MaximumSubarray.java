package problems;

public class LeetCode53MaximumSubarray {
  public static void main(String[] args) {
    int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    int[] nums2 = { 5, 4, -1, 7, 8 };
    System.out.println(maxSubArray(nums));
    System.out.println(maxSubArray(nums2));
  }

  public static int maxSubArray(int[] nums) {
    // 進階題leetcode.152
    int max = nums[0];
    int[] dp = new int[nums.length];//以dp[i]為結尾時最大的和
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
      if(dp[i] > max)
        max = dp[i];
    }
    return max;
  }
}
