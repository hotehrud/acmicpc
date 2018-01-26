package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		// DP
		// dp[n][m] = min( dp[n-1][m], dp[n-1][m-1], dp[n][m-1] );

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {

			String[] s = sc.readLine().split(" ");

			for (int j = 1; j <= m; j++) {

				dp[i][j] = Integer.parseInt(s[j-1]);

			}

		}

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= m; j++) {

				dp[i][j] += max(dp[i - 1][j - 1], max(dp[i - 1][j], dp[i][j - 1]));

			}

		}
		System.out.println(dp[n][m]);
	}

	public static int max(int x, int y) {
		return x > y ? x : y;
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