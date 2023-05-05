package problems;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LeetCode139WordBreak {
  public static void main(String[] args) {
    String[] wordDict = { "leet", "code" };
    String s = "leetcode";
    System.out.println(wordBreak(s, Arrays.asList(wordDict)));
  }

  private static boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;// n+1, and a true for index 0 array
    for (int i = 0; i < dp.length; i++) {
      if(!dp[i]) {
        continue;
      }
      //第一次會檢查 i到word字串長的值是否有相同的字
      //有個話將dp[i到word字串長的值]改為true
      for (String word : wordDict) {
        int subStringLen = i + word.length();
        //超出界線 換下一個
        if(subStringLen>s.length()) {
          continue;
        }
        if(s.substring(i, subStringLen).equals(word))
          dp[subStringLen] = true;
      }
    }

    return dp[s.length()];
  }
}
