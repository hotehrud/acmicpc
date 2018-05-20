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

		// 양방향일 경우 0, 단방향일 경우 [u][v] -> [v][u] 반대로 1 적용
		// 양방향은 더할 필요가 없기에 0 역간선이기 때문에 반대 && 1
		// 그 후 플로이드 와샬 알고리즘

		StringBuilder sb = new StringBuilder();
		int[][] dist = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n; j++) {

				dist[i][j] = (i == j) ? 0 : 250;

			}

		}

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int b = sc.nextInt();

			if (b == 0) {
				dist[u][v] = 0;
				dist[v][u] = 1;
			} else {
				dist[u][v] = dist[v][u] = 0;
			}

		}

		for (int k = 1; k <= n; k++) {

			for (int i = 1; i <= n; i++) {

				for (int j = 1; j <= n; j++) {

					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}

				}

			}

		}

		int k = sc.nextInt();

		for (int i = 0; i < k; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();

			sb.append(dist[s][e] + "\n");
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