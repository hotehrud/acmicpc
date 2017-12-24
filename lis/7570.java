import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/276
	private void solve() {
		// 가장 긴 증가 수열, but 증가하는 수가 연속적 증가하여야한다.

		int n = sc.nextInt();
		int[] dp = new int[n + 1];
		int max = 0;
		// dp[i] = i번호일때까지 연속된 증가수열의 개수
		// dp[i] = dp[i - 1] + 1;
		for (int i = 1; i <= n; i++) {
			int k = sc.nextInt();
			dp[k] = dp[k - 1] + 1;
			max = Math.max(dp[k], dp[k - 1] + 1);
		}
		System.out.println(n - max);
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