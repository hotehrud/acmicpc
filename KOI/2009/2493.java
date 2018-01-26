import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  private void solve() {
    int n = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    Stack<Integer> rootStack = new Stack<>();
    Stack<Integer> indexStack = new Stack<>();

    int first = sc.nextInt();
    rootStack.push(first);
    indexStack.push(1);
    sb.append("0 ");
    for (int i = 2; i <= n; i++) {
      int value = sc.nextInt();

      // 좌측 탑들을 비교할 때 현재 탑보다 높이가 낮다면 더 이상 비교할 필요가 없다.
      while (!rootStack.isEmpty()) {
        if (value < rootStack.peek()) {
          sb.append(indexStack.peek() + " ");
          break;
        }
        rootStack.pop();
        indexStack.pop();
      }
      if (rootStack.isEmpty()) {
        sb.append("0 ");
      }
      rootStack.push(value);
      indexStack.push(i);
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