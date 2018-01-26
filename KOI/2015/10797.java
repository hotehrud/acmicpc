import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    int[] arr = new int[5];
    int count = 0;

    for (int i = 0; i < 5; i++) {
      arr[i] = sc.nextInt();
    }

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 10 == num)
        count++;
    }

    System.out.println(count);
  }

}