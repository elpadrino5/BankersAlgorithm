package osprj2;

import java.util.Scanner;

class Bank 
{
	int ResourceA;
	int ResourceB;
	int ResourceC;
	public Bank(int ResA, int ResB, int ResC)
	{
		this.ResourceA = ResA;
		this.ResourceB = ResB;
		this.ResourceC = ResC;
	}
}

public class BankersAlg {
	
	public static void main(String[] args) 
	{
		int	numCust = 5; //number of Pes
		int numRes = 3; //number of resources
		int startcnt = 0;
		int truecnt = 0;
		int P, i, j, k;
		int [][] max = {{7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3}};
		int [][] alloc = {{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}};		
		int [][] need = new int[numCust][numRes];;
		int [] avail = {3,3,2};
		int [] request = new int[numRes];
		int [] fin = {0,0,0,0,0};
		boolean condition1 = true;
		boolean condition2 = true;
		boolean condition3 = true;
				
		Bank theBank = new Bank(10,5,7);
		
		//System.out.println("MAX");
		//System.out.println("-------");
		for (i= 0; i < numCust; i++)
		{
			for (j= 0; j < numRes; j++)
			{
				//System.out.printf("%d  ", max[i][j]);
			}
			//System.out.println();
		}
		//System.out.println();
		
		//System.out.println("ALLOC");
		//System.out.println("-------");
		for (i= 0; i < numCust; i++)
		{
			for (j= 0; j < numRes; j++)
			{
				//System.out.printf("%d  ", alloc[i][j]);
			}
			//System.out.println();
		}
		//System.out.println();
		
		//Calculate need
		for (i= 0; i < numCust; i++)
		{
			for (j= 0; j < numRes; j++)
			{
				need[i][j] = max[i][j] - alloc[i][j];
			}
		}
		//System.out.println("NEED");
		//System.out.println("-------");
		for (i= 0; i < numCust; i++)
		{
			for (j= 0; j < numRes; j++)
			{
				//System.out.printf("%d  ", need[i][j]);
			}
			//System.out.println("");
		}
		//System.out.println("");
		
		//System.out.println("AVAILABLE");
		//System.out.println("-------");
		for (i= 0; i < numRes; i++)
		{
			//System.out.printf("%d  ", avail[i]);
		}
		//System.out.println();
		
		Scanner getreq = new Scanner(System.in);
		//System.out.print("\nWhat proccess is making a request?(0 to 4):");
		P = getreq.nextInt();
		//System.out.print("Request for resource A:");
		request[0] = getreq.nextInt();
		//System.out.print("Request for resource B:");
		request[1] = getreq.nextInt();
		//System.out.print("Request for resource C:");
		request[2] = getreq.nextInt();
		
		//System.out.printf("Your request for Process%d is (%d,%d,%d).\n", P, request[0], request[1], request[2]);
		
		//System.out.println();		
		for (i= 0; i < numRes; i++)
		{
			if (request[i] <= need[P][i] && condition1)
			{
				condition1 = true;
			}
			else
			{
				//System.out.println("REQUEST DENIED!!!");
				//System.out.printf("REQUEST%d (%d,%d,%d) is greater than NEED%d (%d,%d,%d).\n",
				P, request[0], request[1], request[2], P, need[P][0], need[P][1], need[P][2]);				
				condition1 = false;
				break;
			}		
		}
		if (condition1)
		{
			//System.out.println("First condition was met!");
			//System.out.printf("REQUEST%d (%d,%d,%d) is less than or equal to NEED%d (%d,%d,%d).\n",
			P, request[0], request[1], request[2], P, need[P][0], need[P][1], need[P][2]);
		}
		
		if(condition1)
		{
			for (i= 0; i < numRes; i++)
			{
				if (request[i] <= avail[i] && condition2)
				{
					condition2 = true;
				}
				else
				{
					//System.out.println("REQUEST DENIED!!!");
					//System.out.printf("Request%d (%d,%d,%d) is more than what's available (%d,%d,%d).\n",
					P, request[0], request[1], request[2], avail[0], avail[1], avail[2]);				
					condition2 = false;
					break;
				}		
			}
			if (condition2)
			{
				//System.out.println("Second Condition was met!");
				//System.out.printf("REQUEST%d (%d,%d,%d) is less than or equal to what's AVAILABLE (%d,%d,%d).\n",
				P, request[0], request[1], request[2], avail[0], avail[1], avail[2]);	
			}
		}
		
		if(condition1 && condition2)
		{
			for (i = 0; i < numRes; i++)
			{
				avail[i] = avail[i] - request[i];
				alloc[P][i] = alloc[P][i] + request[i];
				need[P][i] = need[P][i] - request[i];
			}
			//System.out.printf("\nThe resources AVAILABLE has been changed to (%d,%d,%d).\n", avail[0], avail[1], avail[2]);
			//System.out.printf("Process%d ALLOCATION has been changed to (%d,%d,%d).\n", P, alloc[P][0], alloc[P][1], alloc[P][2]);
			//System.out.printf("Process%d NEED has been changed to (%d,%d,%d).\n", P, need[P][0], need[P][1], need[P][2]);
			//System.out.println();
		}
		//check each process is satisfied
		if (condition1 && condition2)
		{
			do
			{
				startcnt = truecnt;
				for (i= 0; i < numCust; i++)
				{
					if (fin[i] == 0)
					{
						condition3 = true;
						for (j= 0; j < numRes; j++)
						{						
								if (need[i][j] <= avail[j])
								{
									continue;
								}		
								else
								{
									condition3 = false;
								}
						}
						if (condition3 == true)
						{
							//System.out.printf("P%d   %d %d %d <= %d %d %d      Finish[%d] = true     ",
							i, need[i][0], need[i][1], need[i][2], avail[0], avail[1], avail[2], i);
							fin[i] = 1;
							truecnt ++;
							for (j= 0; j < numRes; j++)
							{		
								avail[j] = avail[j] + alloc[i][j];
							}						
							//System.out.printf("new Available = %d %d %d \n", avail[0], avail[1], avail[2]);
						}
						else
						{
							//System.out.printf("P%d   %d %d %d <= %d %d %d      Finish[%d] = false     X\n",
							i, need[i][0], need[i][1], need[i][2], avail[0], avail[1], avail[2], i);
						}						
					}
				}
				//System.out.printf("\nStarting count is %d and true count is %d\n", startcnt, truecnt);
				//System.out.println();
			} while ((fin[0] == 0 || fin[1] == 0 || fin[2] == 0 || fin[3] == 0 || fin[4] == 0) && startcnt < truecnt);
			
			if((fin[0] == 0 || fin[1] == 0 || fin[2] == 0 || fin[3] == 0 || fin[4] == 0))
			{
				//System.out.println("\nREQUEST DENIED!!!");
				//System.out.printf("The request for Process%d of (%d,%d,%d) does NOT leave the bank in a safe state.\n",
				P, request[0], request[1], request[2]);
			}
			else
			{
				//System.out.println("\nREQUEST GRANTED!!!");
				//System.out.printf("The request for Process%d of (%d,%d,%d) satisfies the safety algorithm.\n",
				P, request[0], request[1], request[2]);
				
			}
		}		
		
	}
}
