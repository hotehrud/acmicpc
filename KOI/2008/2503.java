import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  // https://github.com/hotehrud/acmicpc
  // http://mygumi.tistory.com/

  private void solve() {
    ArrayList<Game> list = new ArrayList<Game>();
    int ans = 0;
    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      list.add(new Game(sc.next(), sc.nextInt(), sc.nextInt()));
    }

    for (int k = 102; k <= 987; k++) {
      boolean flag = true;

      for (int i = 0; i < n; i++) {
        Game game = list.get(i);
        String v = game.v;
        int s = game.s;
        int b = game.b;

        if (!check(v, k, s, b)) {
          flag = false;
          break;
        }

      }

      if (flag) {
        ++ans;
      }

    }
    System.out.println(ans);
  }

  public static boolean check(String str1, int n, int s, int b) {
    int sn = 0;
    int bn = 0;

    char[] array1 = str1.toCharArray();
    char[] array2 = String.valueOf(n).toCharArray();

    boolean[] visited = new boolean[10];
    for (int i = 0; i < 3; i++) {
      if (array2[i] == '0') {
        return false;
      }
      if (visited[array2[i] - '0']) {
        return false;
      }
      visited[array2[i] - '0'] = true;
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == j) {
          if (array1[i] == array2[j]) {
            ++sn;
          }
        } else {
          if (array1[i] == array2[j]) {
            ++bn;
          }
        }
      }
    }

    if (sn == s && bn == b) {
      return true;
    }

    return false;
  }

  public class Game {
    String v;
    int s;
    int b;

    Game(String v, int s, int b) {
      this.v = v;
      this.s = s;
      this.b = b;
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