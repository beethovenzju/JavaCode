package MainPackage;

import java.io.*;

public class Main {

	public static void main(String[] args){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try{
			int num = Integer.parseInt(reader.readLine());
			for(int i = 0; i < num; i++){
				String str = reader.readLine();
				char c = getChar(str);
				System.out.println(c);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static char getChar(String str){
		int[] hash = new int[256];
		char[] chars = str.toCharArray();
		for(int i = 0; i < chars.length; i++)
			hash[chars[i]]++;
		
		for(int i = 0; i < chars.length; i++){
			if(hash[chars[i]] == 1)
				return chars[i];
		}
		return '\0';
	}
}
