package problems;

import java.util.Arrays;

public class LeetCode300LengthOfLIS {
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		lengthOfLIS(nums);
		
	}
	
	private static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] lengthArr = new int[length];
        Arrays.fill(lengthArr, 1);
        for (int i=1; i< length ; i++) {
            int val = nums[i];
            for(int j=0;j<i ;j++) {
                if (nums[j] < val) {
                    lengthArr[i] = Math.max(lengthArr[j]+1 , lengthArr[i]);
                }
            }
        }
        for (int i : lengthArr) {
			System.out.println(i);
		}
        return Arrays.stream(lengthArr).max().getAsInt();

    }
}
