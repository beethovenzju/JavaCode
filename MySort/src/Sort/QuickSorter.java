package Sort;

import java.util.Comparator;
import java.util.Random;

public class QuickSorter implements Sorter {

	@Override
	public <T extends Comparable<? super T>> void sort(T[] list) {
		sort(list, 0, list.length - 1);
	}
	
	public <T extends Comparable<? super T>> void  sort(T[] list, int left, int right){
		if(left < right){
			T privot = list[left];
			int i = left;
			int j = right + 1;
			while(i < j){
				while(++i <= right && list[i].compareTo(privot) < 0);
				while(--j >= left && list[j].compareTo(privot) > 0);
				if(i > j)
					break;
				else{
					T tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
			}
			list[left] = list[j];
			list[j] = privot;
			
			sort(list, left, j - 1);
			sort(list, j + 1, right);
		}
	}

	@Override
	public <T> void sort(T[] list, Comparator<? super T> comp) {

	}

	public static void main(String[] args){
		Integer[] arr = new Integer[100];
		Random rd = new Random();
		for(int i = 0; i < arr.length; i++){
			arr[i] = rd.nextInt(1000);
		}
		
		QuickSorter sorter = new QuickSorter();
		sorter.sort(arr);
		
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}

