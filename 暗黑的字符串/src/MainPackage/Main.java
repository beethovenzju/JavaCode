package MainPackage;

import java.util.*;

public class Main {

	/*
	 *һ��ֻ����'A'��'B'��'C'���ַ������������ĳһ�γ���Ϊ3�������Ӵ���ǡ��'A'��'B'��'C'����һ������ô����ַ������Ǵ����ģ���������ַ������ǰ��ڵġ����磺
	 *BAACAACCBAAA �����Ӵ�"CBA"�а�����'A','B','C'��һ���������Ǵ������ַ���
	 *AABBCCAABB ������һ������Ϊ3�������Ӵ�����'A','B','C',�����ǰ��ڵ��ַ���
	 *���������Ǽ��������Ϊn���ַ���(ֻ����'A'��'B'��'C')���ж��ٸ��ǰ��ڵ��ַ�����  
	 */
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			if(n == 1){
				System.out.println(3);
				continue;
			}
			else if(n == 2){
				System.out.println(9);
				continue;
			}
			
			long[] s = new long[n + 1];
			long[] d = new long[n + 1];
			s[2] = 3;
			d[2] = 6;
			for(int i = 3; i <= n; i++){
				s[i] = s[i - 1] + d[i - 1];
				d[i] = s[i - 1] * 2 + d[i - 1];
			}
			System.out.println(s[n] + d[n]);
		}
	}
}
