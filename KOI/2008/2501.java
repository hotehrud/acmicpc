import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  static ArrayList<Integer> list = new ArrayList<Integer>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s[] = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]);
    int k = Integer.parseInt(s[1]);

    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        list.add(i);
      }
    }

    if (list.size() < k) {
      System.out.println("0");
    } else {
      System.out.println(list.get(k - 1));
    }

  }
}
