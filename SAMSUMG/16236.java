import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  // http://mygumi.tistory.com/339
  static boolean[] visited = new boolean[400];
  static int[][] map = new int[20][20];
  static ArrayList<Item> fishes = new ArrayList<Item>();
  static int[] dx = { -1, 0, 1, 0 };
  static int[] dy = { 0, -1, 0, 1 };
  static int N, cnt, targetX, targetY, targetSize = 2, time = 0;

  private void solve() {
    N = sc.nextInt();

    for (int i = 0; i < N; i++) {
      String[] c = sc.readLine().split(" ");
      int size = c.length;

      for (int j = 0; j < size; j++) {
        map[i][j] = Integer.parseInt(c[j]);
        if (map[i][j] == 9) {
          targetX = j;
          targetY = i;
        }
      }
    }

    while (true) {
      Queue<Item> q = new LinkedList<Item>();
      ArrayList<Item> fishes = new ArrayList<Item>();
      visited = new boolean[400];

      q.add(new Item(targetX, targetY, 0));
      visited[targetY * N + targetX] = true;

      int found = -1;
      while (!q.isEmpty()) {
        Item item = q.poll();
        int r = item.n / N;
        int c = item.n % N;
        int move = item.move;
        if (found == move) {
          break;
        }

        for (int k = 0; k < 4; k++) {
          int nx = c + dx[k];
          int ny = r + dy[k];
          int next = ny * N + nx;

          if (0 <= nx && nx < N && 0 <= ny && ny < N) {
            if (visited[next]) {
              continue;
            }
            visited[next] = true;
            if (targetSize >= map[ny][nx]) {
              if (map[ny][nx] > 0 && targetSize > map[ny][nx]) {
                // 물고기를 먹을 수 있는 곳을 찾음. 현재 이동거리까지만 BFS 탐색하고 중단.
                found = move + 1;
                fishes.add(new Item(nx, ny, move + 1));
              }
              q.add(new Item(nx, ny, move + 1));
            }
          }
        }
      }

      // 큐에 남은 것들은 먹을 수 있는 거리에 있는 영역들(크기가 동일하거나 작은 물고기 존재)
      // 먹을 물고기 있다면, 상어 위치 이동 후, 다시 시작.
      if (found == -1) {
        break;
      } else {
        if (fishes.size() > 1) {
          Collections.sort(fishes, new ySort());
        }
      }

      Item fish = fishes.get(0);
      if (found != -1) {
        time += found;
        map[targetY][targetX] = 0;
        targetX = fish.x;
        targetY = fish.y;
        map[targetY][targetX] = 9;
        if (targetSize == ++cnt) {
          targetSize++;
          cnt = 0;
        }
      }

    }
    System.out.println(time);
  }

  static class ySort implements Comparator<Item> {
    public int compare(Item i1, Item i2) {
      if (i1.y < i2.y) {
        return -1;
      } else if (i1.y == i2.y) {
        if (i1.x < i2.x) {
          return -1;
        } else if (i1.x == i2.x) {
          return 0;
        }
        return 1;
      } else {
        return 1;
      }
    }
  }

  static class Item {
    int x;
    int y;
    int n;
    int move;

    Item(int x, int y, int move) {
      this.x = x;
      this.y = y;
      this.n = this.y * N + this.x;
      this.move = move;
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
