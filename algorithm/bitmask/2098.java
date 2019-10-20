import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://mygumi.tistory.com/361
public class Main {
  static int[][] map = new int[16][16];
  static int[][] dp = new int[16][1 << 16];
  static int n, visited;
  static int INF = Integer.MAX_VALUE - 1000000;

  private void solve() {
    n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        map[i][j] = sc.nextInt();
      }
    }

    System.out.println(tsp(0, 1));
  }

  int tsp(int current, int visited) {
    // 모두 방문
    if ((visited == (1 << n) - 1)) {
      // 마지막 도시에서 0번 도시로 돌아갈 수 없을 경우.
      if (map[current][0] == 0) {
        return INF;
      }
      return map[current][0];
    }
    // 이미 방문한 적이 있다
    if (dp[current][visited] != 0) {
      return dp[current][visited];
    }

    dp[current][visited] = INF;
    for (int k = 0; k < n; k++) {
      int next = 1 << k;
      if (map[current][k] == 0 || (visited & next) > 0) {
        // 갈 수 없거나, 방문했다면 건너뜀.
        continue;
      }
      // 현재 도시(current)에서 방문한 도시들(visited) 일때 도시 전체를 순회한 최소 비용.
      dp[current][visited] = Math.min(dp[current][visited], tsp(k, visited | next) + map[current][k]);
    }
    return dp[current][visited];
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