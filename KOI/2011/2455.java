import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    st.nextToken();

    int max = Integer.parseInt(st.nextToken());
    int current = max;

    for (int i = 0; i < 2; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int off = Integer.parseInt(st.nextToken());
      int on = Integer.parseInt(st.nextToken());

      current -= off;
      current += on;

      if (max < current) {
        max = current;
      }
    }
    br.readLine();
    System.out.println(max);
  }
}
