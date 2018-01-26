import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  // https://github.com/hotehrud/acmicpc
  // http://mygumi.tistory.com/
  private void solve() {
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] sx = new int[m];
    int[] sy = new int[m];
    int x = 0;
    int y = 0;
    int ans = 0;

    for (int i = 0; i < m; i++) {
      sx[i] = sc.nextInt();
      sy[i] = sc.nextInt();
    }

    Arrays.sort(sx);
    Arrays.sort(sy);

    x = sx[m / 2];
    y = sy[m / 2];

    for (int i = 0; i < m; i++) {
      ans += Math.abs(sx[i] - x);
      ans += Math.abs(sy[i] - y);
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