package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		// 동전 교환 최소 개수와 비슷
		
		int n = sc.nextInt();
		int[] dp = new int[n + 1];
		int[] array = new int[n + 1];
		int[] ans = new int[n + 1];

		array[1] = 1;

		for (int i = 2; i <= n; i++) {
			array[i] = array[i - 1] + i;
		}

		dp[1] = 1;
		int k = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + array[i];
			if (n < dp[i]) {
				k = i;
				break;
			}
		}

		Arrays.fill(ans, 300001);
		
		ans[0] = 0;
		for (int i = 1; i <= k; i++) {

			for (int j = dp[i]; j <= n; j++) {
				ans[j] = Math.min(ans[j], ans[j - dp[i]] + 1);
			}

		}

		System.out.println(ans[n]);
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
