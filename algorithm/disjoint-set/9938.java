import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/249

	static int[] parent = new int[300001];
	static boolean[] visited = new boolean[300001];
	static StringBuilder sb = new StringBuilder();

	private void solve() {
		int n = sc.nextInt();
		int l = sc.nextInt();

		for (int i = 1; i <= l; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (!visited[a]) {
				visited[a] = true;
				merge(a, b);
			} else if (!visited[b]) {
				visited[b] = true;
				merge(b, a);
			} else if (!visited[find(parent[a])]) {
				visited[find(parent[a])] = true;
				merge(a, b);
			} else if (!visited[find(parent[b])]) {
				visited[find(parent[b])] = true;
				merge(b, a);
			} else {
				sb.append("SMECE\n");
			}
		}
		System.out.println(sb.toString());
	}

	public static void merge(int u, int v) {
		u = find(u);
		v = find(v);
		parent[u] = v;
		sb.append("LADICA\n");
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