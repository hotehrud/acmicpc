import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // http://mygumi.tistory.com/305
  // https://github.com/hotehrud/acmicpc

  private void solve() {
    int n = sc.nextInt();
    int c = sc.nextInt();
    StringBuilder sb = new StringBuilder();

    while (c-- > 0) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int gap = Math.abs(a - b);
      int remain = n - Math.max(a, b);

      if (a == b) {
        sb.append("1\n");
      } else if (a < b) {
        if (gap - remain <= 1) {
          sb.append("1\n");
        } else {
          sb.append("0\n");
        }
      } else {
        if (gap - remain <= 2) {
          sb.append("1\n");
        } else {
          sb.append("0\n");
        }
      }
    }
    System.out.println(sb.toString());
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