import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // https://github.com/hotehrud/acmicpc
  // http://mygumi.tistory.com/

  static boolean[][] visited = new boolean[6][6];
  static int[][] map = new int[6][6];

  private void solve() {
    int[] array = new int[26];

    for (int i = 1; i <= 5; i++) {
      for (int j = 1; j <= 5; j++) {
        map[i][j] = sc.nextInt();
      }
    }

    for (int i = 1; i <= 25; i++) {
      array[i] = sc.nextInt();
    }

    for (int i = 1; i <= 25; i++) {
      int n = check(array[i]);
      if (n >= 3) {
        System.out.println(i);
        return;
      }
    }
  }

  public static int check(int n) {
    int cnt = 0;
    for (int i = 1; i <= 5; i++) {
      for (int j = 1; j <= 5; j++) {
        if (map[i][j] == n) {
          visited[i][j] = true;
        }
      }
    }

    for (int i = 1; i <= 5; i++) {
      boolean col = true;
      boolean row = true;
      for (int j = 1; j <= 5; j++) {
        if (!visited[i][j]) {
          col = false;
        }
        if (!visited[j][i]) {
          row = false;
        }
      }

      if (col) {
        ++cnt;
      }
      if (row) {
        ++cnt;
      }
    }

    boolean d1 = true;
    boolean d2 = true;
    for (int i = 1; i <= 5; i++) {
      if (!visited[i][i]) {
        d1 = false;
      }
    }

    for (int i = 1; i <= 5; i++) {
      if (!visited[5 - i + 1][i]) {
        d2 = false;
      }
    }

    if (d1) {
      ++cnt;
    }
    if (d2) {
      ++cnt;
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