import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		int k = sc.nextInt();

		// http://mygumi.tistory.com/129
		
		int[] coin = new int[n];
		int[] dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			coin[i] = sc.nextInt();
		}

		Arrays.fill(dp, 10001);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {

			for (int j = coin[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}

		}
		System.out.println(dp[k] == 10001 ? -1 : dp[k]);
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
