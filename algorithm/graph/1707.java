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
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			// 양방향 그래프, 가중치 x
			// 그래프를 분할한 후 왼쪽 정점은 빨간색 오른쪽 정점은 파란색으로 구분.
			// 방문 O => 빨간색 = 1, 파란색 = 2, 방문 X => 0

			ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];

			for (int i = 0; i <= n; i++) {
				a[i] = new ArrayList<>();
			}

			int[] c = new int[n + 1];

			for (int i = 0; i < m; i++) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();

				a[v1].add(v2);
				a[v2].add(v1);

			}
			
			// 그래프가 2개 이상 존재할 경우를 위해 i부터 n까지 DFS
			for(int i=1;i<=n;i++) {
				dfs(a,c,i,1);				
			}
			
			boolean yes = true;
			for(int i=1;i<=n;i++) {
				
				for(int v : a[i]) {
					if (c[i] == c[v]) {
						yes = false;
						break;
					}
				}
				
			}
			
			System.out.printf("%s", yes ? "YES" : "NO");
			System.out.println();
		}
	}

	// DFS 인접리스트
	public static void dfs(ArrayList<Integer>[] a, int[] c, int v, int color) {

		if (c[v] != 0) {
			return;
		}
		
		c[v] = color;

		for (int vv : a[v]) {

			if (c[vv] == 0) {
				dfs(a, c, vv, 3-color);
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