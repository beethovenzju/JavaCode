package MainPackage;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int num;
		String tmp;
		StringBuilder builder = new StringBuilder();
		List<String> list = new LinkedList<String>();
		
		num = in.nextInt();
		for(int i = 0; i < num; i++){
			tmp = in.next();
			list.add(tmp);
		}
		
		Collections.sort(list, new Comparator<String>(){
			@Override
			public int compare(String arg0, String arg1){
				BigInteger big0 = new BigInteger(arg0 + arg1);
				BigInteger big1 = new BigInteger(arg1 + arg0);
				return big0.compareTo(big1);
			}
		});
		
		for(int i = 0; i < list.size(); i++){
			builder.append(list.get(i));
		}
		
		System.out.println(new BigInteger(builder.toString()));
	}
}
