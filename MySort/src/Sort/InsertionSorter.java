package Sort;

import java.util.Comparator;
import java.util.Random;

public class InsertionSorter implements Sorter {

	@Override
	public <T extends Comparable<? super T>> void sort(T[] list) {
		// TODO Auto-generated method stub
		int j;
		for(int i = 1; i < list.length; i++){
			T tmp = list[i];
			for(j = i; j > 0 && list[j].compareTo(list[j - 1]) < 0; j--){
				list[j] = list[j - 1];
			}
			list[j] = tmp;
		}

	}

	@Override
	public <T> void sort(T[] list, Comparator<? super T> comp) {
		// TODO Auto-generated method stub

		int j;
		for(int i = 1; i < list.length; i++){
			T tmp = list[i];
			for(j = i; j > 0 && comp.compare(tmp, list[j - 1]) < 0; j--){
				list[j] = list[j - 1];
			}
			list[j] = tmp;
		}
	}

	public static void main(String[] args){
		Integer[] arr = new Integer[100];
		Random rd = new Random();
		for(int i = 0; i < arr.length; i++){
			arr[i] = rd.nextInt(1000);
		}
		
		InsertionSorter sorter = new InsertionSorter();
		sorter.sort(arr);
		
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}
