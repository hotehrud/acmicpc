import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    //0<=A<=23)  (0<=B<=59)
    int hour = Integer.parseInt(st.nextToken());
    int min = Integer.parseInt(st.nextToken());
    int time = Integer.parseInt(br.readLine());
    int carry = 0;

    min = min + time;

    if (min >= 60) {
      int div = min / 60;
      carry = div;
      min -= 60 * carry;
    }

    hour += carry;

    if (hour >= 24) {
      hour -= 24;
    }

    System.out.println(hour + " " + min);
  }
}
