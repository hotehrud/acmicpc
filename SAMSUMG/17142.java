import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://mygumi.tistory.com/352
public class Main {
  // 위, 아래, 오른쪽, 왼쪽
  static int[] dx = { 0, 0, 1, -1 };
  static int[] dy = { -1, 1, 0, 0 };
  static int[][] map;
  static ArrayList<Integer> virus, allowed;
  static int N, M, min = Integer.MAX_VALUE;

  private void solve() {
    N = sc.nextInt();
    M = sc.nextInt();

    map = new int[N][N];
    allowed = new ArrayList<Integer>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int input = sc.nextInt();
        if (input == 2) {
          allowed.add(i * N + j);
        }
        map[i][j] = input;
      }
    }

    for (int i = 0; i < allowed.size(); i++) {
      virus = new ArrayList<Integer>();
      virus.add(allowed.get(i));
      find_case_dfs(i, 1, M);
    }
    if (min == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(min);
    }
  }

  void find_case_dfs(int v, int cnt, int limit) {
    if (cnt == limit) {
      int result = spread_bfs();
      if (result >= 0 && min > result) {
        min = result;
      }
    } else {
      int size = allowed.size();
      for (int i = v + 1; i < size; i++) {
        int vv = allowed.get(i);
        int y = vv / N;
        int x = vv % N;
        if (map[y][x] == 2) {
          virus.add(vv);
          find_case_dfs(i, cnt + 1, limit);
        }
      }
    }
    // backtracking
    virus.remove(virus.size() - 1);
  }

  int spread_bfs() {
    Queue<Integer> q = new LinkedList<Integer>();
    int[][] copyMap = new int[N][N];
    boolean[][] visited = new boolean[N][N];
    int time = 0;
    int temp = 0;
    q.addAll(virus);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        copyMap[i][j] = map[i][j];
      }
    }

    while (!q.isEmpty()) {
      boolean blank = false;
      int size = q.size();
      for (int i = 0; i < size; i++) {
        // 초마다 바이러스 확산
        int point = q.poll();
        int y = point / N;
        int x = point % N;
        visited[y][x] = true;

        for (int k = 0; k < 4; k++) {
          int nextX = x + dx[k];
          int nextY = y + dy[k];

          if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
            if (!visited[nextY][nextX]) {
              visited[nextY][nextX] = true;
              if (copyMap[nextY][nextX] == 0) {
                blank = true;
                copyMap[nextY][nextX] = 3;
                q.add(nextY * N + nextX);
              }
              if (copyMap[nextY][nextX] == 2) {
                q.add(nextY * N + nextX);
              }
            }
          }
        }
      }

      // 인접된 곳에 빈칸이 없고 비활성화 바이러스 칸이 존재할 수 있다.
      // 우선 임시 초를 증가시키다가 빈칸이 존재한다면, 임시 초를 합친다.
      if (!blank) {
        temp++;
      } else {
        time += ++temp;
        temp = 0;
      }
    }

    if (!check(copyMap)) {
      return -1;
    }

    return time;
  }

  boolean check(int[][] map) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
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
