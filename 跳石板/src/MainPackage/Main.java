package MainPackage;

import java.util.*;

public class Main {

	/*
	 * 小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
	 * 这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数(不含1和K)步，
	 * 即跳到K+X(X为K的一个非1和本身的约数)的位置。 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
	 * 例如：
	 * N = 4，M = 24：
	 * 4->6->8->12->18->24
	 * 于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板 
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
