package MainPackage;

public class Main {

	/*
	 * ����쳲������������⣬���Ƕ��ǳ���Ϥ��ͨ�����ƹ�ʽF(n) = F(n - 1) + F(n - 2)�����ǿ���������ʱ���������n��F(n)��
	 * ���ڿ���쳲������ļ�ǿ�棬����Ҫ�������n�ķ�ΧΪint��Χ�ڵķǸ������������һ����Ч�㷨�������n��F(n-1)����һ��쳲�������ΪF(0) = 1��
	 * ����һ���Ǹ��������뷵��쳲��������еĵ�n�Ϊ�˷�ֹ������뽫���Mod 1000000007��
	 */
	public int getNthNumber(int n) {
		long[][] base = {{1, 1}, {1, 0}};
		long[][] result = new long[2][2];
		for(int i = 0; i < 2; i++)
			result[i][i] = 1;
		
		int p = n - 1;
		while(p != 0){
			if((p & 1) != 0)
				result = multi(result, base);
			base = multi(base, base);
			p = p / 2;
		}
		
		return (int)(result[1][0] + result[1][1]) % 1000000007;
	}
	
	/*public long[][] multi(long[][] m1, long[][] m2){
        long[][] sum = new long[m1.length][m2[0].length];
        for(int i = 0; i < m1.length; i++){
            for(int j = 0; j < m2[0].length; j++){
                for(int k = 0; k < m1[0].length; k++){
                    sum[i][j] += m1[i][k]*m2[k][j];
                     
                }
                sum[i][j] = (long)(sum[i][j] % 1000000007);
            }
        }
        return sum;
    }*/
	
	private long[][] multi(long[][] a, long[][] b){
		long[][] tmp = new long[2][2];
		tmp[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
		tmp[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
		tmp[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
		tmp[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];
		
		tmp[0][0] = tmp[0][0] % 1000000007;
		tmp[0][1] = tmp[0][1] % 1000000007;
		tmp[1][0] = tmp[1][0] % 1000000007;
		tmp[1][1] = tmp[1][1] % 1000000007;
		
		return tmp;
	}
	
	public static void main(String[] args){
		Main main = new Main();
		System.out.println(main.getNthNumber(13));
	}
}
