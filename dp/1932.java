package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = sc.nextInt();
			}
		}

		// dp[i][j] = 꼭대기에서 i번째 레벨의 j 인덱스까지 합
		// 현재층은 바로 위층에서 해당되는 인덱스의 값을 더해준다.
		// if -> j == 0 || j == i 일 경우는 한쪽 대각선으로 바라본 위층을 더하면 된다.
		// else -> 왼쪽 오른쪽 대각선 모두 비교해야하기 때문에 max를 통해 더 큰 값을 넣어준다. 
		
		for (int i = 1; i < n; i++) {

			for (int j = 0; j <= i; j++) {

				if (j == 0) {
					dp[i][j] += dp[i-1][j];
				} else if (j == i) {
					dp[i][j] += dp[i-1][j-1];
				} else {
					dp[i][j] = max(dp[i][j] + dp[i-1][j-1], dp[i][j] + dp[i-1][j]);
					
				}
				
			}

		}

		int max = 0;
		for (int i=0;i<n;i++) {
			if (max < dp[n-1][i]) {
				max = dp[n-1][i];
			}
		}
		System.out.println(max);
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