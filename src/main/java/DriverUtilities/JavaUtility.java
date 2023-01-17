package DriverUtilities;

import java.util.Random;

public class JavaUtility {
	public int Random(int numberToBeAdded)
	{
		Random r = new Random();
		int number = r.nextInt(numberToBeAdded);
		return number;
	}

}
