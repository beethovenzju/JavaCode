package MainPackage;

import java.util.*;
import java.math.*;

public class Main 
{
	public static void main(String[] args)
	{
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<Integer> result = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		BigInteger n;
		BigInteger bigTmp;
		BigInteger bigRemainder;
		BigInteger bigSum = BigInteger.valueOf(0);
		int intTmp;
		int remainder;
		String value;
		map.put(0, "zero");
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		
		n = in.nextBigInteger();
		bigTmp = n;
		
		while(bigTmp.compareTo(BigInteger.valueOf(0)) > 0)
		{
			bigRemainder = bigTmp.mod(BigInteger.valueOf(10));
			bigSum  = bigSum.add(bigRemainder);
			bigTmp = (bigTmp.subtract(bigRemainder)).divide(BigInteger.valueOf(10));
		}
		
		intTmp = bigSum.intValue();

		while(intTmp != 0)
		{
			remainder = intTmp % 10;
			result.add(remainder);
			intTmp = (intTmp - remainder) / 10;
		}
		
		if(result.size() == 0)
			System.out.print("zero");
		else
		{
			for(int i = result.size() - 1; i >= 0; i--)
			{
				intTmp = result.get(i);
				value = map.get(intTmp);
				
				if(i == 0)
					System.out.print(value);
				else
					System.out.print(value + " ");
			}
		}
	}
}
