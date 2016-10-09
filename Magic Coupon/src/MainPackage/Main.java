package MainPackage;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		List<Integer> couponList = new LinkedList<Integer>();
		List<Integer> productList = new LinkedList<Integer>();
		int couponNum = 0;
		int productNum = 0;
		int max = 0;
		
		couponNum = in.nextInt();
		for(int i = 0; i < couponNum; i++)
			couponList.add(in.nextInt());
		productNum = in.nextInt();
		for(int i = 0; i < productNum; i++)
			productList.add(in.nextInt());
		
		Collections.sort(couponList);
		Collections.reverse(couponList);
		Collections.sort(productList);
		Collections.reverse(productList);
		
		while(true){
			if(couponList.size() == 0 || productList.size() == 0)
				break;
			
			int coupon = couponList.get(0);
			int product = productList.get(0);
			if(coupon >= 0 && product >= 0){
				max += coupon * product;
				couponList.remove((Integer)coupon);
				productList.remove((Integer)product);
			}
			else if(coupon >= 0 && product < 0)
				couponList.remove((Integer)coupon);
			else if(coupon < 0 && product >= 0)
				productList.remove((Integer)product);
			else if(coupon < 0 && product < 0){
				coupon = couponList.get(couponList.size() - 1);
				product = productList.get(productList.size() - 1);
				max += coupon * product;
				couponList.remove((Integer)coupon);
				productList.remove((Integer)product);
			}
		}
		System.out.println("" + max);
	}
}
