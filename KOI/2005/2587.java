import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Vector<Integer> v = new Vector<Integer>();

    for (int i = 0; i < 5; i++) {
      int num = sc.nextInt();
      v.add(num);
    }

    int sum = 0;
    for (int i = 0; i < 5; i++) {
      int temp = (int) v.get(i);
      sum += temp;
    }
    Object[] obj = v.toArray();
    Arrays.sort(obj);
    System.out.println(sum / 5);
    System.out.println(obj[2]);
  }
}