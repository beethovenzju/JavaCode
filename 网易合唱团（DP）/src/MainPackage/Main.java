package MainPackage;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int[] stu = new int[n + 1];
			for(int i = 1; i <= n; i++)
				stu[i] = in.nextInt();
			int k = in.nextInt();
			int d = in.nextInt();
			long fmax[][] = new long[k + 1][n + 1];
			long fmin[][] = new long[k + 1][n + 1];
			long maxValue = 0;
			for(int i = 1; i <= n; i++){
				fmax[1][i] = fmin[1][i] = stu[i];
				for(int j = 2; j <= k; j++){
					for(int t = i - 1; t >= 0 && i - t <= d; t--){
						fmax[j][i] = Math.max(fmax[j][i], Math.max(fmax[j - 1][t] * stu[i], fmin[j - 1][t] * stu[i]));
						fmin[j][i] = Math.min(fmin[j][i], Math.min(fmax[j - 1][t] * stu[i], fmin[j - 1][t] * stu[i]));
					}
					if(fmax[j][i] > maxValue)
						maxValue = fmax[j][i];
				}
				if(fmax[1][i] > maxValue)
					maxValue = fmax[1][i];
			}
			System.out.println(maxValue);
		}
	}
}
