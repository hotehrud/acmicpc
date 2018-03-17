import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // http://mygumi.tistory.com/302
  // https://github.com/hotehrud/acmicpc

  static int ans;
  static char[][] map;
  static int n;

  private void solve() {
    n = sc.nextInt();
    map = new char[n][n];

    for (int i = 0; i < n; i++) {
      map[i] = sc.readLine().toCharArray();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        char temp = map[i][j];
        map[i][j] = map[i][j + 1];
        map[i][j + 1] = temp;
        check();
        temp = map[i][j + 1];
        map[i][j + 1] = map[i][j];
        map[i][j] = temp;

        temp = map[j][i];
        map[j][i] = map[j + 1][i];
        map[j + 1][i] = temp;
        check();
        temp = map[j + 1][i];
        map[j + 1][i] = map[j][i];
        map[j][i] = temp;
      }
    }
    System.out.println(ans);
  }

  public static void check() {
    for (int i = 0; i < n; i++) {
      int cnt = 1;
      for (int j = 1; j < n; j++) {
        if (map[i][j] == map[i][j - 1]) {
          ++cnt;
        } else {
          ans = max(ans, cnt);
          cnt = 1;
        }
      }
      ans = max(ans, cnt);
    }

    for (int i = 0; i < n; i++) {
      int cnt = 1;
      for (int j = 1; j < n; j++) {
        if (map[j][i] == map[j - 1][i]) {
          ++cnt;
        } else {
          ans = max(ans, cnt);
          cnt = 1;
        }
      }
      ans = max(ans, cnt);
    }
  }

  public static int max(int x, int y) {
    return x > y ? x : y;
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