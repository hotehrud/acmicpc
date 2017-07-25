package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int f, s, g, u, d;
	static int[] dx = { -1, 1 };
	static boolean[] visited = new boolean[1000001];

	private void solve() {
		f = sc.nextInt();
		s = sc.nextInt();
		g = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();

		dx[0] *= d;
		dx[1] *= u;

		System.out.println(bfs(s));
	}

	public static String bfs(int v) {
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(0, v));
		visited[v] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();
			int cnt = node.count;
			int floor = node.value;
			
			if (floor == g) {
				return String.valueOf(cnt);
			}

			for (int i = 0; i < 2; i++) {
				int next = dx[i] + floor;

				if (0 < next && next < 1000001) {
					if (!visited[next]) {
						q.add(new Node(cnt + 1, next));
						visited[next] = true;
					}
				}
			}
		}

		return "use the stairs";
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