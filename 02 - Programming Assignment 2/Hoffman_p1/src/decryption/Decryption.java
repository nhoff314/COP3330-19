package decryption;

import java.util.Scanner;

public class Decryption {
	/*A company that wants to send data over the Internet has asked you to 
	* write a program that will encrypt it so that it may be transmitted 
	* more securely. All the data is transmitted as four-digit integers. 
	* Your application should read a four-digit integer entered by the user 
	* and encrypt it as follows: Replace each digit with the result of adding 
	* 7 to the digit and getting the remainder after dividing the new value by 10. 
	* Then swap the first digit with the third, and swap the second digit with the 
	* fourth. Then print the encrypted integer. Write a separate application that 
	* inputs an encrypted four-digit integer and decrypts it (by reversing the 
	* encryption scheme) to form the original number. */
	public static void main(String[] args) 
	{
		Scanner scnr = new Scanner(System.in);
		int userCode, encryptCode, firstDigit, secondDigit, thirdDigit, fourthDigit;
		boolean check = false;
			
		// Takes an integer from user and checks to ensure 4 digits
		do
		{
			System.out.print("Enter a four digit integer: ");
			encryptCode = scnr.nextInt();
			if((encryptCode / 10000 != 0) || (encryptCode / 1000 == 0))
			{
				System.out.println("Not a four digit integer!");
			}
			else
			{
				check = true;
			}
		
		}while(check == false);
			
		// Finding digits
		firstDigit = encryptCode/1000;
		secondDigit = (encryptCode%1000)/100;
		thirdDigit = (encryptCode%100)/10;
		fourthDigit = (encryptCode%10);
		
		// Encryption
		firstDigit = (firstDigit+13)%10;
		secondDigit = (secondDigit+13)%10;
		thirdDigit = (thirdDigit+13)%10;
		fourthDigit = (fourthDigit+13)%10;
		userCode = (thirdDigit * 1000) + (fourthDigit * 100) + (firstDigit * 10) + (secondDigit);
			
		//Print Encrypted Integer
		System.out.printf("The User's Key: %d", userCode);
	}
}
