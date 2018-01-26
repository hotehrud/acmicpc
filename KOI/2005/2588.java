import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int a = sc.nextInt();
    int b = sc.nextInt();
    int sum = 0;

    for (int i = 0; i < 3; i++) {
      int n = b % 10;
      int temp = a * n;
      sum += temp * (int) Math.pow(10, i);
      b = b / 10;

      sb.append(temp + "\n");
    }
    sb.append(sum);
    System.out.println(sb.toString());
  }
}
