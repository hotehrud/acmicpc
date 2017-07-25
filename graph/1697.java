package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int k;
	static int[] dx = { -1, 1, 0 };
	static boolean[] visited = new boolean[100001];

	private void solve() {
		// http://mygumi.tistory.com/187
		
		n = sc.nextInt();
		k = sc.nextInt();

		if (n >= k) {
			System.out.println(n - k);
			return;
		}

		System.out.println(bfs(n));
	}

	public static int bfs(int v) {
		Queue<Node> q = new LinkedList<>();

		visited[v] = true;
		q.add(new Node(0, v));

		while (!q.isEmpty()) {
			Node node = q.poll();
			int cnt = node.count;
			int pos = node.value;
			
			if (pos == k) {
				return cnt;
			}

			for (int i = 0; i < 3; i++) {
				int next;

				if (dx[i] != 0) {
					next = pos + dx[i];
				} else {
					next = pos * 2;
				}

				if (0 <= next && next <= 100000) {
					if (!visited[next]) {
						q.add(new Node(cnt + 1, next));
						visited[next] = true;
					}
				}

			}

		}

		return 0;
	}

	public static class Node {
		int count;
		int value;
	
		Node (int count, int value) {
			this.count = count;
			this.value = value;
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