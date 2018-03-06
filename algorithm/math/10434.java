import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private void solve() {
    int t = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    boolean[] primes = new boolean[10001];
    int rootSqrt = (int) Math.sqrt(10000);
    Arrays.fill(primes, true);

    for (int i = 2; i <= rootSqrt; i++) {
      if (!primes[i]) {
        continue;
      }
      for (int j = i + i; j <= 10000; j += i) {
        primes[j] = false;
      }
    }

    while (t-- > 0) {
      boolean[] visited = new boolean[10001];
      int n = sc.nextInt();
      int m = sc.nextInt();
      int temp = m;

      if (!primes[temp] || temp == 1) {
        sb.append(n + " " + m + " NO\n");
        continue;
      }

      while(!visited[temp]) {
        visited[temp] = true;
        int c = cipher(temp);
        int result = 0;

        for (int i = 0; i < c; i++) {
          result += (temp % 10) * (temp % 10);
          temp /= 10;
        }
        temp = result;
      }

      if (temp == 1) {
        sb.append(n + " " + m + " YES\n");
      } else {
        sb.append(n + " " + m + " NO\n");
      }
    }
    System.out.println(sb.toString());
  }

  public static int cipher(int n) {
    int c = 10000;
    int cnt = 5;

    while (c > n) {
      --cnt;
      c /= 10;
    }

    return cnt;
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