package MainPackage;

import java.util.*;
import java.io.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		String str = in.nextLine();
		int total = str.length();
		int lr, bu;
		int maxBu = 0;
		int k = -1;
		String black;
		
		if(total % 2 == 0)
		{
			for(bu = 4; bu <= total; bu += 2)
			{
				lr = (total + 2 - bu) / 2;
				if(lr <= bu && lr > k)
				{
					k = lr;
					maxBu = bu;
				}
			}
		}
		else
		{
			for(bu = 3; bu <= total; bu += 2)
			{
				lr = (total + 2 - bu) / 2;
				if(lr <= bu && lr > k)
				{
					k = lr;
					maxBu = bu;
				}
			}
		}
		lr = (total + 2 - maxBu) / 2;
		
		StringBuilder blackBuilder = new StringBuilder();
		for(int j = 0; j < (maxBu - 2); j++)
			blackBuilder.append(" ");
		black = blackBuilder.toString();
		
		for(int i = 0; i < lr - 1; i++)
		{
			StringBuilder builder = new StringBuilder();
			builder.append(str.charAt(i));
			builder.append(black);
			builder.append(str.charAt(total - 1 - i));
			System.out.println(builder.toString());
		}
		StringBuilder builder = new StringBuilder();
		for(int i = lr; i < lr + maxBu; i++)
			builder.append(str.charAt(i - 1));
		System.out.println(builder.toString());
	}
}
