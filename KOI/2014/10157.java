import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  // https://github.com/hotehrud/acmicpc
  // http://mygumi.tistory.com/
  private void solve() {
    int c = sc.nextInt();
    int r = sc.nextInt();
    int target = sc.nextInt();
    int[][] array = new int[c + 1][r + 1];
    int x = 0, y = 1;
    int n = 0;

    if (target > c * r) {
      System.out.println(0);
      return;
    }

    // 45deg right rotate
    // 오른 아래 왼 위
    while (true) {
      // right
      for (x = x + 1; x <= r; x++) {
        if (array[y][x] != 0)
          break;
        array[y][x] = ++n;
        if (n == target) {
          System.out.println(y + " " + x);
          return;
        }
      }
      x--;
      // down
      for (y = y + 1; y <= c; y++) {
        if (array[y][x] != 0)
          break;
        array[y][x] = ++n;
        if (n == target) {
          System.out.println(y + " " + x);
          return;
        }
      }
      y--;
      // left
      for (x = x - 1; x > 0; x--) {
        if (array[y][x] != 0)
          break;
        array[y][x] = ++n;
        if (n == target) {
          System.out.println(y + " " + x);
          return;
        }
      }
      x++;
      // up
      for (y = y - 1; y > 0; y--) {
        if (array[y][x] != 0)
          break;
        array[y][x] = ++n;
        if (n == target) {
          System.out.println(y + " " + x);
          return;
        }
      }
      y++;
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