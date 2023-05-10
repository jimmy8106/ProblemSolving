package problems;

public class Leetcode153FindMinimuminRotatedSortedArray {

  public static void main(String[] args) {
    int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
    int[] nums2 = { 3,4,5,1,2 };
    System.out.println(findMin(nums1));
    System.out.println(findMin(nums2));
  }

  //題目要求要在O(logN)，使用二分法
  public static int findMin(int[] nums) {
    int left = 0;
    int right = nums.length-1;
    while(left<right) {
      int mid = (left + right)/2;
      if(nums[mid] < nums[right]) {
        right= mid;
      } else if(nums[mid] > nums[right]) {
        left = mid+1;
      } else {//一排一樣的數字或者已經左右都指到最小值時
        right--;
      }
    }
    
    
    
    return nums[left];
  }
}
