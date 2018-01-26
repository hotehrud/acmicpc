import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
  // https://github.com/hotehrud/acmicpc
  // http://mygumi.tistory.com/

  private void solve() {
    int c = sc.nextInt();
    StringBuilder sb = new StringBuilder();

    while (c-- > 0) {
      String s = sc.next();
      String n = sc.next();
      BigInteger t = new BigInteger(sc.next());
      BigInteger l = new BigInteger(String.valueOf(sc.nextInt() * 100000000));
      BigInteger bi = new BigInteger(n);

      if (s.equals("O(N)")) {
        if (bi.multiply(t).compareTo(l) == 1) {
          sb.append("TLE!\n");
        } else {
          sb.append("May Pass.\n");
        }
      } else if (s.equals("O(N^2)")) {
        if (bi.pow(2).multiply(t).compareTo(l) == 1) {
          sb.append("TLE!\n");
        } else {
          sb.append("May Pass.\n");
        }
      } else if (s.equals("O(N^3)")) {
        if (bi.pow(3).multiply(t).compareTo(l) == 1) {
          sb.append("TLE!\n");
        } else {
          sb.append("May Pass.\n");
        }
      } else if (s.equals("O(2^N)")) {
        bi = new BigInteger("2");
        if (bi.pow(Integer.valueOf(n)).multiply(t).compareTo(l) == 1) {
          sb.append("TLE!\n");
        } else {
          sb.append("May Pass.\n");
        }
      } else {
        int N = Integer.valueOf(n);
        while (N-- > 1) {
          bi = bi.multiply(new BigInteger(String.valueOf(N)));
          if (bi.compareTo(l) == 1) {
            break;
          }
        }
        if (bi.multiply(t).compareTo(l) == 1) {
          sb.append("TLE!\n");
        } else {
          sb.append("May Pass.\n");
        }
      }
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