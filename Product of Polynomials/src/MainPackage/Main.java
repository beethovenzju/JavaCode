package MainPackage;

import java.util.*;
import java.text.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Polynomial A = new Polynomial();
		Polynomial B = new Polynomial();
		Polynomial product = new Polynomial();
		int count;
		int intTmp, intTmp2;
		float floatTmp, floatTmp2;
		boolean isFirst = true;
		String result = "";
		
		count = in.nextInt();
		for(int i = 0; i < count; i++)
		{
			intTmp = in.nextInt();
			floatTmp = in.nextFloat();
			A.addItem(intTmp, floatTmp);
		}
		
		count = in.nextInt();
		for(int i = 0; i < count; i++)
		{
			intTmp = in.nextInt();
			floatTmp = in.nextFloat();
			B.addItem(intTmp, floatTmp);
		}
		
		for(Map.Entry<Integer, Float> tmpA : A.map.entrySet())
		{
			intTmp = tmpA.getKey();
			floatTmp = tmpA.getValue();
			for(Map.Entry<Integer, Float> tmpB : B.map.entrySet())
			{
				intTmp2 = tmpB.getKey() + intTmp;
				floatTmp2 = tmpB.getValue() * floatTmp;
				product.addItem(intTmp2, floatTmp2);
			}
		}
		
		for(Map.Entry<Integer, Float> tmp : product.map.entrySet())
		{
			intTmp = tmp.getKey();
			floatTmp = tmp.getValue();
			if(isFirst)
			{
				result = intTmp + " " + floatTmp;
				isFirst = false;
			}
			else
				result = intTmp + " " + floatTmp + " " + result;
		}
		
		System.out.print(product.termsCount + " " + result);
	}
	
	public static class Polynomial
	{
		private int termsCount;
		private Map<Integer, Float> map;
		
		public Polynomial()
		{
			termsCount = 0;
			map = new TreeMap<Integer, Float>();
		}
		
		public void addItem(int exponent, float coefficient)
		{
			DecimalFormat df = new DecimalFormat("#.0");
			if(!map.containsKey(exponent))
			{
				coefficient = Float.parseFloat(df.format(coefficient));
				map.put(exponent, coefficient);
				termsCount++;
			}
			else
			{
				float result = map.get(exponent);
				
				result += coefficient;
				result = Float.parseFloat(df.format(result));
				if(result != 0)
					map.put(exponent, result);
				else
				{
					map.remove(exponent);
					termsCount--;
				}
			}
		}
	}
}
