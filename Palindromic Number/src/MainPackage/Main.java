package MainPackage;

import java.util.*;
import java.io.*;
import java.math.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		BigInteger input;
		BigInteger value;
		BigInteger tmp;
		int maxNum;
		int i;
		
		input = in.nextBigInteger();
		maxNum = in.nextInt();
		
		value = input;
		for(i = 0; i < maxNum; i++)
		{
			if(Main.IsPalindromic(value))
				break;
			else
			{
				tmp = Main.GetRevert(value);
				value = value.add(tmp);
			}
		}
		System.out.println(value);
		System.out.println(i);
	}
	
	public static List<BigInteger> GetList(BigInteger big)
	{
		List<BigInteger> result = new LinkedList<BigInteger>();
		BigInteger tmp;
		BigInteger remainder;
		tmp = big;
		while(tmp.compareTo(BigInteger.valueOf(0)) != 0)
		{
			remainder = tmp.mod(BigInteger.valueOf(10));
			tmp = tmp.divide(BigInteger.valueOf(10));
			result.add(remainder);
		}
		return result;
	}
	
	public static BigInteger GetRevert(BigInteger big)
	{
		List<BigInteger> list = Main.GetList(big);
		BigInteger result = BigInteger.valueOf(0);
		BigInteger tmp;
		for(int i = list.size() - 1; i >= 0; i--)
		{
			tmp = BigInteger.valueOf(10).pow(list.size() - 1 - i);
			result = result.add(list.get(i).multiply(tmp));
		}
		return result;
	}
	
	public static boolean IsPalindromic(BigInteger big)
	{
		boolean result = true;
		BigInteger a, b;
		List<BigInteger> list = Main.GetList(big);
		if(list.size() == 1)
			return true;
		
		int mid = list.size() / 2 + 1;
		for(int i = 0; i <= mid; i++)
		{
			a = list.get(i);
			b = list.get(list.size() - 1 - i);
			if(a.compareTo(b) != 0)
			{
				result = false;
				break;
			}
		}
		return result;
	}
}
