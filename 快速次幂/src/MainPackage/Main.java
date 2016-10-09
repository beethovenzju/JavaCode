package MainPackage;

public class Main {

	public double Power(double base, int exponent) {
		double cur = base;
		int p = Math.abs(exponent);
		double result = 1;
		
		while(p != 0){
			if((p & 1) != 0)
				result *= cur;
			cur = Math.pow(cur, 2);
			p >>= 1;
		}
		
		if(exponent < 0)
			result = 1 / result;
		
		return result;
	}
}
