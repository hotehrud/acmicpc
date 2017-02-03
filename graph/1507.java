package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static StringBuilder sb = new StringBuilder();

	private void solve() {

		int n = sc.nextInt();

		// 플로이드 역으로 활용
		// 모든 경로로 갈 수 있다고 문제에 정의됨 -> a 배열에 각 정점에 대해 모든 간선 연결
		// 최단 경로가 존재하면 i->j로 가는 간선은 없애버린다. i->k->j가 존재함으로써 i->j가 존재할 필요가 없음.
		
		int[][] dist = new int[n + 1][n + 1];
		int[][] a = new int[n + 1][n + 1];
		boolean[][] c = new boolean[n + 1][n + 1];
		int ans = 0;

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n; j++) {
				int d = sc.nextInt();
				
				dist[i][j] = d;
				a[i][j] = d; 
			}

		}

		for (int k = 1; k <= n; k++) {

			for (int i = 1; i <= n; i++) {

				for (int j = 1; j <= n; j++) {

					if (i == k || j == k) {
						continue;
					}
					
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						System.out.println(-1);
						return;
					}
					
					if (dist[i][j] == dist[i][k] + dist[k][j]) {
						a[i][j] = 0;
					}

				}

			}

		}
		
		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n; j++) {

				if (a[i][j] != 0 && !c[i][j]) {
					ans += a[i][j];
					
					c[i][j] = true;
					c[j][i] = true;
				}

			}
			
		}

		System.out.println(ans);
		
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