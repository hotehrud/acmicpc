import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private void solve() {
    int n = sc.nextInt();
    int[] array = new int[n];
    int[] dp = new int[n];

    for (int i = 0; i < n; i++) {
      array[i] = sc.nextInt();
    }

    // dp[n] = max( 이전 계단을 밟지 않고 온 경우 || 이전 계단을 밟고 온 경우 )
    // dp[n] = max( dp[n-2] + array[n]|| dp[n-3] + array[n] + array[n-1] )

    dp[0] = array[0];

    for (int i = 1; i < 3; i++) {

      if (i == 1) {
        dp[i] = max(dp[i - 1] + array[i], array[i]);
      } else {
        dp[i] = max(dp[i - 2] + array[i], array[i - 1] + array[i]);
      }

    }

    for (int i = 3; i < n; i++) {
      dp[i] = max(dp[i - 2] + array[i], dp[i - 3] + array[i] + array[i - 1]);
    }

    System.out.println(dp[n - 1]);
  }

  public static int max(int a, int b) {
    if (a < b) {
      return b;
    } else {
      return a;
    }
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