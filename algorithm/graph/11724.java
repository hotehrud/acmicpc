package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		int m = sc.nextInt();

		// 양방향 그래프, 가중치 x

		ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			a[i] = new ArrayList<>();
		}

		boolean[] c = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			a[v1].add(v2);
			a[v2].add(v1);

		}
		
		for (int i=1; i<=n; i++) {
            Collections.sort(a[i]);
        }

		int components = 0;
		for(int i=1;i<=n;i++) {
			if (!c[i]) {
				 dfs(a,c,i);
//				 bfs(a,c,i);
				components++;
			}
		}
		System.out.println(components);
	}

	// DFS 인접리스트
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

	// BFS 인접리스트
	public static void bfs(ArrayList<Integer>[] a, boolean[] c, int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		c[v] = true;
		
		while(!q.isEmpty()) {
			v = q.poll();
			
			for (int vv : a[v]) {

				if (!c[vv]) {
					q.add(vv);
					c[vv] = true;
				}

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