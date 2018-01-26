import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    LinkedList<Integer> list = new LinkedList<Integer>();

    int t = Integer.parseInt(br.readLine());
    String[] s = br.readLine().split(" ");
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(s[i]);
      list.add(n, i + 1);
    }

    for (int i = t - 1; i >= 0; i--) {
      sb.append(list.get(i) + " ");
    }
    System.out.println(sb.toString());
  }
}
