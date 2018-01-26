import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int count = 0;
  static int[][] arr = new int[4][4];
  static int[] maxArray = new int[4];
  static int win = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int sumA = 0, sumB = 0, sumC = 0;

    int n = Integer.parseInt(br.readLine());

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      arr[1][Integer.parseInt(st.nextToken())]++;
      arr[2][Integer.parseInt(st.nextToken())]++;
      arr[3][Integer.parseInt(st.nextToken())]++;
    }

    for (int i = 1; i <= 3; i++) {
      sumA += arr[1][i] * i;
      sumB += arr[2][i] * i;
      sumC += arr[3][i] * i;
    }

    int max = Math.max(sumA, sumB);
    max = Math.max(max, sumC);

    if (sumA == max)
      max(1);
    if (sumB == max)
      max(2);
    if (sumC == max)
      max(3);

    if (count > 1)
      over();

    if (count >= 1) {
      System.out.println(win + " " + max);
    } else {
      System.out.println("0 " + max);
    }
  }

  public static void max(int c) {
    ++count;
    win = c;
    maxArray[c] = c;
  }

  public static void over() {
    for (int i = 3; i > 0; i--) {
      int a = arr[maxArray[1]][i];
      int b = arr[maxArray[2]][i];
      int c = arr[maxArray[3]][i];

      int max = Math.max(a, b);
      max = Math.max(max, c);

      if (a != max)
        maxArray[1] = 0;
      if (b != max)
        maxArray[2] = 0;
      if (c != max)
        maxArray[3] = 0;

      if (a > b && a > c) {
        win = 1;
        return;
      } else if (b > a && b > c) {
        win = 2;
        return;
      } else if (c > a && c > b) {
        win = 3;
        return;
      }
    }
    count = 0;
  }
}
