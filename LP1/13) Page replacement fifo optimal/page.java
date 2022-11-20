import java.util.*;

class page {

  static boolean search(int key, int[] fr) {
    for (int i = 0; i < fr.length; i++) if (fr[i] == key) return true;
    return false;
  }

  static int predict(int pg[], int[] fr, int pn, int index) {
    int res = -1, farthest = index;
    for (int i = 0; i < fr.length; i++) {
      int j;
      for (j = index; j < pn; j++) {
        if (fr[i] == pg[j]) {
          if (j > farthest) {
            farthest = j;
            res = i;
          }
          break;
        }
      }
      if (j == pn) return i;
    }
    return (res == -1) ? 0 : res;
  }

  static void optimalPage(int pg[], int n, int fn) {
    int[] fr = new int[fn];
    int hit = 0;
    int index = 0;
    for (int i = 0; i < n; i++) {
      if (search(pg[i], fr)) {
        hit++;
        continue;
      }
      if (index < fn) fr[index++] = pg[i]; else {
        int j = predict(pg, fr, n, i + 1);
        fr[j] = pg[i];
      }
    }
    System.out.println("Page faults: " + (n - hit));
    System.out.println("Hits: " + hit);
  }


  static void fifo(int incomingStream[], int n, int frames) {
    HashSet s = new HashSet<>(frames);
    Queue queue = new LinkedList<>();
    int page_faults = 0;
    for (int i = 0; i < n; i++) {
      if (s.size() < frames) {
        if (!s.contains(incomingStream[i])) {
          s.add(incomingStream[i]);
          page_faults++;
          queue.add(incomingStream[i]);
        }
      } else {
        if (!s.contains(incomingStream[i])) {
          int val = (int) queue.peek();
          queue.poll();
          s.remove(val);
          s.add(incomingStream[i]);
          queue.add(incomingStream[i]);
          page_faults++;
        }
      }
    }
    System.out.println("Page faults: " + page_faults);
    System.out.println("Hits: " + (n - page_faults));
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("---PAGE REPLACEMENT ALGORITHMS---");
    System.out.println("-1)fifo");
    System.out.println("2)optimal");
    System.out.println("Enter ur choice: ");
    int choice;
    choice = sc.nextInt();
    int n;
    System.out.println("Enter no of pages:");
    n = sc.nextInt();
    int[] string = new int[n];
    System.out.println("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
      string[i] = sc.nextInt();
    }
    int frames;
    System.out.println("Enter no of frame: ");
    frames = sc.nextInt();
    sc.close();
    switch (choice) {
      case 1:
        fifo(string, n, frames);
        break;
      case 2:
        optimalPage(string, n, frames);
        break;
      default:
        System.out.println("Wrong choice");
    }
  }
}
