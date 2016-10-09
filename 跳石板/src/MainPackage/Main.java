package MainPackage;

import java.util.*;

public class Main {

	/*
	 * С��������һ��ʯ��·ǰ��ÿ��ʯ���ϴ�1���ű��Ϊ��1��2��3.......
	 * ����ʯ��·Ҫ��������Ĺ������ǰ��������С�׵�ǰ���ڵı��ΪK�� ʯ�壬С�׵���ֻ����ǰ��K��һ��Լ��(����1��K)����
	 * ������K+X(XΪK��һ����1�ͱ����Լ��)��λ�á� С�׵�ǰ���ڱ��ΪN��ʯ�壬�����������ǡ��ΪM��ʯ��ȥ��С����֪��������Ҫ��Ծ���ο��Ե��
	 * ���磺
	 * N = 4��M = 24��
	 * 4->6->8->12->18->24
	 * ����С��������Ҫ��Ծ5�Σ��Ϳ��Դ�4��ʯ������24��ʯ�� 
	 */
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int m = in.nextInt();
			int[] arr = new int[m - n + 1];
			for(int i = 1; i < arr.length; i++)
				arr[i] = Integer.MAX_VALUE;
			
			for(int i = 0; i < arr.length; i++){
				int cur = n + i;
				if(arr[i] == Integer.MAX_VALUE)
					continue;
				for(int j = 2; j <= Math.sqrt(cur); j++){
					if(cur % j == 0){
						int to = i + j;
						if(to < arr.length)
							arr[to] = Math.min(arr[to], arr[i] + 1);
						to = i + cur / j;
						if(to < arr.length)
							arr[to] = Math.min(arr[to], arr[i] + 1);
					}
				}
			}
			if(arr[m - n] == Integer.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(arr[m - n]);
		}
	}
}
