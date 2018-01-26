import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/258

	private void solve() {
		int n = sc.nextInt();
		int[][] m = new int[501][501];
		int[] d = new int[1001];

		for (int i = 0; i < n; i++) {
			d[i] = sc.nextInt();
			d[i + 1] = sc.nextInt();
		}

		for (int len = 2; len <= n; len++) {
			for (int i = 1; i <= n - len + 1; i++) {
				int j = i + len - 1;
				m[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int cost = m[i][k] + m[k + 1][j] + d[i - 1] * d[k] * d[j];
					System.out.println(i + " " + j + " " + cost);
					m[i][j] = Math.min(m[i][j], cost);
				}
			}
		}
		System.out.println(m[1][n]);
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