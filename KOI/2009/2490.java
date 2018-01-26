import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < 3; i++) {
      int count = 0;
      int[] arr = new int[4];
      for (int j = 0; j < 4; j++) {
        arr[j] = sc.nextInt();
      }

      for (int k = 0; k < 4; k++) {
        if (arr[k] == 1)
          count++;
      }
      if (count == 4)
        System.out.println("E");
      else if (count == 3)
        System.out.println("A");
      else if (count == 2)
        System.out.println("B");
      else if (count == 1)
        System.out.println("C");
      else
        System.out.println("D");
    }
  }
}