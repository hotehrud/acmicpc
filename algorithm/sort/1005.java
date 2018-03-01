import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		// http://mygumi.tistory.com/178
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] time = new int[n + 1];
			boolean[][] adj = new boolean[n + 1][n + 1];
			int[] indegree = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				time[i] = sc.nextInt();
			}

			for (int i = 0; i < k; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				adj[x][y] = true;
				indegree[y]++;
			}

			int w = sc.nextInt();

			int[] result = topologicalSort(adj, indegree, time);

			sb.append(result[w] + "\n");
		}
		System.out.println(sb.toString());
	}

	public static int[] topologicalSort(boolean[][] adj, int[] indegree, int[] time) {
		Queue<Integer> q = new LinkedList<Integer>();
		int len = indegree.length;
		int[] result = new int[len];

		for (int i = 1; i < len; i++) {
			if (indegree[i] == 0) {
				result[i] = time[i];
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int v = q.poll();
			for (int i = 1; i < len; i++) {

				if (adj[v][i]) {

					result[i] = Math.max(result[i], result[v] + time[i]);

					if (--indegree[i] == 0) {
						q.add(i);
					}
				}

			}

		}

		return result;
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