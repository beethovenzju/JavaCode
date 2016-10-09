package MainPackage;

import java.util.*;
import java.text.*;
import java.math.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.00");
		String[] resultName = new String[3];
		int[] resultKey = new int[3];
		float[] resultValue = new float[3];
		double odds = 0.00f;
		resultName[0] = "W";
		resultName[1] = "T";
		resultName[2] = "L";
		float maxFloat = 0.0f;
		float tmpFloat = 0.0f;
		
		for(int i = 0; i < 3; i++)
		{
			maxFloat = 0.0f;
			for(int j = 0; j < 3; j++)
			{
				tmpFloat = in.nextFloat();
				if(tmpFloat > maxFloat)
				{
					maxFloat = tmpFloat;
					resultKey[i] = j;
					resultValue[i] = maxFloat;
				}
			}
		}
		
		for(int i = 0; i < 3; i++)
		{
			System.out.print(resultName[resultKey[i]] + " ");
			if(i == 0)
				odds = resultValue[0];
			else
				odds *= resultValue[i];
		}
		
		odds = (float)(odds * 0.65 - 1) * 2;
		
		BigDecimal big = new BigDecimal(odds);
		
		big = big.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		System.out.print(big);
 	}
}
