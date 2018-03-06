import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  // http://mygumi.tistory.com/298

  private void solve() {
    int n = sc.nextInt();
    int[] array = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      array[i] = sc.nextInt();
    }

    int t = sc.nextInt();

    while (t-- > 0) {
      int sex = sc.nextInt();
      int idx = sc.nextInt();

      if (sex == 1) {
        // 남 
        for (int i = idx; i <= n; i += idx) {
          array[i] = array[i] == 0 ? 1 : 0;
        }
      } else {
        if ((idx == 1 || idx == n) || array[idx - 1] != array[idx + 1]) {
          array[idx] = array[idx] == 0 ? 1 : 0;
        } else {
          int left = idx - 1;
          int right = idx + 1;
          array[idx] = array[idx] == 0 ? 1 : 0;
          while (left > 0 && right <= n) {
            if (array[left] == array[right]) {
              array[left] = array[left] == 0 ? 1 : 0;
              array[right] = array[right] == 0 ? 1 : 0;
              --left;
              ++right;
            } else {
              break;
            }
          }
        }
      }
    }
    for (int i = 1; i <= n; i++) {
      System.out.print(array[i] + " ");
      if (i % 20 == 0) {
        System.out.println();
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

    static boolean hasNext() {
      return st.hasMoreTokens();
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