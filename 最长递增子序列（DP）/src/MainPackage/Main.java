package MainPackage;

public class Main {

	/*
	 * 对于一个数字序列，请设计一个复杂度为O(nlogn)的算法，返回该序列的最长上升子序列的长度，这里的子序列定义为这样
	 * 一个序列U1，U2...，其中Ui < Ui+1，且A[Ui] < A[Ui+1]。
	 * 给定一个数字序列A及序列的长度n，请返回最长上升子序列的长度。
	 */
	public int findLongest(int[] A, int n) {
		//以A[i]为最大元素的递增序列的长度
		int[] dp = new int[n];
		dp[0] = 1;
		int max = 0;
		for(int i = 1; i < n; i++){
			dp[i] = 1;
			for(int j = i - 1; j >= 0; j--){
				if(A[i] > A[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
				else
					dp[i] = Math.max(1, dp[i]);
			}
			max = Math.max(max, dp[i]);
		}
		return max;
    }
}
