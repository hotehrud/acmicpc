package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		int[] array = new int[n + 1];
		boolean[][] dp = new boolean[n + 1][n + 1];
		StringBuilder sb = new StringBuilder();
		
		// dp[s][e] = s부터 e까지 팰린드롬인지 아닌지
		// dp[s][e] = array[s] == array[e] && dp[s+1][e-1]
		// http://mygumi.tistory.com/175

		String[] input = sc.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			array[i] = Integer.parseInt(input[i - 1]);
		}

		for (int i = 1; i <= n; i++) {
			dp[i][i] = true;
			if (array[i] == array[i - 1]) {
				dp[i - 1][i] = true;
			}
		}

		// i는 거리 s와 e 사이의 거리
		for (int i = 2; i <= n - 1; i++) {

			for (int j = 1; j <= n - i; j++) {
				if (array[j] == array[j + i] && dp[j + 1][j + i - 1]) {
					dp[j][j + i] = true;
				}
			}

		}

		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();

			if (dp[s][e]) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append("\n");
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