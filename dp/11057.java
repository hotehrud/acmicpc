package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		int n = sc.nextInt();
		long[][] dp = new long[1001][10];
		long[] ans = new long[1001];
		
		// 2688문제 == 
		// dp[N][L] = N 길이 마지막 숫자가 L일 경우의 수 
		// dp[N][L] = sum(dp[N-1][0~9])
		
		ans[1] = 10;
		
		for(int i=0;i<10;i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2;i<=n;i++) {
			long sum = 0;
			
			for(int j=0;j<10;j++) {
				dp[i][j] = (dp[i-1][j] + sum);
				
				sum += dp[i-1][j];
				
				dp[i][j] %= 10007;
			}
			
			
			for(int j=0;j<10;j++) {
				ans[i] += dp[i][j];
				ans[i] %= 10007;
			}
		}
		System.out.println(ans[n]);
	}
	
	public int max(int a, int b) {
		if (a > b) {
			return a; 
		} else {
			return b;
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