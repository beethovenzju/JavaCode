package MainPackage;

import java.util.*;
import java.io.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		List<Long> list1;
		List<Long> list2;
		int num1, num2, mid;
		String str;
		String[] strs;
		long current = 0L;
		long tmp;
		int index = 0, i = 0, j = 0;
		
		str = in.nextLine();
		strs = str.split(" ");
		num1 = Integer.parseInt(strs[0]);
		list1 = new ArrayList<Long>(num1);
		for(int k = 1; k <= num1; k++)
			list1.add(Long.parseLong(strs[k]));
		
		str = in.nextLine();
		strs = str.split(" ");
		num2 = Integer.parseInt(strs[0]);
		list2 = new ArrayList<Long>(num2);
		for(int k = 1; k <= num2; k++)
			list2.add(Long.parseLong(strs[k]));
		
		/*mid = (num1 + num2 + 1) / 2;
		while(index != mid)
		{
			if(i < list1.size() && j < list2.size())
			{
				if(list1.get(i) > list2.get(j))
					current = list2.get(j++);
				else
					current = list1.get(i++);
			}
			else if(i >= list1.size() && j >= list2.size())
				break;
			else if(i < list1.size())
				current = list1.get(i++);
			else 
				current = list2.get(j++);
			index++;
		}
		System.out.println(current);*/
	}
}
