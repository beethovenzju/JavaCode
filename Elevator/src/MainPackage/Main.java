package MainPackage;

import java.util.*;

public class Main 
{
	public static void main(String[] args)
	{
		
		Scanner in = new Scanner(System.in);
		int totalTime = 0;
		final int STAY_TIME = 5;
		final int UP_TIME = 6;
		final int DOWN_TIME = 4;
		int count = 0;
		int lastFloor = 0;
		int currentFloor;
		
		count = in.nextInt();
		totalTime += count * STAY_TIME;
		for(int i = 0; i < count; i++)
		{
			currentFloor = in.nextInt();
			if(currentFloor > lastFloor)
				totalTime += (currentFloor - lastFloor) * UP_TIME;
			else if(currentFloor < lastFloor)
				totalTime += (lastFloor - currentFloor) * DOWN_TIME;
			
			lastFloor = currentFloor;
		}
		
		System.out.print(totalTime);
	}
}
