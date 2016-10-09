package MainPackage;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> input = new LinkedList<Integer>();
		int num;
		int tmp;
		
		num = in.nextInt();
		for(int i = 0; i < num; i++){
			tmp = in.nextInt();
			input.add(tmp);
			if(map.containsKey(tmp)){
				int key = map.get(tmp);
				key++;
				map.put(tmp, key);
			}
			else{
				map.put(tmp, 1);
			}
		}
		
		for(Integer i : input){
			if(map.get(i) == 1){
				System.out.println(i);
				return;
			}
		}
		System.out.println("None");
	}
}
