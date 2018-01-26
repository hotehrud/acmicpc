package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		// http://mygumi.tistory.com/134

		int[][] dp = new int[n + 1][m + 1];
		int r = (int) Math.ceil(k * 1.0 / m);
		int c = k == 0 ? 0 : k % m == 0 ? m : k % m;
		
		dp[1][1] = 1;

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= m; j++) {

				if (i == 1 && j == 1) {
					continue;
				}

				if ((i > r && j < c) || (i < r && j > c)) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}

			}

		}
		System.out.println(dp[n][m]);
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
				String input = br.readLine();

				st = new StringTokenizer(input);

				return input;
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

		static boolean hasNext() {
			return st.hasMoreTokens();
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
