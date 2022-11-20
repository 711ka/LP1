import java.util.Scanner;

import fcfs.FCFS;
import prio.PRIO;

public class Main  {
    public static void main (String args [])
    {
        int choice;
        System.out.println("1 FCFS    2 PRIORITY");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();

        switch(choice){

        case 1:
        FCFS obj = new FCFS();
        obj.main(args); break;
        
        case 2:
        PRIO obj1 = new PRIO();
        obj1.main(args); break;
        }
    }
}
