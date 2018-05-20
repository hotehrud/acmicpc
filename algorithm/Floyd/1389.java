package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		int m = sc.nextInt();

		// 기본 플로이드 와샬 알고리즘 
		
		int[][] a = new int[n + 1][n + 1];
		int[] ans = new int[n + 1];

		for(int i=1;i<=n;i++) {
			Arrays.fill(a[i], 5000);
		}
		
		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			a[v1][v2] = 1;
			a[v2][v1] = 1;
		}

		for (int k = 1; k <= n; k++) {

			for (int i = 1; i <= n; i++) {

				for (int j = 1; j <= n; j++) {

					if (a[i][j] > a[i][k] + a[k][j]) {
						a[i][j] = a[i][k] + a[k][j];
					}

				}

			}

		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n; j++) {
				
				if (i == j) {
					continue;
				}
				
				ans[i] += a[i][j];
				
			}
			
			if (min > ans[i]) {
				min = ans[i];
			}
			
		}
		
		for (int i = 1; i <= n; i++) {

			if (min == ans[i]) {
				System.out.println(i);
				return;
			}
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