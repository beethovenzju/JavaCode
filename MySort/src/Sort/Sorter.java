package Sort;

import java.util.*;

public interface Sorter {
	
	<T extends Comparable<? super T>> void sort(T[] list);
	
	<T> void sort(T[] list, Comparator<? super T> comp);
}
