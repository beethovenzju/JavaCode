package MainPackage;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		String orig;
		int maxLength = 1;
		char c;
		
		orig = in.nextLine();
		for(int i = 0; i < orig.length() - maxLength; i++){
			c = orig.charAt(i);
			for(int j = orig.length() - 1; j > i; j--){
				if(orig.charAt(j) == c){
					int tmpi = i;
					int tmpj = j;
					int tmpLength = 0;
					boolean isSymmetric = true;
					while(isSymmetric && tmpi <= tmpj){
						if(orig.charAt(tmpi) == orig.charAt(tmpj)){
							tmpi++;
							tmpj--;
							if(tmpi == tmpj)
								tmpLength += 1;
							else
								tmpLength += 2;
						}
						else
							isSymmetric = false;
					}
					if(isSymmetric && tmpLength > maxLength)
						maxLength = tmpLength;
				}
			}
		}
		System.out.println(maxLength);
	}
}
