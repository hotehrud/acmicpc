package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();

		// 양방향 그래프, 가중치 x

		int[][] a = new int[n + 1][n + 1];
		ArrayList<Integer>[] list = (ArrayList<Integer>[]) new ArrayList[n+1];

		boolean[] c = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			a[v1][v2] = 1;
			a[v2][v1] = 1;
		}

		// dfs(a,c,v);
		dfs(a, c, v, true);
		System.out.println();
		Arrays.fill(c, false);
		bfs(a, c, v);

	}

	// 재귀 DFS - 인접행렬
	public static void dfs(int[][] a, boolean[] c, int v) {
		int n = a.length - 1;

		c[v] = true;
		System.out.print(v + " ");

		for (int i = 1; i <= n; i++) {

			if (a[v][i] == 1 && !c[i]) {
				dfs(a, c, i);
			}

		}

	}

	// 스택 DFS - 인접행렬
	public static void dfs(int[][] a, boolean[] c, int v, boolean flag) {
		Stack<Integer> stack = new Stack<>();
		int n = a.length - 1;

		stack.push(v);
		c[v] = true;
		System.out.print(v + " ");

		while (!stack.isEmpty()) {
			int vv = stack.peek();

			flag = false;

			for (int i = 1; i <= n; i++) {

				if (a[vv][i] == 1 && !c[i]) {
					stack.push(i);
					System.out.print(i + " ");

					c[i] = true;
					flag = true;
					break;
				}

			}

			if (!flag) {
				stack.pop();
			}

		}

	}

	// 큐 BFS - 인접행렬
	public static void bfs(int[][] a, boolean[] c, int v) {
		Queue<Integer> q = new LinkedList<>();
		int n = a.length - 1;

		q.add(v);
		c[v] = true;

		while (!q.isEmpty()) {

			v = q.poll();
			System.out.print(v + " ");
			
			for (int i = 1; i <= n; i++) {

				if (a[v][i] == 1 && !c[i]) {
					q.add(i);
					c[i] = true;
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