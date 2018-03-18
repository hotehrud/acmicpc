import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  // http://mygumi.tistory.com/303
  // https://github.com/hotehrud/acmicpc
  static int[] dp;

  private void solve() {
    int n = sc.nextInt();
    dp = new int[n];
    boolean[] visited = new boolean[500001];

    Pair[] pairs = new Pair[n];
    Pair[] tracking = new Pair[n];

    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      pairs[i] = new Pair(a, b);
      visited[a] = true;
    }

    Arrays.sort(pairs);

    int idx = 0;
    dp[0] = pairs[0].b;
    tracking[0] = new Pair(0, pairs[0].a);
    for (int i = 1; i < n; i++) {
      if (dp[idx] < pairs[i].b) {
        dp[++idx] = pairs[i].b;

        tracking[i] = new Pair(idx, pairs[i].a);
      } else {
        int ii = lower_bound(idx, pairs[i].b);
        dp[ii] = pairs[i].b;

        tracking[i] = new Pair(ii, pairs[i].a);
      }
    }

    Stack<Integer> stack = new Stack<Integer>();
    int temp = idx;
    for (int i = n - 1; i >= 0; i--) {
      if (tracking[i].a == temp) {
        stack.push(tracking[i].b);
        visited[tracking[i].b] = false;
        --temp;
      }
    }

    System.out.println(n - stack.size());
    for (int i = 1; i < 500001; i++) {
      if (visited[i]) {
        System.out.println(i);
      }
    }
  }

  static int lower_bound(int end, int n) {
    int start = 0;

    while (start < end) {
      int mid = (start + end) / 2;
      if (dp[mid] >= n) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return end;
  }

  static class Pair implements Comparable<Pair> {
    int a;
    int b;

    Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }

    public int compareTo(Pair o) {
      return this.a < o.a ? -1 : 1;
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