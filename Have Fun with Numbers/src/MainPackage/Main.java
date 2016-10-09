package MainPackage;

import java.util.*;
import java.io.*;
import java.math.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int[] countsIn = new int[10];
		int[] countsOut = new int[10];
		BigInteger input;
		BigInteger tmp;
		BigInteger remainder;
		BigInteger doubleInput;
		int index;
		boolean isOK = true;
		for(int i = 0; i < 10; i++)
		{
			countsIn[i] = 0;
			countsOut[i] = 0;
		}
		
		input = in.nextBigInteger();
		tmp = input;
		while(tmp.compareTo(BigInteger.valueOf(0)) != 0)
		{
			remainder = tmp.mod(BigInteger.valueOf(10));
			index = remainder.intValue();
			countsIn[index]++;
			tmp = tmp.divide(BigInteger.valueOf(10));
		}
		
		doubleInput = input.multiply(BigInteger.valueOf(2));
		tmp = doubleInput;
		while(tmp.compareTo(BigInteger.valueOf(0)) != 0)
		{
			remainder = tmp.mod(BigInteger.valueOf(10));
			index = remainder.intValue();
			countsOut[index]++;
			tmp = tmp.divide(BigInteger.valueOf(10));
		}
		
		for(int i = 0; i < 10; i++)
		{
			if(countsIn[i] != countsOut[i])
			{
				isOK = false;
				break;
			}
		}
		
		if(isOK)
			System.out.println("Yes");
		else
			System.out.println("No");
		System.out.println(doubleInput);
	}
}
