import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  // https://github.com/hotehrud/acmicpc
  // http://mygumi.tistory.com/

  static HashMap<Character, Integer> map = new HashMap<Character, Integer>();

  private void solve() {
    char[] roma = new char[1001];
    String ans = "";
    String s1 = sc.next();
    String s2 = sc.next();
    roma[1] = 'I';roma[5] = 'V';roma[10] = 'X';roma[50] = 'L';roma[100] = 'C';roma[500] = 'D';roma[1000] = 'M';
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    int a = getNumber(s1);
    int b = getNumber(s2);
    int sum = a + b;
    String s = String.valueOf(sum);
    int len = s.length();

    for (int i = len - 1; i >= 0; i--) {
      char ch = s.charAt(len - 1 - i);
      int cipher = (int) Math.pow(10, i);
      int v = (ch - '0') * cipher;

      if (v > cipher * 5) {
        if (v == cipher) {
          ans += roma[cipher];
        } else if (v == cipher * 9) {
          ans += roma[cipher];
          ans += roma[cipher * 10];
        } else {
          ans += roma[cipher * 5];
          int n = v / cipher;
          for (int k = 0; k < n - 5; k++) {
            ans += roma[cipher];
          }
        }
      } else {
        if (v == cipher * 5) {
          ans += roma[cipher * 5];
        } else if (v == cipher * 4) {
          ans += roma[cipher * 1];
          ans += roma[cipher * 5];
        } else {
          int n = v / cipher;
          for (int k = 0; k < n; k++) {
            ans += roma[cipher];
          }
        }
      }
    }
    System.out.println(sum);
    System.out.println(ans);
  }

  public static int getNumber(String s) {
    int prev = map.get(s.charAt(0));
    int len = s.length();
    int ans = 0;
    for (int i = 1; i < len; i++) {
      char ch = s.charAt(i);
      int v = map.get(ch);

      if (prev >= v) {
        ans += prev;
      } else {
        ans -= prev;
      }
      prev = v;
    }
    ans += map.get(s.charAt(len - 1));
    return ans;
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