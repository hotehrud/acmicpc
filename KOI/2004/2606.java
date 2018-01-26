import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private void solve() {
    int n = sc.nextInt();
    int m = sc.nextInt();

    ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
    boolean[] c = new boolean[n + 1];

    for (int i = 1; i <= n; i++) {
      a[i] = new ArrayList<>();
    }

    for (int i = 1; i <= m; i++) {
      int v1 = sc.nextInt();
      int v2 = sc.nextInt();

      a[v1].add(v2);
      a[v2].add(v1);
    }

    System.out.println(bfs(a, c, 1));

  }

  public static int bfs(ArrayList<Integer>[] a, boolean[] c, int v) {
    Queue<Integer> q = new LinkedList<>();
    int cnt = 0;

    q.add(v);
    c[v] = true;

    while (!q.isEmpty()) {

      v = q.poll();

      for (int x : a[v]) {

        if (!c[x]) {
          cnt++;
          c[x] = true;
          q.add(x);
        }

      }

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