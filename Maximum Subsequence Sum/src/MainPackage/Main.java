package MainPackage;

import java.util.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int max = -1;
		int sum = 0;
		boolean isFirstSet = false;
		int first = 0;
		int maxFirst = 0;
		int maxEnd = 0;
		int count;
		int value;
		int firstValue = 0;
		int lastValue = 0;
		
		count = in.nextInt();
		
		for(int i = 0; i < count; i++)
		{
			value = in.nextInt();
			if(i == 0)
				firstValue = value;
			else if(i == count - 1)
				lastValue = value;
			
			if(!isFirstSet)
			{
				first = value;
				isFirstSet = true;
			}
			
			sum += value;

			if(sum > max)
			{
				max = sum;
				maxFirst = first;
				maxEnd = value;
			}
			else if(sum < 0)
			{
				sum = 0;
				isFirstSet = false;
			}
		}
		
		if(max < 0)
			System.out.print(0 + " " + firstValue + " " + lastValue);
		else
			System.out.print(max + " " + maxFirst + " " + maxEnd);
	}
}
