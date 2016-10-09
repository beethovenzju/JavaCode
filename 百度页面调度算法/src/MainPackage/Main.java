package MainPackage;

import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			int count = in.nextInt();
			int result = 0;
			Queue<Integer> que = new LinkedList<Integer>();
			for(int i = 0; i < count; i++){
				int cur = in.nextInt();
				if(!que.contains(cur)){
					result++;
					if(que.size() == num)
						que.poll();
					que.add(cur);
				}
			}
			System.out.println(result);
		}
		in.close();
	}
}
