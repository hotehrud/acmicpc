import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private void solve() {
    int a = sc.nextInt();
    int b = sc.nextInt();
    int v = sc.nextInt();

    int theDayBefore = v - a;
    int day = theDayBefore / (a - b);

    int currentHeight = (a - b) * day;
    while (true) {
      day++;
      currentHeight += a;

      if (currentHeight >= v) {
        break;
      }

      currentHeight -= b;
    }

    // System.out.println((int) Math.ceil((double)(V-A)/(A-B)) + 1);
    System.out.println(day);
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
