package MainPackage;

import java.util.*;

public class Main {

	/*
	 * 我们这次招聘会一共有N个人，我们公司给大家准备了一些礼物，但是我们并不知道这些人具体喜欢什么，现在库房共有m种礼物，
	 * 每种礼物有Ci件，共N件。而我们大致知道每个人选择某种礼物的概率，即能知道Pij(编号为i的人选择第j种礼物的概率)。
	 * 现在所有人按编号依次领礼物（第1个人先领，第N个人最后领），领礼物时，参加者会按照预先统计的概率告诉准备者自己想要
	 * 哪一种礼物，如果该种礼物在他之前已经发放完了则他会领不到礼物，请帮我们计算出能能领到礼物的期望人数。
	 * 
	 * 输入描述:
	 * 第一行包含两个整数N(1≤N≤300),M(1≤M≤100)，用单个空格隔开。表示公有N个应聘者，M种礼物。
	 * 第二行为M个整数，依次为Ci，第i种礼物的个数。
	 * 接下来的N行，每行M个实数，一次为Pij，第i个人选择第j种礼物的概率。
	 */
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int m = in.nextInt();
			int cap[] = new int[m + 1];
			int max = 0;
			for(int i= 1; i <= m; i++){
				cap[i] = in.nextInt();
				max = Math.max(max, cap[i]);
			}
			
			double p[][] = new double[n + 1][m + 1];
			for(int i = 1; i <= n; i++){
				for(int j = 1; j <= m; j++)
					p[i][j] = in.nextDouble();
			}
			
			// dp[i][j][k] 表示前 i 个 人选择礼物后， 第 j 种礼物 还剩下 k 个的概率
			double[][][] dp = new double[n + 1][m + 1][max + 2];
			for(int j = 1; j <= m; j++)
				dp[0][j][cap[j]] = 1;
			
			double result = 0;
			for(int i = 1; i <= n; i++){
				for(int j = 1; j <= m; j++){
					for(int k = 0; k <= cap[j]; k++){
						dp[i][j][k] = dp[i - 1][j][k] * (1 - p[i][j]) + 
								dp[i - 1][j][k + 1] * p[i][j];
						if(k == 0)
							dp[i][j][k] += dp[i - 1][j][0] * p[i][j];
						
						if(i == n)
							result += (dp[i][j][k] * (cap[j] - k));
					}
				}
			}
		    System.out.println(String.format("%.1f", result));
		}
		in.close();
	}
}
