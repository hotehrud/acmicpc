import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

  private void solve() {
    int n = sc.nextInt();
    int v = sc.nextInt();
    int p = sc.nextInt();
    Integer[] array = new Integer[n + 1];
    Arrays.fill(array, 2000000001);

    if (n == 0) {
      System.out.println(1);
      return;
    }

    for (int i = 0; i < n; i++) {
      array[i] = sc.nextInt();
    }

    int last = array[n - 1];

    if (n == p) {
      if (last < v) {
        array[n] = v;
      } else {
        System.out.println(-1);
        return;
      }
    } else {
      array[n] = v;
    }

    Arrays.sort(array, Collections.reverseOrder());

    for (int i = 0; i <= p; i++) {
      if (array[i] == v) {
        System.out.println(i + 1);
        return;
      }
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