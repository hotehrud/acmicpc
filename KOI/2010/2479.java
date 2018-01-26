import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // https://github.com/hotehrud/acmicpc
  // http://mygumi.tistory.com/

  static boolean[] visited;
  static int[][] adj;
  static int n, k, a, b;
  static boolean flag;

  private void solve() {
    n = sc.nextInt();
    k = sc.nextInt();
    String[] s = new String[n];
    adj = new int[n + 1][n + 1];
    visited = new boolean[1001];

    for (int i = 0; i < n; i++) {
      s[i] = sc.readLine();
    }

    a = sc.nextInt();
    b = sc.nextInt();

    for (int i = 1; i < n; i++) {
      for (int j = i + 1; j <= n; j++) {
        if (checkHamming(s[i - 1], s[j - 1])) {
          adj[i][j] = 1;
          adj[j][i] = 1;
        }
      }
    }

    visited[a] = true;
    dfs(a, a + "");
    if (!flag) {
      System.out.println(-1);
    }
  }

  public static void dfs(int v, String s) {
    if (v == b) {
      flag = true;
      System.out.println(s);
      return;
    } else {
      for (int i = 1; i <= n; i++) {
        if (!visited[i] && adj[v][i] == 1) {
          visited[i] = true;
          dfs(i, s + " " + i);
        }
      }
    }
  }

  public static boolean checkHamming(String s1, String s2) {
    int cnt = 0;
    for (int i = 0; i < k; i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (++cnt >= 2) {
          return false;
        }
      }
    }
    if (cnt == 0) {
      return false;
    }
    return true;
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