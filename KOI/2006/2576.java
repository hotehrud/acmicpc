import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int sum = 0;
    int min = 100;

    for (int i = 0; i < 7; i++) {
      int n = sc.nextInt();
      if (n % 2 != 0) {
        if (min > n) {
          min = n;
        }
        sum += n;
      }
    }
    if (sum == 0) {
      System.out.println(-1);
    } else {
      System.out.println(sum + "\n" + min);
    }
  }
}
