import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/
	private void solve() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int max = sc.nextInt();
		int up = sc.nextInt();
		int down = sc.nextInt();
		boolean[] visited = new boolean[201];
		int x = m;
		int t = 0;
		
		if (m + up > max) {
			System.out.println(-1);
			return;
		}

		while(n > 0) {
            // 운동
			if (x + up <= max) {
				x += up;
				n--;
			} else {
                // 휴식
				x -= down;
				if (m > x) {
					x = m;
				}
			}
			t++;
		}
		System.out.println(t);
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