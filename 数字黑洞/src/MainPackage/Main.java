package MainPackage;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int small, big;
        int tmp;
        small = Main.getSmall(input);
        big = Main.getBig(input);
        tmp = big - small;
        if(tmp == 0){
            System.out.println("N - N = 0000");
            return;
        }
        else if(tmp == 6174){
        	System.out.printf("%04d - %04d = %04d", big, small, tmp);
        	System.out.println();
            return;
        }
        else{
            while(tmp != 6174){
            	System.out.printf("%04d - %04d = %04d", big, small, tmp);
            	System.out.println();
                small = Main.getSmall(tmp);
        		big = Main.getBig(tmp);
                tmp = big - small;
            }
        }
        System.out.printf("%04d - %04d = %04d", big, small, tmp);
    }
    
    public static int getBig(int input){
         List<Integer> list = new LinkedList<Integer>();
        int tmp, remainder;
        int big = 0;
        tmp = input;
        while(tmp != 0){
            remainder = tmp % 10;
            list.add(remainder);
            tmp /= 10;
        }
        for(int i = list.size(); i < 4; i++){
        	list.add(0);
        }
        Collections.sort(list);
        
        for(int i = 0; i < list.size(); i++){
            big += list.get(i) * Math.pow(10, i);
        }
        return big;
    }
    
    public static int getSmall(int input){
        List<Integer> list = new LinkedList<Integer>();
        int tmp, remainder;
        int small = 0;
        tmp = input;
        while(tmp != 0){
            remainder = tmp % 10;
            list.add(remainder);
            tmp /= 10;
        }
        for(int i = list.size(); i < 4; i++){
        	list.add(0);
        }
        Collections.sort(list);
        
        int pow = list.size() - 1;
        for(int i = 0; i < list.size(); i++){
            small += list.get(i) * Math.pow(10, pow);
            pow--;
        }
        return small;
    }
}
