package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		long[][] dp = new long[n+1][10];
		long[] ans = new long[n+1];
	
		// dp[N][L] = n 자리수에 마지막 숫자가 L인 경우
		// dp[N][L] = dp[N-1][L-1] + dp[N-1][L+1] (1<=L<=8)

		ans[1] = 9;
		
		for(int i=1;i<10;i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2;i<=n;i++) {
			
			for(int j=0;j<10;j++) {
				if (j == 0) {
					dp[i][j] = dp[i-1][j+1];
				} else if (j == 9) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];					
				}
				dp[i][j] %= 1000000000;
			}

			for(int j=0;j<10;j++) {
				ans[i] += dp[i][j]; 
			}
		}
		System.out.println(ans[n] % 1000000000);
	}

	public static int max(int a, int b) {
		if (a < b) {
			return b;
		} else {
			return a;
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