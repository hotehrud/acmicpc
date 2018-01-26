import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  // https://github.com/hotehrud/acmicpc
  // http://mygumi.tistory.com/

  private void solve() {
    int r = sc.nextInt();
    int c = sc.nextInt();
    int n = sc.nextInt();
    ArrayList<Point> list = new ArrayList<Point>();

    for (int i = 0; i < n; i++) {
      int dir = sc.nextInt();
      int dis = sc.nextInt();
      Point p = new Point(dir, dis, c, r);
      list.add(p);
    }

    int d = sc.nextInt();
    int v = sc.nextInt();
    Point dong = new Point(d, v, c, r);
    int temp = 0;
    int ans = 0;

    if (d == 1) {
      temp = 2;
    } else if (d == 2) {
      temp = 1;
    } else if (d == 3) {
      temp = 4;
    } else {
      temp = 3;
    }

    for(Point p : list) {
      if (p.direction == temp) {
				if (p.direction == 1 || p.direction == 2) {
					ans += Math.min(dong.y + p.y + dong.x + p.x, dong.y + p.y + r - dong.x + r - p.x);
				} else {
					ans += Math.min(c - dong.y + c - p.y + dong.x + p.x, dong.y + p.y + dong.x + p.x);
				}
      } else {
        ans += Math.abs(dong.y - p.y) + Math.abs(dong.x - p.x);
      }
    }
    System.out.println(ans);
  }

  static class Point {
    int direction;
    int y;
    int x;

    Point(int direction, int distance, int c, int r) {
      this.direction = direction;

      if (direction == 1) {
        this.y = 0;
        this.x = distance;
      } else if (direction == 2) {
        this.y = c;
        this.x = distance;
      } else if (direction == 3) {
        this.y = distance;
        this.x = 0;
      } else {
        this.y = distance;
        this.x = r;
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