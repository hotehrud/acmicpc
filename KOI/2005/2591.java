import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // https://github.com/hotehrud/acmicpc
  // http://mygumi.tistory.com/291
  private void solve() {
    // dp[N][L] - L자리 수면서 N번째 수까지의 가능한 배열 갯수 L => 일의 자리, 십의 자리
    // 카드로 표현할 수 있는 수는 일의 자리와 십의 자리 밖에 존재하지 않음.
    char[] array = sc.readLine().toCharArray();
    int len = array.length;
    int[][] dp = new int[41][3];
    int prev = (array[0] - '0') * 10;
    dp[1][1] = 1;

    for (int i = 2; i <= len; i++) {
      int v = array[i - 1] - '0';
      if (v == 0) {
        if (prev + v <= 34) {
          dp[i][2] = dp[i - 1][1];  
        }
        continue;
      }
      
      if (prev + v <= 34) {
        dp[i][1] = dp[i - 1][2] + dp[i - 1][1];
        dp[i][2] = dp[i - 1][1];
      } else {
        // 34보다 큰 수라면 십의 자리가 될 수 없다.
        dp[i][1] = dp[i - 1][1] + dp[i - 1][2];
      }
      prev = v * 10;
    }
    System.out.println(dp[len][1] + dp[len][2]);
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