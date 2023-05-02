package problems;

public class LeetCode5LongestPalindrome {
	public static void main(String[] args) {
		String s = "babad";
		System.out.println(longestPalindrome(s));
		String s2 = "baaccac";
		System.out.println(longestPalindrome(s2));
	}

	public static String longestPalindrome(String s) {
        String res = "";
        String temp = "";
        if(s.length()==1) return s;
        
		for(int i=0;i<s.length();i++) {
			// left edge:i,right edge:length-i+1
			int min = Math.min(i, s.length());
			if (res.length()> min*2) {
				break;
			}
			//odd
			for(int l=i, r=i;l>=0&&r<s.length();l--,r++) {
				if(s.charAt(l)==s.charAt(r)) {
					temp = s.substring(l,r+1);
					res = res.length()>temp.length()?res:temp;
				} else {
					if(l==r) {//only one
						temp = String.valueOf(s.charAt(l));
						res = res.length()>temp.length()?res:temp;
					}
					break;
				}
			}
			
			//even
			for(int l=i, r=i+1;l>=0&&r<s.length();l--,r++) {
				if(s.charAt(l)==s.charAt(r)) {
					temp = s.substring(l,r+1);
					res = res.length()>temp.length()?res:temp;
				} else {
					break;
				}
			}
		}
        return res;
    }
	
}
