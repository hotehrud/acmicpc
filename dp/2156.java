package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		int[] array = new int[n+1];
		
		// 100 400 2 1 4 200
		// 포도주를 안 먹는 경우가 더 클 경우 존재
		// dp[n-3] + array[n] + array[n-1]
		// dp[n-2] + array[n]
		
		for(int i=1;i<=n;i++) {
			array[i] = sc.nextInt();
		}
		
		if (n == 1) {
			System.out.println(array[n]);
			return;
		}
		
		dp[1] = array[1];
		dp[2] = dp[1] + array[2];
		
		for(int i=3;i<=n;i++) {
			
			dp[i] = max(dp[i-3] + array[i] + array[i-1], dp[i-2] + array[i]);
			dp[i] = max(dp[i-1], dp[i]);
		}
		
		System.out.println(dp[n]);
		
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
