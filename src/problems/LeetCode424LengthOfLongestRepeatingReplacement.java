package problems;

public class LeetCode424LengthOfLongestRepeatingReplacement {
  public static void main(String[] args) {
    String s1 = "ABAB";
    int k1 = 2;
    String s2 = "AABABBA";
    int k2 = 1;
    System.out.println(characterReplacement(s1, k1));
    System.out.println(characterReplacement(s2, k2));
  }

  public static int characterReplacement(String s, int k) {
    int[] feq = new int[26];
    int len = s.length();
    int max = 0;
    int res = 0;
    // pointers of window
    int left = 0, right = 0;
    while (right < len) {
      // 某字母重複數
      feq[s.charAt(right) - 'A']++;
      max = Math.max(max, feq[s.charAt(right) - 'A']);
      right++;
      // 可以允許 max+k(k為可取代的個數)
      if (right - left > max + k) {
        feq[s.charAt(left) - 'A']--;
        left++;
      }
      res = Math.max(res, right - left);
    }
    return res;
  }
}
