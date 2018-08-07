import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // http://mygumi.tistory.com/303
  private void solve() {
    int n = sc.nextInt();
    int[] array = new int[n];
    int[] lis = new int[n];

    for (int i = 0; i < n; i++) {
      array[i] = sc.nextInt();
    }

    int idx = 0;
    lis[0] = array[0];
    for (int i = 1; i < n; i++) {
      if (lis[idx] < array[i]) {
        lis[++idx] = array[i];
      } else {
        lis[lower_bound(lis, idx, array[i])] = array[i];
      }
    }
    System.out.println(n - (idx + 1));
  }

  public static int lower_bound(int[] array, int end, int n) {
    int start = 0;

    while (start < end) {
      int mid = (end + start) / 2;

      if (array[mid] < n) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    return end;
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