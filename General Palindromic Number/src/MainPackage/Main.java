package MainPackage;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		List<BigInteger> list = new ArrayList<BigInteger>();
		BigInteger value;
		BigInteger tmp;
		BigInteger remainder;
		BigInteger base;
		
		value = in.nextBigInteger();
		base = in.nextBigInteger();
		tmp = value;
		
		if(value.intValue() == 0)
		{
			System.out.println("Yes");
			System.out.print("0");
			return;
		}
		
		while(tmp.compareTo(BigInteger.valueOf(0)) != 0)
		{
			remainder = tmp.mod(base);
			list.add(remainder);
			tmp = tmp.divide(base);
		}
		

		int start = 0;
		int end = list.size() - 1;
		int mid = (start + end) / 2 + 1;
		boolean isSame = true;
		if(list.size() == 1)
			isSame = true;
		else
		{
			for(int i = start; i <= mid; i++)
			{
				if(list.get(i).compareTo(list.get(end - i)) != 0)
				{
					isSame = false;
					break;
				}
			}
		}
		
		if(isSame)
			System.out.println("Yes");
		else
			System.out.println("No");
		
		for(int i = list.size() - 1; i >= 0; i--)
		{
			if(i == list.size() - 1)
				System.out.print(list.get(i));
			else
				System.out.print(" " + list.get(i));
		}
	}
}
