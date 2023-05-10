package problems;

public class Leetcode33SearchinRotatedSortedArray {

  public static void main(String[] args) {
    int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
    int[] nums2 = { 2, 4, 5, 6, 7, 0, 1 };
    int[] nums3 = { 1, 2, 4, 5, 6, 7, 0 };
    int[] nums4 = { 0, 1, 2, 4, 5, 6, 7 };
    int[] nums5 = { 7, 0, 1, 2, 4, 5, 6 };
    int[] nums6 = { 6, 7, 0, 1, 2, 4, 5 };
    int[] nums7 = { 5, 6, 7, 0, 1, 2, 4 };
    System.out.println(findTarget(nums1, 0));
    System.out.println(findTarget(nums2, 0));
    System.out.println(findTarget(nums3, 0));
    System.out.println(findTarget(nums4, 0));
    System.out.println(findTarget(nums5, 0));
    System.out.println(findTarget(nums6, 0));
    System.out.println(findTarget(nums7, 0));
  }

  // 題目要求要在O(logN)，使用二分法
  public static int findTarget(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    if (right == 0 && nums[0] == target) {
      return 0;
    }
    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[right] == target) {
        return right;
      }
      if (nums[left] == target) {
        return left;
      }
      if (nums[mid] < nums[right]) {// 代表右邊是ascending
        if (nums[right] > target && nums[mid] < target) {
          left = mid + 1;
        } else {
          right = mid;
        }
      } else if (nums[mid] > nums[right]) {// 代表左邊是ascending
        if (nums[left] < target && nums[mid] > target) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
    }
    return -1;
  }
}
