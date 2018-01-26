import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // https://github.com/hotehrud/acmicpc
  // http://mygumi.tistory.com/

  private void solve() {
    int n = sc.nextInt();
    int r = sc.nextInt();
    int c = sc.nextInt();
    int ans = 0;
    int y = (int) Math.pow(2, n) / 2;
    int x = y;

    while (n-- > 0) {
      int temp = (int) Math.pow(2, n) / 2;
      int skip = (int) Math.pow(4, n);

      if (r < y && c < x) {
        // 1
        x -= temp;
        y -= temp;
      } else if (r < y && x <= c) {
        // 2
        x += temp;
        y -= temp;
        ans += skip;
      } else if (y <= r && c < x) {
        // 3
        x -= temp;
        y += temp;
        ans += skip * 2;
      } else {
        // 4
        x += temp;
        y += temp;
        ans += skip * 3;
      }
    }
    System.out.println(ans);
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

    static boolean hasNext() {
      return st.hasMoreTokens();
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