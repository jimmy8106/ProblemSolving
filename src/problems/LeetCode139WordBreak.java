package problems;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LeetCode139WordBreak {
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		
	}
	
	private static boolean wordBreak(String s, List<String> wordDict)  {
		boolean[] dp = new boolean[wordDict.size()+1];
		dp[0] = true;//n+1, and a true for index 0 array
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				if (dp[j] && wordDict.contains(s.substring(j,i))){
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[wordDict.size()-1];
    }
}
