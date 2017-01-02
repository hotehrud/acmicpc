package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		StringBuilder sb = new StringBuilder();
		long[][] dp = new long[65][10];
		long[] ans = new long[65];
		ans[1] = 10;
		
		// dp[i][j] = sum ( dp[i-1][0~9] )
		// dp[2][0] 0 0     dp[3][2] 0 0 2
		// dp[2][1] 0 1		dp[3][2] 0 1 2
		// dp[2][1] 1 1		dp[3][2] 1 1 2
		// dp[2][2] 0 2		dp[3][2] 0 2 2
		// dp[2][2] 1 2		dp[3][2] 1 2 2
		// dp[2][2] 2 2		dp[3][2] 2 2 2
		
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			
			for(int i=0;i<10;i++) {
		        dp[1][i] = 1;
		    }
			
		    for(int i=2;i<65;i++) {
		        long sum = 0;
		        for(int j=0;j<10;j++) {
		        	
		        	dp[i][j] = dp[i-1][j] + sum;
		        	
		            sum += dp[i-1][j];
		        }
		        ans[i] = 0;
		        for(int j=0;j<10;j++) {
		        	ans[i] += dp[i][j];
		        }
		    }	
		    sb.append(ans[n] + "\n");
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