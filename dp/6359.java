package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		int t = sc.nextInt();

		while (t-- > 0) {

			// dp[n][l] = n라운드의 l번째 방의 현황
			
			int n = sc.nextInt();

			boolean[][] dp = new boolean[n + 1][n + 1];

			for (int i = 1; i <= n; i++) {
				if (i % 2 == 0) {
					dp[2][i] = true;
				}
			}

			for (int i = 3; i <= n; i++) {

				for (int j = 1; j <= n; j++) {
					
					if (j % i == 0) {
						dp[i][j] = dp[i - 1][j] ? false : true;
					} else {
						dp[i][j] = dp[i - 1][j];
					}
					
				}

			}

			int ans = 0;
			for (int i = 1; i <= n; i++) {
				if (!dp[n][i]) {
					ans++;
				}
			}
			System.out.println(ans);
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