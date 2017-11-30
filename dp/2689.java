import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/261

	private void solve() {
		int t = sc.nextInt();
		int[][][] dp = new int[101][100][2];
		StringBuilder sb = new StringBuilder();

		// 인접한 비트 개수가 k개면서 n번째 비트가 0 또는 1 일때
		// dp[n][k][0] = dp[n - 1][k][0] + dp[n - 1][k][1]
		// dp[n][k][1] = dp[n - 1][k - 1][1] + dp[n - 1][k][0]

		dp[1][0][1] = 1; // 1
		dp[1][0][0] = 1; // 0
		
		for (int k = 0; k < 100; k++) {

			for (int n = 2; n <= 100; n++) {
				if (k == 0) {
					dp[n][k][1] += dp[n - 1][k][0];
				} else {
					dp[n][k][1] += dp[n - 1][k][0] + dp[n - 1][k - 1][1];
				}
				dp[n][k][0] += dp[n - 1][k][0] + dp[n - 1][k][1];
			}

		}

		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();

			sb.append((dp[n][k][0] + dp[n][k][1]) + "\n");
		}
		System.out.println(sb.toString());
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