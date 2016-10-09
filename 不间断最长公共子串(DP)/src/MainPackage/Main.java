package MainPackage;

public class Main {
	
	public int findLongest(String A, int n, String B, int m) {
		int[][] dp = new int[n + 1][m + 1];
		int max = 0;
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				if(A.charAt(i - 1) == B.charAt(j - 1)){
						dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}
}
