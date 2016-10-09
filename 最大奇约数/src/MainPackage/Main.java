package MainPackage;

import java.util.*;

public class Main {

	/*
	 * С����һ�����۰����ߣ����Ҷ���һ����������Լ��ʮ�ָ���Ȥ��һ��С����������һ�����⣺ ���庯��f(x)Ϊx��������Լ����xΪ�������� ����:f(44) = 11.
	 * ���ڸ���һ��N����Ҫ��� f(1) + f(2) + f(3).......f(N)
	 * ���磺 N = 7 
	 * f(1) + f(2) + f(3) + f(4) + f(5) + f(6) + f(7) = 1 + 1 + 3 + 1 + 5 + 3 + 7 = 21
	 * С�׼�������������������ѣ���Ҫ�������һ���㷨�������� 
	 */
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			long n = in.nextInt();
			long sum = 0;
			while(n != 1){
				if(n % 2 == 0)
					sum += (n * n / 4);
				else
					sum += ((n + 1) * (n + 1) / 4);
				n /= 2;
			}
			System.out.println(sum + 1);
		}
	}
}
