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
      //�Ĥ@���|�ˬd i��word�r������ȬO�_���ۦP���r
      //���ӸܱNdp[i��word�r�������]�אּtrue
      for (String word : wordDict) {
        int subStringLen = i + word.length();
        //�W�X�ɽu ���U�@��
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
