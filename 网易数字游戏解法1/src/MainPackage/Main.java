package MainPackage;
import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> list = new LinkedList<Integer>();
		int num;
		int tmp;
		
		num = in.nextInt();
		for(int i = 0; i < num; i++){
			tmp = in.nextInt();
			list.add(tmp);
			set.add(tmp);
		}
		
		Main.GetSums(0,  0, list, set);
		
		int cur = 1;
		for(;;){
			if(!set.contains(cur)){
				System.out.println(cur);
				break;
			}
			cur++;
		}
	}
	
	public static void GetSums(int index, int sums, List<Integer> list, Set<Integer> set){
		set.add(sums);
		if(index >= list.size())
			return;
		
		GetSums(index + 1, sums, list, set);
		GetSums(index + 1, sums + list.get(index), list, set);
	}
}
