package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		// dp[n][m] = max(dp[n][m-1], dp[n-1][m])
		
		int[][] dp = new int[n+1][m+1];
		int ans = 0;

		for(int i=1;i<=n;i++) {
			
			for(int j=1;j<=m;j++) {
				
				dp[i][j] = sc.nextInt();
				
			}
			
		}
		
		for(int i=1;i<=n;i++) {
			
			for(int j=1;j<=m;j++) {
				
				dp[i][j] += max(dp[i][j-1], dp[i-1][j]);
				
			}
			
		}
		System.out.println(dp[n][m]);	
	}

	public static int max (int a, int b) {
		return a > b ? a : b;
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