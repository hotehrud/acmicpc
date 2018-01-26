import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[][] map = new int[10][10];
  static int currentRow, currentCol;

  private void solve() {
    // http://mygumi.tistory.com/208
    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        map[i][j] = sc.nextInt();
      }
    }
    fill();
    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static boolean fill() {
    int r = 0;
    int c = 0;

    if (findEmpty()) {
      return true;
    }

    r = currentRow;
    c = currentCol;

    for (int n = 1; n <= 9; n++) {
      if (isSafe(n, r, c)) {
        map[r][c] = n;
        if (fill()) {
          return true;
        }
        // failure
        map[r][c] = 0;
      }
    }
    // backtracking
    return false;
  }

  public static boolean isSafe(int n, int r, int c) {
    if (checkRow(r, n) && checkCol(c, n, 0) && checkBox(r, c, n)) {
      return true;
    }
    return false;
  }

  public static boolean findEmpty() {
    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        if (map[i][j] == 0) {
          currentRow = i;
          currentCol = j;
          return false;
        }
      }
    }
    return true;
  }

  public static boolean checkRow(int r, int n) {
    for (int i = 1; i <= 9; i++) {
      if (map[r][i] == n) {
        return false;
      }
    }
    return true;
  }

  public static boolean checkCol(int c, int n, int test) {
    for (int i = 1; i <= 9; i++) {
      if (map[i][c] == n) {
        return false;
      }
    }
    return true;
  }

  public static boolean checkBox(int r, int c, int n) {
    int row = ((int) Math.ceil(r / 3.0) - 1) * 3 + 1;
    int col = ((int) Math.ceil(c / 3.0) - 1) * 3 + 1;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (map[row + i][col + j] == n) {
          return false;
        }
      }
    }
    return true;
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