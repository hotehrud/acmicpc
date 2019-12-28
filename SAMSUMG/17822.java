import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  // https://mygumi.tistory.com/365
  static int[][] map = new int[50][50];
  static int[] dx = { -1, 0, 1, 0 };
  static int[] dy = { 0, -1, 0, 1 };
  static Queue<Point> q = new LinkedList<>();
  static int n, m, t;

  static class Point {
    int x;
    int y;
    int v;

    Point(int y, int x, int v) {
      this.x = x;
      this.y = y;
      this.v = v;
    }
  }

  private void solve() {
    n = sc.nextInt();
    m = sc.nextInt();
    t = sc.nextInt();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int value = sc.nextInt();
        map[i][j] = value;
      }
    }

    for (int i = 0; i < t; i++) {
      int x = sc.nextInt();
      int direction = sc.nextInt();
      int count = sc.nextInt() % m;

      rotate(x, count, direction);
      double psum = 0;
      int cnt = 0;
      for (int ii = 0; ii < n; ii++) {
        for (int jj = 0; jj < m; jj++) {
          if (map[ii][jj] > 0) {
            q.add(new Point(ii, jj, map[ii][jj]));
            psum += map[ii][jj];
            cnt++;
          }
        }
      }
      if (!bfs()) {
        // 인접한 것들이 같은 수가 아닐 때
        psum = psum * 1.0 / cnt;
        update(psum);
      }
    }
    int sum = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sum += map[i][j];
      }
    }
    System.out.println(sum);
  }

  public static boolean bfs() {
    int size = q.size();
    boolean flag = false;
    for (int i = 0; i < size; i++) {
      Point p = q.poll();
      for (int j = 0; j < 4; j++) {
        int nx = dx[j] + p.x;
        int ny = dy[j] + p.y;

        if (j == 0 && p.x == 0) {
          nx = m - 1;
        }

        if (j == 2 && p.x == m - 1) {
          nx = 0;
        }

        if (0 <= nx && nx < m && 0 <= ny && ny < n) {
          if (map[ny][nx] == p.v) {
            flag = true;
            map[p.y][p.x] = 0;
            map[ny][nx] = 0;
          }
        }
      }
    }
    return flag;
  }

  public static void rotate(int x, int count, int direction) {
    // 원판 돌리기
    for (int i = x; i <= n; i += x) {
      int n = i - 1;
      if (direction == 1) {
        int[] a = Arrays.copyOfRange(map[n], 0, count);
        int[] b = Arrays.copyOfRange(map[n], count, m);

        System.arraycopy(b, 0, map[n], 0, b.length);
        System.arraycopy(a, 0, map[n], b.length, a.length);
      } else {
        int[] a = Arrays.copyOfRange(map[n], 0, m - count);
        int[] b = Arrays.copyOfRange(map[n], m - count, m);

        System.arraycopy(b, 0, map[n], 0, b.length);
        System.arraycopy(a, 0, map[n], b.length, a.length);
      }
    }
  }

  public static void update(double sum) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] > 0) {
          if (map[i][j] > sum) {
            map[i][j] -= 1;
          } else if (map[i][j] < sum) {
            map[i][j] += 1;
          }
        }
      }
    }
  }

  public static void print() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(map[i][j]);
      }
      System.out.println();
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