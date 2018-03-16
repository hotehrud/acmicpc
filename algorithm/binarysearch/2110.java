import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  // http://mygumi.tistory.com/301
  // https://github.com/hotehrud/acmicpc

  private void solve() {
    int n = sc.nextInt();
    int c = sc.nextInt();
    int[] array = new int[n];

    for (int i = 0; i < n; i++) {
      array[i] = sc.nextInt();
    }

    Arrays.sort(array);

    int left = 1; // 가능한 최소 거리
    int right = array[n - 1] - array[0]; // 가능한 최대 거리
    int d = 0;
    int ans = 0;

    while (left <= right) {
      int mid = (left + right) / 2; // 기준
      int start = array[0];
      int cnt = 1;

      // 간격(d) 를 기준으로 공유기 설치
      for (int i = 1; i < n; i++) {
        d = array[i] - start;
        if (mid <= d) {
          ++cnt;
          start = array[i];
        }
      }

      if (cnt >= c) {
        // 공유기의 수를 줄이자 => 간격 넓히기
        ans = mid;
        left = mid + 1;
      } else {
        // 공유기가 더 설치되어야한다. => 간격 좁히기
        right = mid - 1;
      }
    }
    System.out.println(ans);
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