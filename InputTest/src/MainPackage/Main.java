package MainPackage;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int couponNum = 0;
		int productNum = 0;
		int max = 0;

		couponNum = Integer.parseInt(buffer.readLine());
		buffer.readLine();
		productNum = Integer.parseInt(buffer.readLine());
		buffer.readLine();
		System.out.println("" + max);
	}
}
