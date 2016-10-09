package MainPackage;

public class Main {
	
	public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
		int[][] dp = new int[n + 1][m + 1];
		for(int j = 0; j <= m; j++)
			dp[0][j] = c0 * j;
		
		for(int i = 1; i <= n; i++)
			dp[i][0] = c1 * i;
		
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				if(A.charAt(i - 1) == B.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = dp[i - 1][j - 1] + c2;
				
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + c1);
				dp[i][j] = Math.min(dp[i][j], dp[i][j - 1 + c0]);
			}
		}
		return dp[n][m];
    }
}
