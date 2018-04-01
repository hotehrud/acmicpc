import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  // http://mygumi.tistory.com/306
  // https://github.com/hotehrud/acmicpc

  static LinkedList<Integer>[] list = (LinkedList<Integer>[]) new LinkedList[5];

  private void solve() {
    for (int i = 1; i <= 4; i++) {
      list[i] = new LinkedList<Integer>();
      String input = sc.readLine();
      for (String s : input.split("")) {
        int n = Integer.parseInt(s);
        list[i].add(n);
      }
    }

    int k = sc.nextInt();
    while (k-- > 0) {
      int n = sc.nextInt();
      int d = sc.nextInt();

      left(n - 1, -d);
      right(n + 1, -d);
      rotate(n, d);
    }

    int ans = 0;
    for (int i = 0; i < 4; i++) {
      if (list[i + 1].get(0) == 1) {
        ans += (int) Math.pow(2, i);
      }
    }
    System.out.println(ans);
  }

  public static boolean check(int a, int b) {
    if (a > b) {
      // left
      if (list[a].get(6) == list[b].get(2)) {
        return false;
      } else {
        return true;
      }
    } else {
      if (list[a].get(2) == list[b].get(6)) {
        return false;
      } else {
        return true;
      }
    }
  }

  public static void rotate(int n, int direction) {
    if (direction == 1) {
      list[n].addFirst(list[n].pollLast());
    } else {
      list[n].addLast(list[n].pollFirst());
    }
  }

  public static void left(int n, int direction) {
    if (!(1 <= n && n <= 4))
      return;

    if (check(n, n + 1)) {
      left(n - 1, -direction);
      rotate(n, direction);
    }
  }

  public static void right(int n, int direction) {
    if (!(1 <= n && n <= 4))
      return;

    if (check(n, n - 1)) {
      right(n + 1, -direction);
      rotate(n, direction);
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