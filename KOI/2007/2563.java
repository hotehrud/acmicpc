import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] arr = new int[101][101];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int t = Integer.parseInt(br.readLine().trim());

    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      int left = Integer.parseInt(st.nextToken());
      int bottom = Integer.parseInt(st.nextToken());

      paint(left, bottom);
    }

    //		for(int i=1;i<101;i++) {
    //			for(int j=1;j<101;j++) {
    //				System.out.print(arr[i][j]);
    //			}
    //			System.out.println();
    //		}
    System.out.println(getArea());
  }

  public static void paint(int l, int b) {
    int start = 100 - b;
    for (int i = start; i > start - 10; i--) {
      for (int j = l; j < l + 10; j++) {
        arr[i][j] = 1;
      }
    }
  }

  public static int getArea() {
    int area = 0;
    for (int i = 1; i < 101; i++) {
      for (int j = 1; j < 101; j++) {
        if (arr[i][j] == 1) {
          ++area;
        }
      }
    }

    return area;
  }
}
