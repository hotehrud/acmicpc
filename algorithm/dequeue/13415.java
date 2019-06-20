import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
  // https://mygumi.tistory.com/354
  private void solve() {
    Deque<Item> deque = new ArrayDeque<Item>();
    int n = sc.nextInt();
    int k = 0;
    int maxIndex = 0;
    int[] array = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      array[i] = sc.nextInt();
    }

    k = sc.nextInt();

    for (int i = 0; i < k; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      while (!deque.isEmpty() && deque.getLast().value <= a) {
        deque.removeLast();
      }
      if (a != 1) {
        deque.addLast(new Item(a, 1));
      }
      while (!deque.isEmpty() && deque.getLast().value <= b) {
        deque.removeLast();
      }
      if (b != 1) {
        deque.addLast(new Item(b, -1));
      }
    }

    deque.addLast(new Item(0, 1));

    int[] result = new int[n + 1];
    Item item = deque.removeFirst();
    int end = maxIndex = item.value;
    int order = item.order;
    int ascIndex = end;
    int descIndex = 1;

    Arrays.sort(array, 1, maxIndex + 1);
    while (!deque.isEmpty()) {
      item = deque.removeFirst();
      int start = item.value;

      if (order == 1) {
        for (int i = end; i > start; i--) {
          result[i] = array[ascIndex--];
        }
      } else {
        for (int i = end; i > start; i--) {
          result[i] = array[descIndex++];
        }
      }
      order = item.order;
      end = item.value;
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 1; i <= maxIndex; i++) {
      sb.append(result[i] + " ");
    }

    for (int i = maxIndex + 1; i <= n; i++) {
      sb.append(array[i] + " ");
    }
    System.out.println(sb.toString());
  }

  class Item {
    int value;
    int order;

    Item(int value, int order) {
      this.value = value;
      this.order = order;
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