package MainPackage;

import java.util.*;

public class Main {

	/*
	 * ���������Ƹ��һ����N���ˣ����ǹ�˾�����׼����һЩ����������ǲ���֪����Щ�˾���ϲ��ʲô�����ڿⷿ����m�����
	 * ÿ��������Ci������N���������Ǵ���֪��ÿ����ѡ��ĳ������ĸ��ʣ�����֪��Pij(���Ϊi����ѡ���j������ĸ���)��
	 * ���������˰���������������1�������죬��N��������죩��������ʱ���μ��߻ᰴ��Ԥ��ͳ�Ƶĸ��ʸ���׼�����Լ���Ҫ
	 * ��һ��������������������֮ǰ�Ѿ����������������첻�����������Ǽ���������쵽���������������
	 * 
	 * ��������:
	 * ��һ�а�����������N(1��N��300),M(1��M��100)���õ����ո��������ʾ����N��ӦƸ�ߣ�M�����
	 * �ڶ���ΪM������������ΪCi����i������ĸ�����
	 * ��������N�У�ÿ��M��ʵ����һ��ΪPij����i����ѡ���j������ĸ��ʡ�
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
			
			// dp[i][j][k] ��ʾǰ i �� ��ѡ������� �� j ������ ��ʣ�� k ���ĸ���
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
