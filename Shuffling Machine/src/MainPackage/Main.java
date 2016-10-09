package MainPackage;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		String[] start = {"S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "S11", "S12", "S13",
						  "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "H11", "H12", "H13",
						  "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13",
						  "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12", "D13",
						  "J1", "J2"};
		String[] end = Arrays.copyOfRange(start, 0, start.length);
		int[] index = new int[54];
		int num;
		
		num = in.nextInt();
		for(int i = 0; i < 54; i++)
			index[i] = in.nextInt();
		
		while(num-- != 0){
			for(int i = 0; i < 54; i++){
				end[index[i] - 1] = start[i];
			}
			start = Arrays.copyOfRange(end, 0, end.length);
		}
		
		for(int i = 0; i < 54; i++){
			if(i != 0)
				System.out.print(" " + end[i]);
			else
				System.out.print(end[i]);
		}
	}
}
