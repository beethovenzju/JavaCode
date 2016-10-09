package MainPackage;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		List<Info> list = new LinkedList<Info>();
		int total = 0;
		String account;
		String password;
		String tmpStr;
		
		total = in.nextInt();
		for(int i = 0; i < total; i++){
			account = in.next();
			password = in.next();
			tmpStr = Main.Modified(password);
			if(!tmpStr.equals(password)){
				Info info = new Info(account, tmpStr);
				list.add(info);
			}
		}
		if(list.size() == 0){
			if(total == 1)
				System.out.println("There is 1 account and no account is modified");
			else
				System.out.println("There are " + total + " accounts and no account is modified");
		}
		else{
			System.out.println(list.size());
			for(Info info : list){
				System.out.println(info.account + " " + info.password);
 			}
		}
	}
	
	public static class Info{
		private String account;
		private String password;
		
		public Info(String account, String password){
			this.account = account;
			this.password = password;
		}
	}
	
	public static String Modified(String password){
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i <password.length(); i++){
			char tmp = password.charAt(i);
			if(tmp == '1')
				builder.append('@');
			else if(tmp == '0')
				builder.append('%');
			else if(tmp == 'l')
				builder.append('L');
			else if(tmp == 'O')
				builder.append('o');
			else
				builder.append(tmp);
		}
		return builder.toString();
	}
}
