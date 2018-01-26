import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> list = new ArrayList<Integer>();

    String[] s = br.readLine().split(" ");

    int n = Integer.parseInt(s[0]);
    int p = Integer.parseInt(s[1]);

    int first, last, temp;
    first = n * n % p;
    temp = first;
    list.add(first);

    out: while (true) {
      last = temp * n % p;

      temp = last;

      for (int i = 0; i < list.size(); i++) {
        if (list.get(i) == last) {
          System.out.println(list.size() - i);
          break out;
        }
      }

      list.add(last);
    }
  }
}
