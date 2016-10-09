package Sort;

import java.util.Comparator;
import java.util.Random;

public class MergeSorter implements Sorter {

	@Override
	public <T extends Comparable<? super T>> void sort(T[] list) {
		// TODO Auto-generated method stub
		T[] tmp = (T[])new Comparable[list.length];
		sort(list, tmp, 0, list.length - 1);
	}

	public <T extends Comparable<? super T>> void sort(T[] list, T[] tmp, int left, int right){
		if(left < right){
			int mid = (left + right) / 2;
			sort(list, tmp, left, mid);
			sort(list, tmp, mid + 1, right);
			merge(list, tmp, left, mid + 1, right);
		}
	}
	
	public <T extends Comparable<? super T>> void merge(T[] list, T[] tmp, int leftStart, int rightStart, int rightEnd){
		int leftCur = leftStart;
		int leftEnd = rightStart - 1;
		int rightCur = rightStart;
		int tmpCur = leftStart;
		
		while(leftCur <= leftEnd && rightCur <= rightEnd){
			if(list[leftCur].compareTo(list[rightCur]) <= 0)
				tmp[tmpCur++] = list[leftCur++];
			else
				tmp[tmpCur++] = list[rightCur++];
		}
		
		while(leftCur <= leftEnd)
			tmp[tmpCur++] = list[leftCur++];
		while(rightCur <= rightEnd)
			tmp[tmpCur++] = list[rightCur++];
		
		for(int i = leftStart; i <= rightEnd; i++)
			list[i] = tmp[i];
	}
	
	@Override
	public <T> void sort(T[] list, Comparator<? super T> comp) {
		// TODO Auto-generated method stub
	}

	
	public static void main(String[] args){
		Integer[] arr = new Integer[100];
		Random rd = new Random();
		for(int i = 0; i < arr.length; i++){
			arr[i] = rd.nextInt(1000);
		}
		
		MergeSorter sorter = new MergeSorter();
		sorter.sort(arr);
		
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}
