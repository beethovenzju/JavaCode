package Sort;

import java.util.Comparator;

public class ShellSorter implements Sorter {

	@Override
	public <T extends Comparable<? super T>> void sort(T[] list) {
		int k;
		for(int i = list.length / 2; i > 0; i /= 2){
			for(int j = i; j < list.length; j++){
				T tmp = list[j];
				for(k = j; k >= i && tmp.compareTo(list[k - i]) < 0; k -= i){
					list[k] = list[k - i];
				}
				list[k] = tmp;
			}
		}
	}

	@Override
	public <T> void sort(T[] list, Comparator<? super T> comp) {
		// TODO Auto-generated method stub
		int k;
		for(int i = list.length / 2; i > 0; i /= 2){
			for(int j = i; j < list.length; j++){
				T tmp = list[j];
				for(k = j; k >= i && comp.compare(tmp, list[k - i]) < 0; k -= i){
					list[k] = list[k - i];
				}
				list[k] = tmp;
			}
		}
	}

}
