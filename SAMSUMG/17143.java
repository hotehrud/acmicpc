import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://mygumi.tistory.com/350
public class Main {
  // 위, 아래, 오른쪽, 왼쪽
  static int[] dx = { 0, 0, 1, -1 };
  static int[] dy = { -1, 1, 0, 0 };
  static ArrayList<Shark> sharks = new ArrayList<Shark>();
  static Shark[][] map;
  static int R, C, M, sum;

  private void solve() {
    R = sc.nextInt();
    C = sc.nextInt();
    M = sc.nextInt();
    map = new Shark[R + 1][C + 1];

    for (int i = 1; i <= M; i++) {
      String[] input = sc.readLine().split(" ");
      int r = Integer.parseInt(input[0]);
      int c = Integer.parseInt(input[1]);
      int s = Integer.parseInt(input[2]);
      int d = Integer.parseInt(input[3]);
      int z = Integer.parseInt(input[4]);
      Shark shark = new Shark(r, c, s, d, z);
      map[r][c] = shark;
      sharks.add(shark);
    }

    for (int i = 1; i <= C; i++) {
      catchShark(i);
      moveShark();
      survive();
    }
    System.out.println(sum);
  }

  void catchShark(int row) {
    Shark target = null;
    for (int i = 1; i <= R; i++) {
      if (map[i][row] != null) {
        target = map[i][row];
        break;
      }
    }
    if (target != null) {
      map[target.r][target.c] = null;
      sum += target.size;
      sharks.remove(target);
    }
  };

  void moveShark() {
    for (Shark shark : sharks) {
      int end = C;
      if (shark.direction < 3) {
        end = R;
      }
      shark.updatePoistion(end);
    }
  };

  int survive() {
    map = new Shark[R + 1][C + 1];
    int size = sharks.size();
    for (int i = size - 1; i >= 0; i--) {
      Shark shark = sharks.get(i);
      if (map[shark.r][shark.c] == null) {
        map[shark.r][shark.c] = shark;
      } else {
        if (map[shark.r][shark.c].size > shark.size) {
          sharks.remove(shark);
        } else {
          sharks.remove(map[shark.r][shark.c]);
          map[shark.r][shark.c] = shark;
        }
      }
    }
    return 0;
  };

  static class Shark {
    int r;
    int c;
    int direction;
    int size;
    int speed;

    Shark(int r, int c, int s, int d, int z) {
      this.r = r;
      this.c = c;
      this.speed = s;
      this.direction = d;
      this.size = z;
    }

    void updatePoistion(int end) {
      int goback = 2 * (end - 1);
      int speed = this.speed % goback;

      for (int i = 0; i < speed; i++) {
        if (this.direction < 3) {
          // 위, 아래
          if ((this.r == end && this.direction == 2) || (this.r == 1 && this.direction == 1)) {
            this.changeDirection();
          }
          this.r += dy[this.direction - 1];
        } else {
          if ((this.c == end && this.direction == 3) || (this.c == 1 && this.direction == 4)) {
            this.changeDirection();
          }
          this.c += dx[this.direction - 1];
        }
      }
    }

    void changeDirection() {
      int next = this.direction + 1;
      if (next % 2 == 0) {
        this.direction = next;
      } else {
        this.direction = next - 2;
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
