package MainPacket;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		String result = "";
		String strTmp = "";
		Scanner in = new Scanner(System.in);
		boolean isNegetive = false;
		int digitCount = 0;
		int count = 0;
		int i;
		int a = in.nextInt();
		int b = in.nextInt();
		int c = a + b;
		int intTmp = c;

		if(c < 0)
		{
			c = -c;
			isNegetive = true;
		}
		strTmp = Integer.toString(c);
		
		while(intTmp != 0)
		{
			intTmp /= 10;
			digitCount++;
		}
		
		if(digitCount < 3)
			result = strTmp;
		else
		{
			count = digitCount / 3;
			
			for(i = 0;i < count; i++)
			{
				if(i == 0)
					result = strTmp.substring(digitCount - 3, digitCount) + result;
				else
					result = strTmp.substring(digitCount - 3 * (i + 1), digitCount - 3 * i) + "," + result;
			}
			
			if(digitCount % 3 != 0)
				result = strTmp.substring(0, digitCount - 3 * i) + "," + result;
		}
		
		if(isNegetive)
			System.out.println("-" + result);
		else
			System.out.println(result);
		
		if(in != null)
			in.close();
	}
}
