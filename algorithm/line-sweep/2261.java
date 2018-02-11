import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.StringTokenizer;

public class Main {
  // https://github.com/hotehrud/acmicpc
  // http://mygumi.tistory.com/294
  private void solve() {
    int n = sc.nextInt();
    ArrayList<Point> list = new ArrayList<Point>();
    TreeSet<Point> candidate = new TreeSet<Point>(new ComparatorSet());
    int ans = 0;

    for (int i = 0; i < n; i++) {
      list.add(new Point(sc.nextInt(), sc.nextInt()));
    }

    Collections.sort(list, new ComparatorDescending());

    candidate.add(list.get(0));
    candidate.add(list.get(1));
    ans = distance(list.get(0), list.get(1));

    int start = 0;
    for (int i = 2; i < n; i++) {
      Point now = list.get(i);

      // x axis
      while (start < i) {
        Point pivot = list.get(start);
        int x = pivot.x - now.x;

        if (x * x > ans) {
          candidate.remove(pivot);
          start += 1;
        } else {
          break;
        }
      }

      int d = (int) Math.sqrt((double) ans) + 1;
      Point lower_point = new Point(now.y - d, now.y + d);
      SortedSet<Point> lower = candidate.tailSet(lower_point);
      Iterator<Point> it_lower = lower.iterator();

      while (it_lower.hasNext()) {
        Point p = it_lower.next();
        d = distance(now, p);
        if (d < ans) {
          ans = d;
        }
      }
      candidate.add(list.get(i));
    }
    System.out.println(ans);
  }

  public static int distance(Point p1, Point p2) {
    return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
  }

  static class ComparatorDescending implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
      if (p1.x < p2.x) {
        return -1;
      } else if (p1.x == p2.x) {
        return 0;
      } else {
        return 1;
      }
    }
  }

  static class ComparatorSet implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
      if (p1.y == p2.y) {
        if (p1.x < p2.x) {
          return -1;
        } else if (p1.x == p2.x) {
          return 0;
        } else {
          return 1;
        }
      } else {
        return p1.y < p2.y ? 1 : -1;
      }
    }
  }

  static class Point implements Comparable<Point> {
    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int compareTo(Point p) {
      return x < p.y && y > p.y ? 1 : -1;
    }
  }

  public static void main(String[] args) {
    sc.init();

    new Main().solve();
  }

  static class sc {
    private static BufferedReader br;
    private static StringTokenizer st;

    static void init() {
      br = new BufferedReader(new InputStreamReader(System.in));
      st = new StringTokenizer("");
    }

    static String readLine() {
      try {
        return br.readLine();
      } catch (IOException e) {
      }
      return null;
    }

    static String readLineReplace() {
      try {
        return br.readLine().replaceAll("\\s+", "");
      } catch (IOException e) {
      }
      return null;
    }

    static String next() {
      while (!st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
        }
      }
      return st.nextToken();
    }

    static boolean hasNext() {
      return st.hasMoreTokens();
    }

    static long nextLong() {
      return Long.parseLong(next());
    }

    static int nextInt() {
      return Integer.parseInt(next());
    }

    static double nextDouble() {
      return Double.parseDouble(next());
    }
  }
}