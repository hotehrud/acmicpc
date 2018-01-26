package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		// a - 인접, c - 방문, s - 정점기준

		while (t-- > 0) {
			int n = sc.nextInt();

			int[] a = new int[n + 1];
			int[] c = new int[n + 1];
			int[] s = new int[n + 1];
			int ans = 0;

			for (int i = 1; i <= n; i++) {
				int v = sc.nextInt();

				a[i] = v;
			}
			
			for(int i=1;i<=n;i++) {
				if (c[i] == 0) {
					ans += dfs(a,c,s,i,i);
				}
			}
			sb.append((n - ans) + "\n");
		}
		System.out.println(sb.toString());
	}

	public static int dfs(int[] a, int[] c, int[] s, int v, int step) {
		int cnt = 1;

		while(true) {
			
			if (c[v] != 0) {
				if (s[v] != step) {
					// 이미 방문했고, 정점 시작점이 다를 경우 사이클 x
					return 0;
				}
				return cnt - c[v];
			}
			
			s[v] = step;
			c[v] = cnt;
			v = a[v];
			
			cnt += 1;
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