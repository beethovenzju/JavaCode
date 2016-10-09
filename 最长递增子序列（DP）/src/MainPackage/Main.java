package MainPackage;

public class Main {

	/*
	 * ����һ���������У������һ�����Ӷ�ΪO(nlogn)���㷨�����ظ����е�����������еĳ��ȣ�����������ж���Ϊ����
	 * һ������U1��U2...������Ui < Ui+1����A[Ui] < A[Ui+1]��
	 * ����һ����������A�����еĳ���n���뷵������������еĳ��ȡ�
	 */
	public int findLongest(int[] A, int n) {
		//��A[i]Ϊ���Ԫ�صĵ������еĳ���
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
