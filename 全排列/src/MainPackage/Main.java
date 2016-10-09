package MainPackage;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static int count = 0;
	public static void main(String[] args){
		int[] arr = {9, 2, 6, 5, 2, 0};
		arr = changeOrder(arr);
		Perm(arr, 0, arr.length - 1);
		/*int tmp = 0;
		do{
			tmp++;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < arr.length; i++)
				sb.append(arr[i]);
			System.out.println("第" + tmp + "个全排序为：" + sb);
		}while(next(arr));*/
	}
	
	public static int[] changeOrder(int[] arr){
		List<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i < arr.length; i++)
			list.add(arr[i]);
		
		Collections.sort(list);
		for(int i = 0; i < arr.length; i++){
			arr[i] = list.get(i);
		}
		return arr;
	}
	
	public static boolean isToSwap(int[] arr, int a, int b){
		int tmp = arr[b];
		for(int i = a ; i < b; i++){
			if(arr[i] == tmp)
				return false;
		}
		return true;
	}
	
	public static void swap(int[] arr, int a, int b){
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	
	//递归求全排序
	public static void Perm(int[] arr, int low, int high){
		if(low == arr.length - 1){
			count++;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < arr.length; i++)
				sb.append(arr[i]);
			System.out.println("第" + count + "个全排序为：" + sb);
		}
		else{
			for(int i = low; i < arr.length; i++){
				if(isToSwap(arr, low, i)){
					swap(arr, low, i);
					Perm(arr, low + 1, high);
					swap(arr, low, i);
				}
			}
		}
	}
	
	//非递归求全排序
	public static boolean next(int[] arr){
		int n = arr.length;
		int i = n - 1;
		//从数组后面往前找到第一个比后面的数小的地方  
		for(; i >= 1; i--){
			if(arr[i] > arr[i - 1])
				break;
		}
		
		//整个数组都是逆序，说明是已是排列最后一个  
		if(i == 0)
			return false;//没有下一个 
		
		int cur = arr[i - 1];
		int index = i;
		int min = arr[i];
		for(int j = i; j < n; j++){
			//再往后找比v[i-1]大的数中最小的一个 
			if(arr[j] > cur && arr[j] <= min){
				index = j;
				min = arr[j];
			}
		}
		arr[i - 1] = min;
		arr[index] = cur;
		reverse(arr, i, n - 1);
		return true;
	}
	
	public static void reverse(int[] arr, int low, int high){
		int count = high - low + 1;
		if(count <= 0)
			return;
		
		int[] tmp = new int[count];
		for(int i = 0; i < count; i++){
			tmp[i] = arr[high - i];
		}
		for(int i = 0; i < count; i++)
			arr[low + i] = tmp[i];
	}
}
