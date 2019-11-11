import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static char[][] map;
  static int r, c;
  static int[] dx = { -1, 0, 1, 0 };
  static int[] dy = { 0, -1, 0, 1 };
  static Queue<Point> water = new LinkedList<>();
  static Queue<Point> hedgehog = new LinkedList<>();

  private void solve() {
    // http://mygumi.tistory.com/232
    r = sc.nextInt();
    c = sc.nextInt();
    map = new char[r][c];

    for (int i = 0; i < r; i++) {
      char[] input = sc.next().toCharArray();
      for (int j = 0; j < c; j++) {
        map[i][j] = input[j];

        if (input[j] == '*') {
          water.add(new Point(i, j));
        }

        if (input[j] == 'S') {
          hedgehog.add(new Point(i, j));
        }
      }
    }

    int ans = 0;
    while (true) {
      ++ans;
      if (hedgehog.size() == 0) {
        System.out.println("KAKTUS");
        return;
      }

      extendWater();
      if (extendHedgehog()) {
        System.out.println(ans);
        return;
      }
    }
  }

  public static void extendWater() {
    int size = water.size();

    for (int i = 0; i < size; i++) {
      Point p = water.poll();

      for (int j = 0; j < 4; j++) {
        int nx = dx[j] + p.x;
        int ny = dy[j] + p.y;

        if (0 <= nx && nx < c && 0 <= ny && ny < r) {
          if (map[ny][nx] == '.') {
            map[ny][nx] = '*';
            water.add(new Point(ny, nx));
          }
        }
      }
    }
  }

  public static boolean extendHedgehog() {
    int size = hedgehog.size();

    for (int i = 0; i < size; i++) {
      Point p = hedgehog.poll();

      for (int j = 0; j < 4; j++) {
        int nx = dx[j] + p.x;
        int ny = dy[j] + p.y;

        if (0 <= nx && nx < c && 0 <= ny && ny < r) {
          if (map[ny][nx] == 'D') {
            hedgehog.add(new Point(ny, nx));
            return true;
          }
          if (map[ny][nx] == '.') {
            map[ny][nx] = 'S';
            hedgehog.add(new Point(ny, nx));
          }
        }
      }
    }
    return false;
  }

  static class Point {
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
