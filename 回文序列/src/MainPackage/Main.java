package MainPackage;

import java.util.Scanner;

public class Main {

	/*
	 * 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
	 * {1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列, 
	 * {1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
	 * 现在给出一个数字序列，允许使用一种转换操作：
	 * 选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
	 * 现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。
	 */
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)
				arr[i] = in.nextInt();
			
			int left = 0, right = n - 1;
			int count = 0;
			while(left < right){
				if(arr[left] < arr[right]){
					arr[left + 1] += arr[left];
					left++;
					count++;
				}
				else if(arr[left] > arr[right]){
					arr[right - 1] += arr[right];
					right--;
					count++;
				}
				else{
					left++;
					right--;
				}
			}
			System.out.println(count);
		}
	}
}
