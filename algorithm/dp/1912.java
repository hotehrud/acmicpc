package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		
		// dp[n] = dp[n-1] + dp[n] -> n까지 연속된 수의 합
		// 음수만 아니라면 어떤 수도 연속으로 포함하면 된다.
		
		for(int i=1;i<=n;i++) {
			dp[i] = sc.nextInt();
		}
		
		int max = dp[1];
		
		for(int i=2;i<=n;i++) {
			
			if (dp[i-1] > 0 && dp[i] + dp[i-1] > 0) {
				dp[i] += dp[i-1];
			} 
			
			if (max < dp[i]) {
				max = dp[i];
			}
			
		}
		
		System.out.println(max);
		
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