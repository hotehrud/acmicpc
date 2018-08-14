import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // http://mygumi.tistory.com/327
  private void solve() {
    int n = sc.nextInt();
    char[][] map = new char[101][101];

    for (int i = 0; i < n; i++) {
      String[] s = sc.next().split("");
      for (int j = 0; j < n; j++) {
        map[i][j] = s[j].charAt(0);
      }
      // 벽 또한 짐으로 판단
      map[i][n] = 'X';
      map[n][i] = 'X';
    }

    // (X or 벽) 판단
    int r = 0;
    int c = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        r += (map[i][j] == '.' && map[i][j + 1] == '.' && map[i][j + 2] == 'X') ? 1 : 0;
        c += (map[j][i] == '.' && map[j + 1][i] == '.' && map[j + 2][i] == 'X') ? 1 : 0;
      }
    }

    System.out.println(r + " " + c);
  }

  public static void basic() {
    int n = sc.nextInt();
    char[][] map = new char[101][101];

    for (int i = 0; i < n; i++) {
      String[] s = sc.next().split("");
      for (int j = 0; j < n; j++) {
        map[i][j] = s[j].charAt(0);
      }
    }

    int cnt = 0;
    int seat = 0;
    for (int i = 0; i < n; i++) {
      seat = 0;
      for (int j = 0; j < n; j++) {
        if (map[i][j] == '.') {
          ++seat;
        } else {
          if (seat >= 2) {
            ++cnt;
          }
          seat = 0;
        }
      }
      if (seat >= 2) {
        ++cnt;
      }
    }

    System.out.print(cnt + " ");
    cnt = 0;
    for (int i = 0; i < n; i++) {
      seat = 0;
      for (int j = 0; j < n; j++) {
        if (map[j][i] == '.') {
          ++seat;
        } else {
          if (seat >= 2) {
            ++cnt;
          }
          seat = 0;
        }
      }
      if (seat >= 2) {
        ++cnt;
      }
    }
    System.out.println(cnt);
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