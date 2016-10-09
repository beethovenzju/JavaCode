package MainPackage;

public class BinSearch {

	public int getBinSearch(int[] arrs, int low, int high, int key){
		if(low <= high){
			int mid = (low + high) / 2;
			int cur = arrs[mid];
			if(cur == key)
				return mid;
			else if(cur > key)
				return getBinSearch(arrs, low, mid - 1, key);
			else
				return getBinSearch(arrs, mid + 1, high, key);
		}
		else
			return -1;
	}
	
	public int getBinSearch(int[] arrs, int n, int key){
		int left = 0;
		int right = n - 1;
		while(left <= right){
			int mid = (left + right) / 2;
			int cur = arrs[mid];
			if(cur == key)
				return mid;
			else if(cur > key)
				right = mid - 1;
			else
				left = mid + 1;
		}
		
		return -1;
	}
}
