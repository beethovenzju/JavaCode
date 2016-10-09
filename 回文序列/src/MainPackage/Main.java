package MainPackage;

import java.util.Scanner;

public class Main {

	/*
	 * ���һ��������������֮���ԭ������һ���ľͳ���������������Ϊ�������С����磺
	 * {1, 2, 1}, {15, 78, 78, 15} , {112} �ǻ�������, 
	 * {1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} ���ǻ������С�
	 * ���ڸ���һ���������У�����ʹ��һ��ת��������
	 * ѡ�������������ڵ�����Ȼ��������Ƴ������������������������ֵĺͲ��뵽��������֮ǰ��λ��(ֻ����һ����)��
	 * ���ڶ�����������Ҫ���������Ҫ���ٴβ������Խ����ɻ������С�
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
