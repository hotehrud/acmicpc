import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static final int[] dx = { 0, 0, 1, -1, 0, 0 };
  public static final int[] dy = { 1, -1, 0, 0, 0, 0 };
  public static final int[] dz = { 0, 0, 0, 0, 1, -1 };
  public static int n;
  public static int m;
  public static int h;

  private void solve() {
    n = sc.nextInt();
    m = sc.nextInt();
    h = sc.nextInt();

    int[][][] a = new int[h + 1][m + 1][n + 1];
    int[][][] dist = new int[h + 1][m + 1][n + 1];
    boolean[][][] c = new boolean[h + 1][m + 1][n + 1];
    Queue<Pair> q = new LinkedList<>();
    int ans = -1;

    for (int k = 1; k <= h; k++) {
      for (int i = 1; i <= m; i++) {
        String[] s = sc.readLine().split(" ");

        for (int j = 1; j <= n; j++) {
          a[k][i][j] = Integer.parseInt(s[j - 1]);
        }

      }

    }

    for (int k = 1; k <= h; k++) {
      for (int i = 1; i <= m; i++) {

        for (int j = 1; j <= n; j++) {
          dist[k][i][j] = -1;

          if (a[k][i][j] == 1) {
            q.add(new Pair(j, i, k));
            dist[k][i][j] = 0;
          }
        }

      }
    }

    bfs(q, a, c, dist);

    for (int k = 1; k <= h; k++) {
      for (int i = 1; i <= m; i++) {

        for (int j = 1; j <= n; j++) {
          if (dist[k][i][j] == -1 && a[k][i][j] == 0) {
            System.out.println(-1);
            return;
          }

          if (ans < dist[k][i][j]) {
            ans = dist[k][i][j];
          }
        }
      }
    }

    System.out.println(ans);
  }

  public static void bfs(Queue<Pair> q, int[][][] a, boolean[][][] c, int[][][] dist) {

    while (!q.isEmpty()) {
      int x = q.peek().x;
      int y = q.peek().y;
      int z = q.peek().z;
      q.poll();

      for (int k = 0; k < 6; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];
        int nz = z + dz[k];

        if (0 < nx && nx <= n && 0 < ny && ny <= m && nz > 0 && nz <= h) {
          if (a[nz][ny][nx] == 0 && dist[nz][ny][nx] == -1) {
            q.add(new Pair(nx, ny, nz));

            dist[nz][ny][nx] = dist[z][y][x] + 1;

          }
        }
      }

    }

  }

  public static void main(String[] args) {
    sc.init();

    new Main().solve();
  }

  static class Pair {
    int x;
    int y;
    int z;

    Pair(int x, int y, int h) {
      this.x = x;
      this.y = y;
      this.z = h;
    }
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