import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int sum;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String[] s = br.readLine().split(" ");
    int d = Integer.parseInt(s[0]);
    int k = Integer.parseInt(s[1]);
    int a = 0, b = 0;

    out: for (int i = 1; i < k; i++) {
      for (int j = i; j < k; j++) {
        sum = 0;
        a = i;
        b = j;
        int temp = a;
        for (int n = 2; n < d; n++) {
          temp = a;
          a = b;
          b += temp;
          if (b > k) {
            break;
          }
        }
        if (b == k) {
          a = i;
          b = j;
          break out;
        }
      }
    }
    System.out.println(a + "\n" + b);
  }
}
