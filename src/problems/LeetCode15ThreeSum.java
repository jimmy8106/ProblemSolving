package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode15ThreeSum {
  public static void main(String[] args) {
    int[] nums = { -1, 0, 1, 2, -1, -4 };
    List<List<Integer>> list = threeSum(nums);
    for (List<Integer> n : list) {
      for (Integer i : n) {
        System.out.print(i + ",");
      }
      System.out.println("");
    }
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> set =  new HashSet<List<Integer>>();
    Arrays.sort(nums);
    // 排序過後才有辦法用雙指標
    for (int first = 0; first < nums.length - 2; first++) {
      // 使用while 兩個數指標 避免三個迴圈
      int second = first + 1;
      int third = nums.length - 1;
      while (second < third) {
        int sum = nums[first] + nums[second] + nums[third];
        if (sum == 0) {
          List<Integer> sum3 = Arrays.asList(nums[first], nums[second], nums[third]);
          set.add(sum3);
          second++;
          third--;
        } else if (sum > 0) {
          third--;
        } else if (sum < 0) {
          second++;
        }
      }
    }
    return new ArrayList<List<Integer>>(set);
  }
}
