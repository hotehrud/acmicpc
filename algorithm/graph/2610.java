package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

	private void solve() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		int[][] a = new int[n + 1][n + 1];
		boolean[] c = new boolean[n + 1];
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n; j++) {
				a[i][j] = (i == j) ? 0 : 100;
			}

		}

		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			a[v1][v2] = 1;
			a[v2][v1] = 1;
		}

		// 그래프 구분을 위한 컴포넌트화 
		for (int i = 1; i <= n; i++) {

			if (!c[i]) {
				list.add(new ArrayList<Integer>());
				list.get(list.size() - 1).add(i);
				dfs(a, c, i);
			}

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
		
		// list 인덱스에 각 연결 요소 저장되어 있는 리스트 저장되어있음. ArrayList<ArrayList<Integer>>
		// k - 각 연결 요소, i - 기준 출발 정점, j - 도착 정점
		// min - 연결 요소에서의 최소값
		// max - 출발 정점에서 도착 정점까지 최대값
		
		for (int k = 0; k < list.size(); k++) {

			ArrayList<Integer> components = list.get(k);
			int min = Integer.MAX_VALUE;
			int v = 0;

			for (int i = 0; i < components.size(); i++) {

				int max = 0;

				for (int j = 0; j < components.size(); j++) {

					if (max < a[components.get(i)][components.get(j)]) {

						max = a[components.get(i)][components.get(j)];
					}

				}

				if (min > max) {

					min = max;
					v = components.get(i);
				}

			}
			ans.add(v);
		}
		
		Collections.sort(ans);
		
		for(int i=0;i<ans.size();i++) {
			sb.append(ans.get(i) + "\n");
		}
		
		System.out.println(ans.size() + "\n" + sb.toString());
	}

	public static void dfs(int[][] a, boolean[] c, int v) {
		int n = a.length - 1;
		c[v] = true;

		for (int i = 1; i <= n; i++) {

			if (a[v][i] == 1 && !c[i]) {
				dfs(a, c, i);
				list.get(list.size() - 1).add(i);
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