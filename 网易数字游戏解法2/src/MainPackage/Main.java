package MainPackage;
import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		List<Integer> list = new LinkedList<Integer>();
		int num;
		int tmp;
		
		while(in.hasNextInt()){
			list.clear();
			num = in.nextInt();
			for(int i = 0; i < num; i++){
				tmp = in.nextInt();
				list.add(tmp);
			}
			Collections.sort(list);
			int curSum = 1;
			boolean isFound = false;
			for(int i = 0; i < list.size(); i++){
				if(list.get(i) > curSum){
					System.out.println(curSum);
					isFound = true;
					break;
				}
				else
					curSum += list.get(i);
			}
			if(!isFound)
				System.out.println(curSum);
		}
		in.close();
	}
}
