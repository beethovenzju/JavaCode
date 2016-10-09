package MainPackage;

import java.util.*;
import java.text.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int ALength = 0;
		int BLength = 0;
		int totalLength = 0;
		int intTmp;
		int readExp;
		float readCoef;
		List<Polynomial> APloy = new LinkedList<Polynomial>();
		List<Polynomial> BPloy = new LinkedList<Polynomial>();
		List<Polynomial> totalPloy = new LinkedList<Polynomial>();
		
		ALength = in.nextInt();
		if(ALength == 0)
			return;
		
		intTmp = ALength;
		while(intTmp != 0)
		{
			readExp = in.nextInt();
			readCoef = in.nextFloat();
			Polynomial poly = new Polynomial(readExp, readCoef);
			APloy.add(poly);
			intTmp--;
		}
		
		BLength = in.nextInt();
		if(BLength == 0)
			return;
		
		intTmp = BLength;
		while(intTmp != 0)
		{
			readExp = in.nextInt();
			readCoef = in.nextFloat();
			Polynomial poly = new Polynomial(readExp, readCoef);
			BPloy.add(poly);
			intTmp--;
		}
		
		totalLength = 0;
		
		while(APloy.size() != 0 || BPloy.size() != 0)
		{
			Polynomial poly;
			
			if(APloy.size() == 0)
			{
				poly = BPloy.get(0);
				BPloy.remove(0);
			}
			else if(BPloy.size() == 0)
			{
				poly = APloy.get(0);
				APloy.remove(0);
			}
			else
			{
				Polynomial polyA = APloy.get(0);
				Polynomial polyB = BPloy.get(0);
				
				if(polyA.getExponent() > polyB.getExponent())
				{
					poly = polyA;
					APloy.remove(0);
				}
				else if(polyA.getExponent() < polyB.getExponent())
				{
					poly = polyB;
					BPloy.remove(0);
				}
				else
				{
					poly = new Polynomial(polyA.getExponent(), polyA.getCoefficient() + polyB.getCoefficient());
					APloy.remove(0);
					BPloy.remove(0);
				}
			}
			
			if(poly != null && poly.getCoefficient() != 0)
			{
				totalPloy.add(poly);
				totalLength++;
			}	
		}
		
		System.out.print(totalLength);
		
		for(int i = 0;i < totalLength; i++)
		{
			if(totalPloy.get(i).getCoefficient() != 0)
			{
				totalPloy.get(i).coefficientFormat();
				System.out.print(" " + totalPloy.get(i).getExponent());
				System.out.print(" " + totalPloy.get(i).getCoefficient());
			}
		}
		
		if(in != null)
			in.close();
	}
	
	private static class Polynomial
	{
		private int exponent;
		private float coefficient;
		
		public Polynomial(int exp, float coef)
		{
			this.exponent = exp;
			this.coefficient = coef;
		}

		public int getExponent() 
		{
			return exponent;
		}

		public float getCoefficient() 
		{
			return coefficient;
		}
		
		public void coefficientFormat()
		{
			DecimalFormat df = new DecimalFormat("#.0");
			coefficient = Float.parseFloat(df.format(coefficient));
		}
	}
}
