package problems;

public class LeetCode1143LongestCommonSubsequence {
	public static void main(String[] args) {
		String text1 = "abcde";
		String text2 = "ace";
		
		System.out.println(longestCommonSubsequence(text1, text2));
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		int[][] res = new int[text1.length()][text2.length()];
		for(int i=0; i< text1.length() ; i++) {
			for(int j =0; j< text2.length() ; j++) {
				if (text1.charAt(i) == text2.charAt(j)) {// same char find last
					if (i==0||j==0) {
						res[i][j] = 1;
					} else {
						res[i][j] = res[i-1][j-1] +1;
					}
				} else {// not same find max of 2
					int up = 0;
					int left = 0;
					if(i>0) {
						left = res[i-1][j];
					} 
					if(j>0) {
						up = res[i][j-1];
					}
					res[i][j] = Math.max(up, left);
				}
			}
		}
		
		return res[text1.length()-1][text2.length()-1];
	}
}
