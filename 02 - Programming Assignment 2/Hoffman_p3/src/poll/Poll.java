package poll;
import java.util.Scanner;

public class Poll {
	public static void main(String[] args)
	{
		Scanner scnr = new Scanner(System.in);
		String topics[] = {"Dance", "Travel", "Food", "Rescues", "Gym"};
		int responses[][] = new int[5][10];
		int count[][] = new int[5][10], sum[] = {0, 0, 0, 0, 0};
		int avg[] = new int[5];
		int high = -1000, low = 1000;
		
		//Initialize count[][]
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<10;j++)
			{
				count[i][j] = 0;
			}
		}
		
		//Poll
		for(int i = 0; i < 10; i++)
		{
			System.out.print("Person: " + (i+1) + "/10\nRate the following on a scale of 1-10:\n");
			for(int j = 0; j < 5; j++)
			{
				System.out.print(topics[j] + ": ");
				responses[j][i] = scnr.nextInt();
			}
		}
		
		//Analysis
		
		for(int i = 0; i<5; i++)
		{
			for(int j = 0; j<10;j++)
			{
				//Counting
				for(int s=1;s<11;s++)
				{
					count[i][s-1] = (responses[i][j] == s)?count[i][s-1]+1:count[i][s-1];
				}
				//Sum
				sum[i] = sum[i] + responses[i][j];
			}
			//Average
			avg[i] = sum[i]/10;
			high = (sum[i] > high)?sum[i]:high;
			low = (sum[i]<low)?sum[i]:low;
		}
		
		//Poll
		System.out.print("\t\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\tAvg\n");
		for(int i = 0; i<5; i++)
		{
			System.out.print(topics[i] + "\t\t");
			for(int j = 0; j<10;j++)
			{
				System.out.print(count[i][j] + "\t");
			}
			System.out.printf("%d", avg[i]);
			System.out.println("");
		}
		
		for(int i = 0; i<5; i++)
		{
			if(sum[i] == high)
				System.out.print(topics[i] + " has the highest points at " + high + "\n");
			if(sum[i] == low)
				System.out.print(topics[i] + " has the lowest points at " + low + "\n");
		}
	}
}
