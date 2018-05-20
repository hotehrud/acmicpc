import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private void solve() {
    StringBuilder sb = new StringBuilder();

    int n = sc.nextInt();
    int m = sc.nextInt();
    int max = 100001;

    // 플로이드 와샬 알고리즘
    // 제일 바깥쪽 반복문은 거쳐가는 꼭짓점이고, 두 번째 반복문은 출발하는 꼭짓점, 세 번째 반복문은 도착하는 꼭짓점이다
    // k - 거쳐가는 꼭지점, i - 출발 꼭지점, j - 도착 꼭지점

    int[][] dist = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {

      for (int j = 1; j <= n; j++) {

        dist[i][j] = (i == j) ? 0 : max;

      }

    }

    for (int i = 1; i <= m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      dist[a][b] = Math.min(dist[a][b], c);
    }

    for (int k = 1; k <= n; k++) {

      for (int i = 1; i <= n; i++) {

        for (int j = 1; j <= n; j++) {

          if (dist[i][j] > dist[i][k] + dist[k][j]) {
            dist[i][j] = dist[i][k] + dist[k][j];
          }

        }

      }

    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (dist[i][j] == max) {
          sb.append("0 ");  
        } else {
          sb.append(dist[i][j] + " ");
        }
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());
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