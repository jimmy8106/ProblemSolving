package problems;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3LengthOfLongestSubstring {
  public static void main(String[] args) {
    String s1 = "abcacc";
    String s2 = "dffcf";
    System.out.println(lengthOfLongestSubstring(s1));
    System.out.println(lengthOfLongestSubstring(s2));
  }

// longest not repeating
  public static int lengthOfLongestSubstring(String s) {
    int length = s.length();
    Set<Character> set = new HashSet<>(); // not repeating char using set
    int leftP = 0;
    int rightP = 0;
    int output = 0;
    while (rightP < length) {
      char c = s.charAt(rightP);
      rightP++;
      // check if there is a repeating char in set
      while (set.contains(c)) { // move to l pointer to next widnow
        set.remove(s.charAt(leftP));
        leftP++;
      }
      set.add(c);

      output = Math.max(output, set.size());
    }
    return output;
  }
}
