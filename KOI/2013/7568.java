import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static String[] arr;
  static int[] grade;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine().trim());
    arr = new String[t];
    grade = new int[t];

    for (int i = 0; i < t; i++) {
      arr[i] = br.readLine();
    }

    for (int i = 0; i < t; i++) {
      for (int j = 0; j < t; j++) {
        if (i == j)
          continue;

        grade[i] += compare(i, j);
      }
    }

    for (int i = 0; i < t; i++) {
      sb.append((grade[i] + 1) + " ");
    }

    System.out.println(sb.toString());
  }

  public static int compare(int a, int b) {
    String[] A = arr[a].split(" ");
    String[] B = arr[b].split(" ");

    int a_cm = Integer.parseInt(A[0]);
    int a_kg = Integer.parseInt(A[1]);
    int b_cm = Integer.parseInt(B[0]);
    int b_kg = Integer.parseInt(B[1]);

    if (a_cm < b_cm && a_kg < b_kg) {
      return 1;
    }

    return 0;
  }
}
