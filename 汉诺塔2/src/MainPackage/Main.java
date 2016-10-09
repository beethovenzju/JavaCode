package MainPackage;
import java.util.*;

public class Main {

	/*
	 * 有一个int数组arr其中只含有1、2和3，分别代表所有圆盘目前的状态，1代表左柱，2代表中柱，3代表右柱，arr[i]的值代表第i+1个圆盘的位置。
	 * 比如，arr=[3,3,2,1]，代表第1个圆盘在右柱上、第2个圆盘在右柱上、第3个圆盘在中柱上、第4个圆盘在左柱上。如果arr代表的状态是最优移动轨
	 * 迹过程中出现的状态，返回arr这种状态是最优移动轨迹中的第几个状态。如果arr代表的状态不是最优移动轨迹过程中出现的状态，则返回-1。
	 * 给定一个int数组arr及数组的大小n，含义如题所述，请返回一个int，代表所求的结果。
	 */
	private int[] cur;
	
	public int chkStep(int[] arr, int n) {
        // write code here
		cur = new int[n];
    }
	
	private int move(int count, int from, int to, int[] arr){
		if(count <= 0)
			return -1;
		
		move(count - 1, from, 3 - from - to, arr);
		cur[count] = to;
		move(count - 1, 3 - from - to, to, arr);
	}
}
