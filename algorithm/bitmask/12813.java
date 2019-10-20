import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private void solve() {
    int[] a = new int[100000];
    int[] b = new int[100000];
    StringBuilder sb = new StringBuilder();
    String s1 = sc.next();
    String s2 = sc.next();
    int MAX = s1.length();

    for (int i = 0; i < MAX; i++) {
      a[i] = s1.charAt(i) - '0';
      b[i] = s2.charAt(i) - '0';
    }

    // &
    for (int i = 0; i < MAX; i++) {
      sb.append(a[i] == 1 && b[i] == 1 ? 1 : 0);
    }
    sb.append("\n");
    // |
    for (int i = 0; i < MAX; i++) {
      sb.append(a[i] == 1 || b[i] == 1 ? 1 : 0);
    }
    sb.append("\n");
    // ^
    for (int i = 0; i < MAX; i++) {
      sb.append(a[i] != b[i] ? 1 : 0);
    }
    sb.append("\n");
    // ~
    for (int i = 0; i < MAX; i++) {
      sb.append(a[i] == 1 ? 0 : 1);
    }
    sb.append("\n");
    // ~
    for (int i = 0; i < MAX; i++) {
      sb.append(b[i] == 1 ? 0 : 1);
    }
    System.out.println(sb.toString());
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