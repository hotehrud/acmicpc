import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  // https://github.com/hotehrud/acmicpc
  // http://mygumi.tistory.com/
  private void solve() {
    int c = sc.nextInt();
    int r = sc.nextInt();
    char[][] map = new char[c][r];
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, -1, 0, 1 };
    int ans = 0;

    for (int i = 0; i < c; i++) {
      map[i] = sc.readLine().toCharArray();
    }

    for (int i = 0; i < c; i++) {
      for (int j = 0; j < r; j++) {
        Queue<Point> q = new LinkedList<Point>();
        boolean[][] visited = new boolean[c][r];
        int[][] dist = new int[c][r];
        char ch = map[i][j];
        visited[i][j] = true;
        q.add(new Point(i, j));
        int temp = 0;

        while (!q.isEmpty()) {
          Point p = q.poll();
          int x = p.x;
          int y = p.y;

          for (int k = 0; k < 4; k++) {
            int nx = dx[k] + x;
            int ny = dy[k] + y;

            if (0 <= nx && nx < r && 0 <= ny && ny < c) {
              if (!visited[ny][nx] && map[ny][nx] == ch) {
                q.add(new Point(ny, nx));
                dist[ny][nx] = dist[y][x] + 1;
                visited[ny][nx] = true;

                if (temp < dist[ny][nx]) {
                  temp = dist[ny][nx];
                }
              }
            }
          }
        }
        if (ans < temp) {
          ans = temp;
        }
      }
    }
    System.out.println(ans);
  }

  public static class Point {
    int x;
    int y;

    Point(int y, int x) {
      this.x = x;
      this.y = y;
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