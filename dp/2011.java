package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
private void solve() {
		String s = sc.readLine();
		int len = s.length();
		int[] dp = new int[len+1];
		int[] array = new int[len+1];
		
		for(int i=0;i<len;i++) {
			array[i+1] = s.charAt(i) - '0';
		}
		
		dp[0] = 1;
		
		// 01, 012, 0123 => 해석할 수 없기에 0
		// dp[i] = 2가지 경우. 1. 한자리 숫자, 2. 두자리 숫자.
		// 1. dp[i] = dp[i] + dp[i-1]
		
		for(int i=1;i<=len;i++) {
			
			if (array[i] >= 1 && array[i] <= 9) {
				dp[i] = (dp[i] + dp[i-1]) % 1000000;
			}
			
			if (array[i-1] == 0) {
				continue;
			}
			
			int x = array[i-1]*10 + array[i];
			
			if (10 <= x && x <= 26) {
				dp[i] = (dp[i] + dp[i-2]) % 1000000;
			}
			
		}
		System.out.println(dp[len]);
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