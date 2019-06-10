import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  private void solve() {
    int n = sc.nextInt();
    ArrayList<Item> list = new ArrayList<Item>();
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      list.add(new Item(i, sc.nextInt()));
    }
    int kill = 0;
    for (int i = 0; i < n; i++) {
      Item item = list.remove(kill);
      int len = list.size();
      int seq = item.seq;
      int move = item.n;
      sb.append(seq + " ");

      if (kill == len) {
        // 3 2 1 1 1
        kill = 0;
      }

      if (move > 0) {
        for (int k = 0; k < move - 1; k++) {
          kill++;
          if (kill >= len) {
            kill = 0;
          }
        }
      } else {
        for (int k = 0; k < (int) Math.abs(move); k++) {
          kill--;
          if (kill < 0) {
            kill = len - 1;
          }
        }
      }

    }
    System.out.println(sb.toString());
  }

  class Item {
    int seq;
    int n;

    Item(int seq, int n) {
      this.seq = seq;
      this.n = n;
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
