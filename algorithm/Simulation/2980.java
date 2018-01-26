import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/272
	private void solve() {
		int n = sc.nextInt();
		int l = sc.nextInt();
		int t = 0;
		int pre = 0;

		for (int i = 0; i < n; i++) {
			int d = sc.nextInt();
			int r = sc.nextInt();
			int g = sc.nextInt();
			
			// t - 위치 d에 있는 신호등까지 걸린 시간
			t += d - pre;
			pre = d;

			int red = t % (r + g);
			if (red <= r) {
				// 빨간 불이 끝날때까지 대기
				t += r - red;
			}
		}
		System.out.println(t + (l - pre));
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