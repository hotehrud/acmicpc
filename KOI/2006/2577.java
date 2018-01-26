import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int[] arr = new int[10];

    int t = a * b * c;

    while (t > 0) {
      arr[t % 10]++;
      t /= 10;
    }

    for (int i = 0; i < 10; i++) {
      System.out.println(arr[i]);
    }
  }
}