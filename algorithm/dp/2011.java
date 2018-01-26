package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		String input = sc.readLine();
		int len = input.length();

		int[] dp = new int[len + 1];
		int[] array = new int[len + 1];

		for (int i = 0; i < len; i++) {
			array[i + 1] = input.charAt(i) - '0';
		}

		dp[0] = 1;

		for (int i = 1; i <= len; i++) {

			if (array[i] != 0) {
				dp[i] = (dp[i - 1] + dp[i]) % 1000000;
			}

			int x = array[i] + array[i - 1] * 10;

			if (10 <= x && x <= 26) {
				dp[i] = (dp[i - 2] + dp[i]) % 1000000;
			}
		}

		System.out.println(dp[len] % 1000000);
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