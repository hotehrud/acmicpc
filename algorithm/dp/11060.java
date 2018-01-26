package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		
		// LIS 시간복잡도 O(n^2) 방식과 비슷하게 접근
		
		int n = sc.nextInt();
		int[] dp = new int[n];
		int[] array = new int[n];
		
		for(int i=0;i<n;i++) {
			array[i] = sc.nextInt();
		}
		
		Arrays.fill(dp, 1);
		dp[0] = 0;
		
		for(int i=1;i<n;i++) {
			
			dp[i] = 1000;
			
			for(int j=0;j<i;j++) {
				
				if (array[j] + j >= i) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
				
			}
			
		}
		
		System.out.println(dp[n-1] == 1000 ? -1 : dp[n-1]);
		
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