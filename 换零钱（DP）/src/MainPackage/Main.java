package MainPackage;

public class Main {

	/*
	 * 有一个数组changes，changes中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，
	 * 对于一个给定值x，请设计一个高效算法，计算组成这个值的方案数。给定一个int数组changes，代表所以零钱，同时给定它的
	 * 大小n，另外给定一个正整数x，请返回组成x的方案数，保证n小于等于100且x小于等于10000。
	 */
	public int countWays(int[] changes, int n, int x) {
		int[] dp = new int[x + 1];
		dp[0] = 1;
		for(int i = 0; i < n; i++){
			for(int j = 0; j + changes[i] <= x; j++){
				dp[j + changes[i]] += dp[j];
			}
		}
		return dp[x];
    }
}
