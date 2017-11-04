package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parent = new int[100001];

	private void solve() {
		// http://mygumi.tistory.com/245
		int g = sc.nextInt();
		int p = sc.nextInt();
		int ans = 0;

		for (int i = 1; i <= g; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= p; i++) {
			int gi = sc.nextInt();

			int docking = find(gi);
			if (docking != 0) {
				merge(docking, docking - 1);
				++ans;
			} else {
				break;
			}
		}
		System.out.println(ans);
	}

	public static void merge(int u, int v) {
		u = find(u);
		v = find(v);
		parent[u] = v;
	}

	public static int find(int u) {
		if (u == parent[u]) {
			return u;
		}
		return parent[u] = find(parent[u]);
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

		static boolean hasNext() {
			return st.hasMoreTokens();
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