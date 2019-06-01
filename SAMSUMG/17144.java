import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://mygumi.tistory.com/351
public class Main {
  // 위, 아래, 오른쪽, 왼쪽
  static int[] dx = { 0, 0, 1, -1 };
  static int[] dy = { -1, 1, 0, 0 };
  static int[] ccw = { 2, 0, 3, 1 };
  static int[] cw = { 2, 1, 3, 0 };
  static int[][] map, copyMap;
  static int R, C, T, sum;

  static ArrayList<Point> cleaner = new ArrayList<Point>();

  private void solve() {
    R = sc.nextInt();
    C = sc.nextInt();
    T = sc.nextInt();
    map = new int[R][C];
    copyMap = new int[R][C];

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        map[i][j] = sc.nextInt();
        if (map[i][j] == -1) {
          cleaner.add(new Point(j, i));
        }
      }
    }

    for (int i = 0; i < T; i++) {
      spread();
      for (int ii = 0; ii < R; ii++) {
        for (int j = 0; j < C; j++) {
          copyMap[ii][j] = map[ii][j];
        }
      }
      circulate(cleaner.get(0).x, cleaner.get(0).y, ccw);
      circulate(cleaner.get(1).x, cleaner.get(1).y, cw);
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (map[i][j] > 0) {
          sum += map[i][j];
        }
      }
    }
    System.out.println(sum);
  }

  void spread() {
    Queue<Dust> q = new LinkedList<Dust>();

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (map[i][j] > 4) {
          q.add(new Dust(i, j, map[i][j]));
        }
      }
    }

    while (!q.isEmpty()) {
      Dust dust = q.poll();
      int give = dust.n / 5;
      int cnt = 0;

      for (int k = 0; k < 4; k++) {
        int nx = dust.c + dx[k];
        int ny = dust.r + dy[k];

        if (0 <= nx && nx < C && 0 <= ny && ny < R) {
          if (map[ny][nx] != -1) {
            // 현재 위치에 공기청정기가 없을 경우
            cnt++;
            map[ny][nx] += give;
          }
        }
      }
      map[dust.r][dust.c] -= give * cnt;
    }
  };

  void circulate(int cleanerX, int cleanerY, int[] direction) {
    int y = cleanerY;
    int x = cleanerX + 1;
    map[y][x] = 0;
    for (int k = 0; k < 4; k++) {
      while (true) {
        int nx = x + dx[direction[k]];
        int ny = y + dy[direction[k]];

        if (!(0 <= ny && ny < R && 0 <= nx && nx < C)) {
          break;
        }

        if (cleanerY == ny && cleanerX == nx) {
          break;
        }

        map[ny][nx] = copyMap[y][x];
        y = ny;
        x = nx;
      }
    }
  };

  class Dust {
    int r;
    int c;
    int n;

    Dust(int r, int c, int n) {
      this.r = r;
      this.c = c;
      this.n = n;
    }
  }

  class Point {
    int x;
    int y;

    Point(int x, int y) {
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
