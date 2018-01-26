import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int size = s.length();
    char ch = '\0';
    int sum = 0;

    for (int i = 0; i < size; i++) {
      char next = s.charAt(i);

      if (ch != next) {
        sum += 10;
      } else {
        sum += 5;
      }

      ch = next;
    }
    System.out.println(sum);
  }
}
