package MainPackage;

import java.util.*;
import java.io.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int R, G, B;
		String strR, strG, strB;
		
		R = in.nextInt();
		G = in.nextInt();
		B = in.nextInt();
		
		strR = GetFormat(R);
		strG = GetFormat(G);
		strB = GetFormat(B);
		
		System.out.println("#" + strR + strG + strB);
	}
	
	public static String GetFormat(int in)
	{
		if(in == 0)
			return "00";
		String result = "";
		List<Integer> list = new LinkedList<Integer>();
		int remainder;
		int tmp = in;
		while(tmp != 0)
		{
			remainder = tmp % 13;
			list.add(remainder);
			tmp = (tmp - remainder) / 13;
		}
		
		for(int i = 0; i < list.size(); i++)
		{
			int cur = list.get(i);
			if(cur == 10)
				result = "A" + result;
			else if(cur == 11)
				result = "B" + result;
			else if(cur == 12)
				result = "C" + result;
			else
				result = cur + result;
		}
		
		if(list.size() == 1)
			return ("0" + result);
		else
			return result;
	}
}
