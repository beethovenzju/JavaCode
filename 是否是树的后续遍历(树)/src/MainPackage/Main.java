package MainPackage;

public class Main {

	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence.length == 0)
			return false;
        return isRight(sequence, 0, sequence.length - 1);
    }
	
	public boolean isRight(int [] sequence, int low, int high){
		if(low >= high)
			return true;
		
		int i = low;
		for(; i < high; i++){
			if(sequence[i] >= sequence[high])
				break;
		}
		
		for(int j = i; j < high; j++){
			if(sequence[j] <= sequence[high])
				return false;
		}
		
		boolean b1 = isRight(sequence, low, i - 1);
		boolean b2 = isRight(sequence, i, high - 1);
		return (b1 && b2);
	}
	
	public static void main(String[] args){
		int a[] = {4,8,6,12,16,14,10};
	    System.out.println(new Main().VerifySquenceOfBST(a));
	}
}
