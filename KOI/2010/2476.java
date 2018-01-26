import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int max;
  static int sameN;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine().trim());
    String[] s = new String[3];
    int Max = 0;

    for (int i = 0; i < t; i++) {
      s = br.readLine().split(" ");
      int a = Integer.parseInt(s[0]);
      int b = Integer.parseInt(s[1]);
      int c = Integer.parseInt(s[2]);
      int sum = 0;

      int same = sameCount(a, b, c);

      if (same == 3) {
        sum = 10000 + (a * 1000);
      } else if (same == 2) {
        sum = 1000 + (sameN * 100);
      } else {
        sum = max * 100;
      }

      if (Max < sum) {
        Max = sum;
      }
    }
    System.out.println(Max);
  }

  public static int sameCount(int a, int b, int c) {
    if (a == b && b == c) {
      return 3;
    } else if (a == b || a == c || b == c) {
      if (a == b) {
        sameN = a;
      } else if (b == c) {
        sameN = b;
      } else {
        sameN = c;
      }
      return 2;
    } else {
      max = a;
      if (max < b) {
        max = b;
      }
      if (max < c) {
        max = c;
      }
      return 1;
    }
  }
}
