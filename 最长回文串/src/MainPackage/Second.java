package MainPackage;

public class Second {
	
	public int getLongestPalindrome(String A, int n) {
        // write code here
		if(n == 0)
			return 0;
		char[] AChar = A.toCharArray();
		char[] newArr = new char[2 * n + 1];
		for(int i = 0; i < newArr.length; i++){
			if(i % 2 == 0)
				newArr[i] = '#';
			else
				newArr[i] = AChar[i / 2];
		}
		int index = 0;
		int length = 0;
		while(index < newArr.length){
			int r = 1;
			while(index - r >= 0 && index + r < newArr.length){
				if(newArr[index - r] == newArr[index + r])
					length = Math.max(length, 2 * r + 1);
				else 
					break;
				r++;
			}
			index++;
		}
		return length / 2;
    }
}
