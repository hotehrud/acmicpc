import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://mygumi.tistory.com/353
public class Main {
  static int r, c, k, time;
  static int rn = 3, cn = 3;
  static int[][] input = new int[201][201];
  static int[] cnt;

  private void solve() {
    r = sc.nextInt();
    c = sc.nextInt();
    k = sc.nextInt();

    for (int i = 1; i <= 3; i++) {
      for (int j = 1; j <= 3; j++) {
        input[i][j] = sc.nextInt();
      }
    }

    while (input[r][c] != k) {
      if (rn >= cn) {
        cn = row();
      } else {
        rn = column();
      }
      time++;

      if (time > 100) {
        time = -1;
        break;
      }
    }
    System.out.println(time);
  }

  PriorityQueue<Item> sort() {
    PriorityQueue<Item> q = new PriorityQueue<Item>(new ComparatorSort());
    for (int i = 1; i <= 100; i++) {
      if (cnt[i] > 0) {
        q.add(new Item(i, cnt[i]));
      }
    }
    return q;
  }

  int row() {
    int c = 2;
    for (int i = 1; i <= rn; i++) {
      cnt = new int[101];
      for (int j = 1; j <= cn; j++) {
        cnt[input[i][j]]++;
      }
      PriorityQueue<Item> q = sort();
      int k = 1;
      while (!q.isEmpty()) {
        Item item = q.poll();
        input[i][k] = item.n;
        input[i][k + 1] = item.cnt;
        k += 2;
        if (k > 100) {
          break;
        }
      }
      for (int j = k; j < 201; j++) {
        input[i][j] = 0;
      }
      if (c < k - 1) {
        c = k - 1;
      }
    }
    return c;
  }

  int column() {
    int c = 2;
    for (int i = 1; i <= cn; i++) {
      cnt = new int[101];
      for (int j = 1; j <= rn; j++) {
        cnt[input[j][i]]++;
      }
      PriorityQueue<Item> q = sort();
      int k = 1;
      while (!q.isEmpty()) {
        Item item = q.poll();
        input[k][i] = item.n;
        input[k + 1][i] = item.cnt;
        k += 2;
        if (k > 100) {
          break;
        }
      }
      for (int j = k; j < 201; j++) {
        input[j][i] = 0;
      }
      if (c < k - 1) {
        c = k - 1;
      }
    }
    return c;
  }

  class Item {
    int n;
    int cnt;

    Item(int n, int cnt) {
      this.n = n;
      this.cnt = cnt;
    }
  }

  class ComparatorSort implements Comparator<Item> {
    public int compare(Item i1, Item i2) {
      if (i1.cnt < i2.cnt) {
        return -1;
      } else if (i1.cnt == i2.cnt) {
        if (i1.n < i2.n) {
          return -1;
        } else {
          return 1;
        }
      } else {
        return 1;
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
