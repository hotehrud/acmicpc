import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  // http://mygumi.tistory.com/337
  static ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[10001];
  static boolean[] visited = new boolean[10001];
  static int[] ans = new int[10001];
  static int cnt = 0;

  private void solve() {
    StringBuilder sb = new StringBuilder();
    int n = sc.nextInt();
    int m = sc.nextInt();

    for (int i = 1; i <= n; i++) {
      a[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < m; i++) {
      int v1 = sc.nextInt();
      int v2 = sc.nextInt();

      a[v1].add(v2);
    }

    int max = 0;
    for (int i = 1; i <= n; i++) {
      visited = new boolean[10001];
      dfs(i);
    }

    for (int i = 1; i <= n; i++) {
      if (max < ans[i]) {
        max = ans[i];
      }
    }

    for (int i = 1; i <= n; i++) {
      if (max == ans[i]) {
        sb.append(i + " ");
      }
    }

    System.out.println(sb.toString());
  }

  public static void dfs(int v) {
    visited[v] = true;

    for (int vv : a[v]) {
      if (!visited[vv]) {
        ans[vv]++;
        dfs(vv);
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
