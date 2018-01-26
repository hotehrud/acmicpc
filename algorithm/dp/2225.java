package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
private void solve() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		long[][] dp = new long[201][201];
		
		// dp[K][N] = K개를 고른 합 N의 경우의 수
		// 마지막에 고를 수 있는 수 L ( 0<=L<=N )
		// dp[K][N] = sum (dp[K-1][N-L])
		
		for(int i=0;i<=n;i++) {
			dp[1][i] = 1;
		}
		
		for(int i=1;i<=k;i++) {
			
			for(int j=0;j<=n;j++) {
				
				for(int l=0;l<=j;l++) {
					dp[i][j] += dp[i-1][j-l];
					dp[i][j] %= 1000000000;
				}
				
			}
			
		}
		System.out.println(dp[k][n]);
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