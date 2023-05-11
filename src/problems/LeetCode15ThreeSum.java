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
    // �ƧǹL��~����k��������
    for (int first = 0; first < nums.length - 2; first++) {
      // �ϥ�while ��Ӽƫ��� �קK�T�Ӱj��
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
