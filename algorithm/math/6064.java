import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // http://mygumi.tistory.com/325
  private void solve() {
    int t = sc.nextInt();
    StringBuilder sb = new StringBuilder();

    while (t-- > 0) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();

      int cnt = x % (m + 1);
      int tempY = x;

      for (int i = 0; i < n; i++) {
        int ty = tempY % n == 0 ? n : tempY % n;
        if (ty == y) {
          break;
        }

        tempY = ty + m;
        cnt += m;
      }
      sb.append(cnt > lcm(m, n) ? "-1" : cnt);
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }

  public static int gcd(int a, int b) {
    while (b != 0) {
      int r = a % b;
      a = b;
      b = r;
    }
    return a;
  }

  public static int lcm(int a, int b) {
    return a * b / gcd(a, b);
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