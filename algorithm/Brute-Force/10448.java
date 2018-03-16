import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  // http://mygumi.tistory.com/
  // https://github.com/hotehrud/acmicpc

  static int max = 44;
  static int[] triangular = new int[max + 1];
  static boolean isFind;

  private void solve() {
    // 브루트 포스
    int t = sc.nextInt();
    for (int i = 1; i <= max; i++) {
      triangular[i] = (i * (i + 1)) / 2;
    }

    while (t-- > 0) {
      int n = sc.nextInt();
      isFind = false;
      find(1, n, 0, 0);
      if (isFind) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }
  }

  public static void find(int t, int target, int sum, int cnt) {
    if (isFind || sum > target) {
      return;
    }

    if (cnt >= 3) {
      if (target == sum) {
        isFind = true;
      }
      return;
    }

    // 삼각수가 중복되어도 상관없기 때문에 t부터 반복문 실행
    for (int v = t; v <= max; v++) {
      if (!isFind && sum + triangular[v] <= target) {
        find(v, target, sum + triangular[v], cnt + 1);
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