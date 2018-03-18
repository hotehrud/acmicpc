import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // http://mygumi.tistory.com/303
  // https://github.com/hotehrud/acmicpc/

  static int[] dp;

  private void solve() {
    int n = sc.nextInt();
    dp = new int[n];
    int[] array = new int[n];

    for (int i = 0; i < n; i++) {
      array[i] = sc.nextInt();
    }

    dp[0] = array[0];
    int idx = 0;
    for (int i = 1; i < n; i++) {
      if (dp[idx] < array[i]) {
        dp[++idx] = array[i];
      } else {
        int ii = lower_bound(idx, array[i]);
        dp[ii] = array[i];
      }
    }
    System.out.println(idx + 1);
  }

  static int lower_bound(int end, int n) {
    int start = 0;

    while (start < end) {
      int mid = (start + end) / 2;
      if (dp[mid] >= n) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return end;
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

    static boolean hasNext() {
      return st.hasMoreTokens();
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
