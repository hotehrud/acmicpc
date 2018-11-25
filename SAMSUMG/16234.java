import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  // http://mygumi.tistory.com/338
  static boolean[] visited = new boolean[10001];
  static int[][] map = new int[51][51];
  static ArrayList<Integer> track = new ArrayList<Integer>();
  static int[] dx = { -1, 0, 1, 0 };
  static int[] dy = { 0, -1, 0, 1 };
  static int N, L, R, ans;

  private void solve() {
    N = sc.nextInt();
    L = sc.nextInt();
    R = sc.nextInt();

    for (int i = 0; i < N; i++) {
      String[] c = sc.readLine().split(" ");
      int size = c.length;

      for (int j = 0; j < size; j++) {
        map[i][j] = Integer.parseInt(c[j]);
      }
    }

    boolean flag = true;
    while (flag) {
      Queue<Integer> q = new LinkedList<Integer>();
      visited = new boolean[10001];
      flag = false;
      ans++;
      // ?번째 인구 이동 탐색
      for (int i = 0; i < N * N; i++) {
        if (visited[i]) {
          continue;
        }
        track = new ArrayList<Integer>();

        int r = i / N;
        int c = i % N;
        q.add(i);
        visited[i] = true;
        track.add(i);
        int total = map[r][c];
        int n = 1;

        while (!q.isEmpty()) {
          int v = q.poll();
          r = v / N;
          c = v % N;

          for (int k = 0; k < 4; k++) {
            int nx = c + dx[k];
            int ny = r + dy[k];

            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
              int next = ny * N + nx;

              if (visited[next]) {
                continue;
              }

              int count = map[ny][nx];
              int pivot = map[r][c];
              if (L <= Math.abs(count - pivot) && Math.abs(count - pivot) <= R) {
                // 연합국 조건 성립
                flag = true;
                q.add(next);
                visited[next] = true;
                track.add(next);
                total += map[ny][nx];
                n++;
              }
            }

          }
        }
        // 연합국 인구 수 업데이트
        int updateN = total / n;
        if (track.size() > 1) {
          for (int v : track) {
            r = v / N;
            c = v % N;
            map[r][c] = updateN;
          }
        }

      }
    }
    System.out.println(ans - 1);

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
