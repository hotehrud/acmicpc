package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		//  스티커 뽑는 상태  
		//  0 1 2
		//  x o x  
		//  x x o
		
		// dp[n][s] = n 은 열, s 는 상태.  
		
		// 상태 s가 0일 때 그 전에 올 수 있는 경우로 s가 0,1,2 일 때 전부 가능
		// dp[n][0] = max( dp[n-1][0], dp[n-1][1], dp[n-1][2] )
		// 상태 s가 1일 때 그 전에 올 수 있는 경우로 s가 0,2 일 때 가능. 
		// dp[n][1] = max( dp[n-1][0], dp[n-1][2] ) + array[n][1];
		// 상태 s가 2일 때 그 전에 올 수 있는 경우로 s가 0,1 일 때 가능.
		// dp[n][2] = max( dp[n-1][0],dp[n-1][1] ) + array[n][2];
		
		while(t-- > 0) {
			int n = sc.nextInt();
			int[][] dp = new int[n+1][3];
			int[][] array = new int[n+1][3];
			
			for(int i=1;i<=2;i++) {
			
				for(int j=1;j<=n;j++) {
					array[j][i] = sc.nextInt();
				}
				
			}
			
			dp[1][0] = 0;
			dp[1][1] = array[1][1];
			dp[1][2] = array[1][2];
					
			for(int i=2;i<=n;i++) {
				dp[i][0] = max(max(dp[i-1][0],dp[i-1][1]), dp[i-1][2]);
				dp[i][1] = max(dp[i-1][0], dp[i-1][2]) + array[i][1];
				dp[i][2] = max(dp[i-1][0], dp[i-1][1]) + array[i][2];
			}
			
			sb.append(max(max(dp[n][0],dp[n][1]),dp[n][2]) + "\n");
		}
		
		System.out.println(sb.toString());
		
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