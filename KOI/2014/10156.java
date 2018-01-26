import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int k = sc.nextInt();
    int n = sc.nextInt();
    int m = sc.nextInt();

    int sum = k * n - m;

    if (sum >= 0)
      System.out.println(k * n - m);
    else
      System.out.println(0);
  }
}