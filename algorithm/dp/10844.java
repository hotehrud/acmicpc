import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/260

	private void solve() {
		int n = sc.nextInt();
		long[][] dp = new long[101][11];

		// dp[N][L] = dp[N - 1][L - 1] + dp[N - 1][L + 1]
		// 길이 N, 마지막 숫자가 L일 경우

		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
			
		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][1];
			for (int j = 1; j <= 9; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
			}
		}

		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[n][i];
		}
		System.out.println(sum % 1000000000);
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