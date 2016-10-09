package MainPackage;

public class Main {

	public boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        if(n + m != v)
        	return false;
		
		boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        
        for(int i = 1; i <= m; i++){
        	if(B.charAt(i - 1) == C.charAt(i - 1))
        		dp[0][i] = true;
        	else
        		break;
        }
        for(int j = 1; j <= n; j++){
        	if(A.charAt(j - 1) == C.charAt(j - 1))
        		dp[j][0] = true;
        	else 
        		break;
        }
        
        for(int i = 1; i <= n; i++){
        	for(int j = 1; j <= m; j++){
        		if(dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1))
        			dp[i][j] = true;
        		if(dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1))
        			dp[i][j] = true;
        	}
        }
        
        return dp[n][m];
    }
}
