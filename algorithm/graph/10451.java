package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		// 순열 사이클 == 그래프의 연결 요소 갯수
		
		while (t-- > 0) {
			int n = sc.nextInt();
			ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
			boolean[] c = new boolean[n + 1];
			int components = 0;

			for (int i = 0; i <= n; i++) {
				a[i] = new ArrayList<>();
			}

			for (int i = 1; i <= n; i++) {
				int v = sc.nextInt();

				a[i].add(v);
			}

			for (int i = 1; i <= n; i++) {
				
				if (!c[i]) {
					dfs(a,c,i);
					components++;
				}
				
			}
			sb.append(components + "\n");
		}
		System.out.println(sb.toString());
	}

	// 재귀 DFS - 인접리스트
	public static void dfs(ArrayList<Integer>[] a, boolean[] c, int v) {

		if (c[v]) {
			return;
		}
		
		c[v] = true;

		for (int vv : a[v]) {

			if (!c[vv]) {
				dfs(a, c, vv);
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