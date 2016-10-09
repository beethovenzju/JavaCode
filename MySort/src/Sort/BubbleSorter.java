package Sort;

import java.util.Comparator;

public class BubbleSorter implements Sorter {

	@Override
	public <T extends Comparable<? super T>> void sort(T[] list) {
		for(int i = list.length - 1; i >= 0; i--){
			for(int j = 0; j < i; j++){
				if(list[j].compareTo(list[j + 1]) > 0){
					T tmp = list[j];
					list[j + 1] = list[j];
					list[j] = tmp;
				}
			}
		}
	}

	@Override
	public <T> void sort(T[] list, Comparator<? super T> comp) {
		for(int i = list.length - 1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(comp.compare(list[j], list[j + 1]) > 0){
					T tmp = list[j + 1];
					list[j + 1] = list[j];
					list[j] = tmp;
				}
			}
		}
	}
}
