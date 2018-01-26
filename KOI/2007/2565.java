import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

  private void solve() {
    // LIS 
    int n = sc.nextInt();
    int[] array = new int[501];
    int[] dp = new int[501];
    int max = 1;

    dp[1] = 1;

    for (int i = 0; i < n; i++) {
      array[sc.nextInt()] = sc.nextInt();
    }

    for (int i = 2; i <= 500; i++) {
      dp[i] = 1;
      for (int j = 1; j < i; j++) {
        if (array[j] == 0) {
          continue;
        }
        if (array[i] > array[j] && dp[j] + 1 > dp[i]) {
          dp[i] = dp[j] + 1;
        }
      }
      if (max < dp[i]) {
        max = dp[i];
      }
    }
    System.out.println(n - max);
  }

  public static void main(String[] args) {
    sc.init();

    new Main().solve();
  }

  static class sc {
    private static BufferedReader br;
    private static StringTokenizer st;

    static void init() {
      br = new BufferedReader(new InputStreamReader(System.in));
      st = new StringTokenizer("");
    }

    static String readLine() {
      try {
        return br.readLine();
      } catch (IOException e) {
      }
      return null;
    }

    static String readLineReplace() {
      try {
        return br.readLine().replaceAll("\\s+", "");
      } catch (IOException e) {
      }
      return null;
    }

    static String next() {
      while (!st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
        }
      }
      return st.nextToken();
    }

    static long nextLong() {
      return Long.parseLong(next());
    }

    static int nextInt() {
      return Integer.parseInt(next());
    }

    static double nextDouble() {
      return Double.parseDouble(next());
    }
  }
}