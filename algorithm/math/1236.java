import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // http://mygumi.tistory.com/297
  private void solve() {
    int n = sc.nextInt();
    int m = sc.nextInt();
    char[][] map = new char[n][m];
    boolean[] row = new boolean[n];
    boolean[] col = new boolean[m];
    int c = 0;
    int r = 0;

    for (int i = 0; i < n; i++) {
      map[i] = sc.readLine().toCharArray();
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 'X') {
          col[j] = true;
          row[i] = true;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if (!row[i]) {
        ++r;
      }
    }

    for (int i = 0; i < m; i++) {
      if (!col[i]) {
        ++c;
      }
    }
    System.out.println(c > r ? c : r);
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