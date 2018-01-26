package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		int n = sc.nextInt();

		// 사자가 왼쪽 오른쪽 둘다 들어가 있지 않을 경우 => dp[n][0] = dp[n-1][0] + dp[n-1][1] + dp[n-1][2]
		// 사자가 왼쪽에만 들어가 있을 경우 => dp[n][1] = dp[n-1][0] + dp[n-1][2];
		// 사자가 오른쪽에만 들어가 있을 경우 => dp[n][2] = dp[n-1][0] + dp[n-1][1];

		int[][] dp = new int[n + 1][3];

		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		
		for (int i = 2; i <= n; i++) {

			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
			dp[i][1] = dp[i - 1][0] + dp[i - 1][2] % 9901;
			dp[i][2] = dp[i - 1][0] + dp[i - 1][1] % 9901;

		}
		System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % 9901);
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