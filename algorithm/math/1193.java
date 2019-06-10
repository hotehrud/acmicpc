import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private void solve() {
    int x = sc.nextInt();
    int[] array = new int[4473];
    int n = 1;
    int c = -1;

    for (int i = 1; i < 4473; i++) {
      array[i] = array[i - 1] + n++;

      if (array[i] >= x && c == -1) {
        c = i;
        break;
      }
    }
    int v = array[c] - x;
    int a = c - v;
    int b = c - a + 1;
    if (c % 2 == 0) {
      // 아래 방향
      System.out.println(a + "/" + b);
    } else {
      System.out.println(b + "/" + a);
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
