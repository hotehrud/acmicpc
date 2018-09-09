import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  // http://mygumi.tistory.com/331
  private void solve() {
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] array = new int[n];

    for (int i = 0; i < n; i++) {
      array[i] = sc.nextInt();
    }

    Arrays.sort(array);
    System.out.println(binarySearch(array, 0, 2000000000, m));
  }

  public static int binarySearch(int[] array, int s, int e, int target) {
    while (s <= e) {
      int mid = (s + e) / 2;

      if (slice(array, mid, target)) {
        s = mid + 1;
      } else {
        e = mid - 1;
      }
    }
    return e;
  }

  public static boolean slice(int[] array, int h, int target) {
    long sum = 0;

    for (int v : array) {
      sum += v - h > 0 ? v - h : 0;
    }

    if (sum >= target) {
      return true;
    }
    return false;
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