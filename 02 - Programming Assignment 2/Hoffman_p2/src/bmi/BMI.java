package bmi;

import java.util.Scanner;

public class BMI 
{
	/*Create a BMI calculator that reads the user’s weight and height (providing an option for 
	 * the user to select which formula to use), and then calculates and displays the user’s body 
	 * mass index. Also, display the BMI categories and their values from the National Heart Lung 
	 * and Blood Institute: http://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmicalc.htm 
	 * (Links to an external site.) so the user can evaluate his/her BMI.*/
	public static void main(String[] args)
	{
		Scanner scnr = new Scanner(System.in);
		boolean checkPrompt=false;
		float height, weight, bmi = 0;
		int prompt;
		
		// Pounds or Kilos
		do
		{
		System.out.print("Pounds/Inches (1) or Kilograms/Meters (2): ");
		prompt = scnr.nextInt();
		if((prompt > 2) || (prompt < 1))
		{
			System.out.print("Wrong. Enter a (1) or a (2).");
		}
		else {checkPrompt = true;}
		}while(checkPrompt == false);
		
		
		//Obtaining values
		System.out.print("Enter your height: ");
		height = scnr.nextInt();
		System.out.print("Enter your weight: ");
		weight = scnr.nextInt();
		
		//Calculating BMI
		switch(prompt)
		{
		case 1:
		bmi = (703 * weight) / (height * height);
		break;
		case 2: 
		bmi = weight / (height * height);
		break;
		}
		
		//Display BMI w/ table
		System.out.printf("Your BMI is: %.2f\n", bmi);
		System.out.print("BMI Categories\nUnderweight = <18.5\nNormal Weight = 18.5-24.9\nOverweight = 25.0-29.9\nObesity = BMI of 30.0 or greater");
	}
}
