package MainPackage;

import java.util.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int num, radix;
		Queue<String> result = new LinkedList<String>();
		
		num = in.nextInt();
		while(num > 0)
		{
			radix = in.nextInt();
			if(isPrime(num) && isPrime(getReversValue(num, radix)))
				result.add("Yes");
			else
				result.add("No");
			
			num = in.nextInt();
		}
		
		while(!result.isEmpty())
		{
			System.out.println(result.poll());
		}
		
		if(in != null)
			in.close();
	}
	
	public static int getReversValue(int num, int radix)
	{
		List<Integer> list = new LinkedList<Integer>();
		
		int n = num;
		int remainder, result = 0;
		
		while(n != 0)
		{
			remainder = n % radix;
			list.add(remainder);
			n = n / radix;
		}
		
		int index = 0;
		
		for(int i = list.size() - 1; i >= 0; i--)
			result += list.get(i) * Math.pow(radix, index++);
		
		return result;
	}
	
	public static boolean isPrime(int n)
	{
		if(n == 0 || n == 1 || n == 4)
			return false;
		if(n == 2 || n == 3)
			return true;
		
		for(int i = 2; i * i <= n; i++)
			if(n % i == 0)
				return false;
		
		return true;
	}
}
