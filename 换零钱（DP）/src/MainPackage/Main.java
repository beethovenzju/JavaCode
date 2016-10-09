package MainPackage;

public class Main {

	/*
	 * ��һ������changes��changes�����е�ֵ��Ϊ�����Ҳ��ظ���ÿ��ֵ����һ����ֵ�Ļ��ң�ÿ����ֵ�Ļ��ҿ���ʹ�������ţ�
	 * ����һ������ֵx�������һ����Ч�㷨������������ֵ�ķ�����������һ��int����changes������������Ǯ��ͬʱ��������
	 * ��Сn���������һ��������x���뷵�����x�ķ���������֤nС�ڵ���100��xС�ڵ���10000��
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
