import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // https://github.com/hotehrud/acmicpc
  // http://mygumi.tistory.com/292
  static StringBuilder sb1 = new StringBuilder();
  static StringBuilder sb2 = new StringBuilder();
  private void solve() {
    int[] array = new int[10001];
    int n = sc.nextInt();

    for (int i = 1; i <= n; i++) {
      array[i] = sc.nextInt();
    }

    if (front(array, 1, n)) {
      return;
    } 
    back(array, n, 1);
  }

  public static boolean front(int[] origin, int target, int n) {
    int[] array = origin.clone();
    int cnt = 0;
    while (target != n) {
      for (int i = target; i <= n; i++) {
        if (target == array[target]) {
          break;
        }
        if (array[i] == target) {
          cnt++;
          reverse(array, target, i);
          sb1.append(target + " " + i + "\n");
        }
      }
      target++;
    }

    if (cnt == 1) {
      System.out.println("1 1");
      System.out.println(sb1.toString());
      return true;
    } else if (cnt == 2) {
      System.out.println(sb1.toString());
      return true;
    } else {
      return false;
    }
  }

  public static boolean back(int[] origin, int target, int n) {
    int[] array = origin.clone();
    int cnt = 0;
    while (target != n) {
      for (int i = target; i >= n; i--) {
        if (target == array[target]) {
          break;
        }
        if (array[i] == target) {
          cnt++;
          reverse(array, i, target);
          sb2.append(i + " " + target + "\n");
        }
      }
      target--;
    }
    
    if (cnt == 1) {
      System.out.println("1 1");
      System.out.println(sb2.toString());
      return true;
    } else if (cnt == 2) {
      System.out.println(sb2.toString());
      return true;
    } else {
      System.out.println("1 1");
      System.out.println("1 1");
      return false;
    }
  }

  public static void reverse(int[] array, int s, int e) {
    int n = (int) Math.ceil((e - s) / 2.0);
    for (int i = 0; i < n; i++) {
      int temp = array[s + i];
      array[s + i] = array[e - i];
      array[e - i] = temp;
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