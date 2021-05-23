package com.samples.strings;

public class CommonChild {

	public static int maxLength(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		int[][] c = new int[n1+1][n2+1];
		
		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					c[i][j] = c[i-1][j-1] + 1;
				} else {
					c[i][j] = Math.max(c[i-1][j], c[i][j-1]);					
				}
			}
		}
		
		return c[n1][n2];
	}
}
