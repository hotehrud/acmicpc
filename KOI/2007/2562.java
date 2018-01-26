import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<Integer>();

    for (int i = 0; i < 9; i++) {
      list.add(sc.nextInt());
    }

    int max = Collections.max(list);
    System.out.println(max + "\n" + (list.indexOf(max) + 1));
  }
}
