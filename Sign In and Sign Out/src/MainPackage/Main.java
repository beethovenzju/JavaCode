package MainPackage;

import java.util.*;


public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int count;
		String inString, outString, id;
		String unlockId = "", lockId = "";
		String unlockDate = null, lockDate = null;
		
		count = in.nextInt();

		for(int i = 0; i < count; i++)
		{
			id = in.next();
			inString = in.next();
			if(unlockDate == null)
			{
				unlockDate = inString;
				unlockId = id;
			}
			else
			{
				if(Main.compareDate(unlockDate, inString) > 0)
				{
					unlockDate = inString;
					unlockId = id;
				}
			}
				
			outString = in.next();
			if(lockDate == null)
			{
				lockDate = outString;
				lockId = id;
			}
			else
			{
				if(Main.compareDate(lockDate, outString) < 0)
				{
					lockDate = outString;
					lockId = id;
				}
			}
		}
			
		System.out.print(unlockId + " " + lockId);

		if(in != null)
			in.close();
	}
	
	public static int compareDate(String dateA, String dateB)
	{
		String[] a,b;
		int aValue, bValue;
		a = dateA.split(":");
		b = dateB.split(":");
		aValue = Integer.parseInt(a[0]) * 3600 + Integer.parseInt(a[1]) * 60 + Integer.parseInt(a[2]);
		bValue = Integer.parseInt(b[0]) * 3600 + Integer.parseInt(b[1]) * 60 + Integer.parseInt(b[2]);
		
		if(aValue ==bValue)
			return 0;
		else if(aValue < bValue)
			return -1;
		else
			return 1;
	}
}
