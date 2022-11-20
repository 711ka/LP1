import java.util.Scanner;
// Driver Code for All Algos:
public class Main
{
public static void main(String[] args)
{
first_fit first = new first_fit();
best_fit best = new best_fit();
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
System.out.println("1. First Fit ");
System.out.println("2. Best Fit");
System.out.println("3. exit");
System.out.println("Select the algorithm you want to implement: ");
choice = scan.nextInt();
switch(choice)
{
case 1:
System.out.println("First Fit Output");
first.firstFit(blockSize, m, processSize, n);
break;
case 2:
System.out.println("Best Fit Output");
best.bestFit(blockSize, m, processSize, n);
break;
case 3:
System.out.println("Exiting the code...");
return;
default:
System.out.println("Invalid option");
}
}
}
}