import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int[] arr = new int[9];
    int sum = 0;

    for (int i = 0; i < 9; i++) {
      arr[i] = sc.nextInt();
      sum += arr[i];
    }

    for (int i = 0; i < 8; i++) {
      int temp = arr[i];
      for (int j = i + 1; j < 9; j++) {
        if (sum - temp - arr[j] == 100) {
          arr[i] = 0;
          arr[j] = 0;
          Arrays.sort(arr);
          for (int k = 2; k < 9; k++) {
            System.out.println(arr[k]);
          }
          return;
        }
      }
    }
  }
}
