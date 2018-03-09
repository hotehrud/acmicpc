import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		// LIS 알고리즘 - 최장 증가 수열
    // http://mygumi.tistory.com/69
        
		int n = sc.nextInt();
		int[] array = new int[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 0; i < n; i++) {

			array[i] = sc.nextInt();

		}
		
		int max = 1;
		dp[0] = 1;

		for (int i = 1; i < n; i++) {

			dp[i] = 1;

			for (int j = 0; j < i; j++) {

				if (array[i] > array[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}

			}
			
			if (max < dp[i]) {
				max = dp[i];
			}

		}
		System.out.println(max);
	}

	public static int getCount(int n, boolean female) {

		if (female) {
			n = (int) Math.ceil(n / 2);
		}

		return n;
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