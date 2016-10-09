package MainPackage;

import java.util.*;

public class Main {

	/*
	 *一个只包含'A'、'B'和'C'的字符串，如果存在某一段长度为3的连续子串中恰好'A'、'B'和'C'各有一个，那么这个字符串就是纯净的，否则这个字符串就是暗黑的。例如：
	 *BAACAACCBAAA 连续子串"CBA"中包含了'A','B','C'各一个，所以是纯净的字符串
	 *AABBCCAABB 不存在一个长度为3的连续子串包含'A','B','C',所以是暗黑的字符串
	 *你的任务就是计算出长度为n的字符串(只包含'A'、'B'和'C')，有多少个是暗黑的字符串。  
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
