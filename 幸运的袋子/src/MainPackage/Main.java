package MainPackage;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			int arrs[] = new int[num];
			for(int i = 0; i < num; i++){
				int tmp = in.nextInt();
				arrs[i] = tmp;
			}
			
			Arrays.sort(arrs);
			System.out.println(getCount(arrs, 0, 0, 1));
		}
	}
	
	public static int getCount(int[] arrs, int index, long sum, long multi){
		int count = 0;
		for(int i = index; i < arrs.length; i++){
			sum += arrs[i];
			multi *= arrs[i];
			if(sum > multi)
				count = count + 1 + getCount(arrs, i + 1, sum, multi);
			else if(arrs[i] == 1)
				count += getCount(arrs, i + 1, sum, multi);
			else 
				break;
			sum -= arrs[i];
			multi /= arrs[i];
			while(i < arrs.length - 1 && arrs[i] == arrs[i + 1])
				i++;
		}
		return count;
	}
}
