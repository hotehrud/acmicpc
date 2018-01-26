package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent = new int[1000001];

	private void solve() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < 1000001; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int k = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (k == 1) {
				a = find(a);
				b = find(b);
				if (a == b) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			} else {
				merge(a,b);
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void merge(int u, int v) {
		u = find(u);
		v = find(v);
		
		if (u == v) {
			return;
		}
		
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