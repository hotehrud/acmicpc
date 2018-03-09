import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  // 브루트 포스
  // http://mygumi.tistory.com/

  private void solve() {
    int s1 = sc.nextInt();
    int s2 = sc.nextInt();
    int s3 = sc.nextInt();
    int sum = s1 + s2 + s3;
    int[] array = new int[sum + 1];
    int max = 0;
    int ans = 0;

    for (int i = 1; i <= s1; i++) {
      for (int j = 1; j <= s2; j++) {
        for (int k = 1; k <= s3; k++) {
          ++array[i + j + k];
        }
      }
    }

    for (int i = 3; i <= sum; i++) {
      // 여러개일 경우 가장 작은 합은 >= 이 아닌 > 로 했기 때문에 적용됨.
      if (array[i] > max) {
        max = array[i];
        ans = i;
      }
    }
    System.out.println(ans);
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