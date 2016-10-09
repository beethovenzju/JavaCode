package MainPackage;

import java.util.*;
import java.math.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int tag;
		int radix;
		BigInteger resultRadix = BigInteger.valueOf(0);
		BigInteger decimalA = BigInteger.valueOf(0), decimalB = BigInteger.valueOf(0);
		BigInteger bigTmp;
		BigInteger minRadix;
		BigInteger maxRadix;
		BigInteger mid;
		int tmpInt;
		boolean isFound = false;
		String a, b, strTmp;
		a = in.next();
		b = in.next();
		tag = in.nextInt();
		radix = in.nextInt();
		
		if(tag == 2)
		{
			strTmp = a;
			a = b;
			b = strTmp;
		}

		for(int i = 0; i < a.length(); i++)
		{
			int intTmp = Main.getInt(a.charAt(a.length() - 1 - i));
			bigTmp = BigInteger.valueOf(radix).pow(i);
			decimalA = bigTmp.multiply(BigInteger.valueOf(intTmp)).add(decimalA);
		}
		
		minRadix = BigInteger.valueOf(0);
		for(int i = 0; i < b.length(); i++)
		{
			tmpInt = Main.getInt(b.charAt(i));
			if(BigInteger.valueOf(tmpInt).compareTo(minRadix) > 0)
				minRadix = BigInteger.valueOf(tmpInt);
		}
		minRadix = minRadix.add(BigInteger.valueOf(1));
		maxRadix = decimalA.add(BigInteger.valueOf(1));
		
		while(minRadix.compareTo(maxRadix) <= 0)
		{
			mid = minRadix.add(maxRadix).divide(BigInteger.valueOf(2));
			
			decimalB = BigInteger.valueOf(0);
			for(int i = 0; i < b.length(); i++)
			{
				int intTmp = Main.getInt(b.charAt(b.length() - 1 - i));
				bigTmp = mid.pow(i);
				decimalB = bigTmp.multiply(BigInteger.valueOf(intTmp)).add(decimalB);
			}
			
			if(decimalB.compareTo(decimalA) > 0)
				maxRadix = mid.subtract(BigInteger.valueOf(1));
			else if(decimalB.compareTo(decimalA) < 0)
				minRadix = mid.add(BigInteger.valueOf(1));
			else
			{
				resultRadix = mid;
				isFound = true;
				break;
			}
		}

		if(!isFound)
			System.out.print("Impossible");
		else
			System.out.print(resultRadix);
		
		if(in != null)
			in.close();
	}
	
	public static int getInt(char c)
	{
		if(c >= '0' && c <= '9')
			return (c-'0');
		else
			return(c - 'a' + 10);
	}
}
