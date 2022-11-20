import java.util.Scanner;
// Driver Code for All Algos:
public class Main
{
public static void main(String[] args)
{
best_fit best = new best_fit();
worst_fit worst = new worst_fit();
next_fit next = new next_fit();

Scanner scan = new Scanner(System.in);
while(true)
{
int choice;
System.out.println();
System.out.println("Enter the number of Blocks: ");
int m = scan.nextInt();
System.out.println("Enter the number of Processes: ");
int n = scan.nextInt();
int blockSize[] = new int[m]; int processSize[] = new int[n];
System.out.println("Enter the Size of all the blocks: ");
for (int i = 0; i<m; i++)
{
blockSize[i] = scan.nextInt();
}
System.out.println("Enter the size of all processes: ");
for (int i = 0; i<n; i++)
{
processSize[i] = scan.nextInt();
}
System.out.println();
System.out.println("Menu");
System.out.println("1. Best Fit ");
System.out.println("2. Worst Fit");
System.out.println("3. Next Fit");
System.out.println("4. exit");
System.out.println("Select the algorithm you want to implement: ");
choice = scan.nextInt();
switch(choice)
{
case 1:
System.out.println("Best Fit Output");
best.bestFit(blockSize, m, processSize, n);
break;
case 2:
System.out.println("Worst Fit Output");
worst.worstFit(blockSize, m, processSize, n);
break;
case 3:
System.out.println("Next Fit Output");
next.NextFit(blockSize, m, processSize, n);
break;
case 4:
System.out.println("Exiting the code...");
return;
default:
System.out.println("Invalid option");
}
}
}
}