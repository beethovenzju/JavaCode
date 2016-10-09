package MainPackage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String a = in.next();
			String b = in.next();
			int num = 0;
			for(int i = 0; i <= a.length(); i++){
				String result = a.substring(0, i) + b + a.substring(i, a.length());
				if(IsSame(result))
					num++;
			}
			System.out.println(num);
		}
	}
	
	public static boolean IsSame(String str){
		boolean result = true;
		int length = str.length();
		if(length == 1)
			return true;
		
		for(int i = 0; i < length / 2 + 1; i++){
			if(str.charAt(i) != str.charAt(length - 1 - i)){
				result = false;
			}
		}
		return result;
	}
}
