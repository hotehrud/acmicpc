package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		int m = sc.nextInt();

		// 방향그래프로 최단 경로를 구함. 
		// i -> j는 i와 j는 키 비교가 가능하므로 방향이 없어도 j -> i는 비교가 가능하다
		// 각 정점의 경로를 구한 후 [i][j] 와 [j][i] 둘다 경로가 없다면 비교할 수 없다는 의미. 
		
		int[][] a = new int[n + 1][n + 1];
		boolean[] ans = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n; j++) {
				a[i][j] = (i == j) ? 0 : 500;
			}

		}

		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			a[v1][v2] = 1;
		}

		// 최단 경로 플로이드 와샬
		for (int k = 1; k <= n; k++) {

			for (int i = 1; i <= n; i++) {

				for (int j = 1; j <= n; j++) {

					if (a[i][j] > a[i][k] + a[k][j]) {
						a[i][j] = a[i][k] + a[k][j];
					}

				}

			}

		}
		
		for (int i = 1; i <= n; i++) {
			boolean flag = true;

			for (int j = 1; j <= n; j++) {

				if (a[i][j] == 500 && a[j][i] == 500) {

					flag = false;
					
					break;
				}

			}

			if (flag) {
				ans[i] = true;
			}

		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			
			if (ans[i]) {
				cnt++;
			}
			
		}

		System.out.println(cnt);

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