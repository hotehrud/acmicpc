import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // https://mygumi.tistory.com/363
  static char[] find;
  static char[] devil;
  static char[] angel;
  static int[][][] dp = new int[100][20][2]; // 현재 밟은 곳, 다음 밟을 곳, 악마인지 천사인지.
  static int ans;

  private void solve() {
    find = sc.readLine().toCharArray();
    devil = sc.readLine().toCharArray();
    angel = sc.readLine().toCharArray();

    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 20; j++) {
        for (int k = 0; k < 2; k++) {
          dp[i][j][k] = -1;
        }
      }
    }

    int a = move(0, 0, 0);
    int b = move(0, 0, 1);

    System.out.println(a + b);
  }

  public static int move(int c, int f, int r) {
    if (f == find.length) {
      return 1;
    }

    if (dp[c][f][r] > -1) {
      return dp[c][f][r];
    }

    int total = 0;
    if (r == 0) {
      for (int i = c; i < devil.length; i++) {

        if (find[f] == devil[i]) {
          total += move(i + 1, f + 1, 1);
        }

      }
    } else {
      for (int i = c; i < angel.length; i++) {

        if (find[f] == angel[i]) {
          total += move(i + 1, f + 1, 0);
        }

      }
    }

    return dp[c][f][r] = total;
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
        String input = br.readLine();

        st = new StringTokenizer(input);

        return input;
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
