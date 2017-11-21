import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/254

	private void solve() {
		int m = sc.nextInt();
		int n = sc.nextInt();
		Coin[] coins = new Coin[10001];
		int[][] dp = new int[10001][101];

		// dp[n][k] = n원일 때 동전 k개까지 사용했을 때의 경우의 수
		// dp[n][k] = dp[n][k] + dp[n - v * c][k - 1]

		for (int i = 1; i <= n; i++) {
			int v = sc.nextInt();
			int c = sc.nextInt();

			coins[i] = new Coin(v, c);
		}

		for (int i = 1; i <= n; i++) {
			int v = coins[i].value;
			int c = coins[i].count;
			dp[0][i - 1] = 1;

			for (int j = 1; j <= c; j++) {

				for (int k = v * j; k <= m; k++) {
					dp[k][i] += dp[k - (v * j)][i - 1];
				}

			}

			for (int j = 1; j <= m; j++) {
				dp[j][i] += dp[j][i - 1];
			}
		}
		System.out.println(dp[m][n]);
	}

	class Coin {

		int value = 0;
		int count = 0;

		Coin(int value, int count) {
			this.value = value;
			this.count = count;
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