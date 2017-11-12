import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/250

	static int parent[];
	static int level[];
	static int relation[];
	static StringBuilder sb;

	private void solve() {
		int t = sc.nextInt();
		sb = new StringBuilder();
		while (t-- > 0) {
			int f = sc.nextInt();
			int idx = 1;
			HashMap<String, Integer> hm = new HashMap<>();
			parent = new int[200001];
			level = new int[200001];
			relation = new int[200001];

			for (int i = 1; i < 200001; i++) {
				parent[i] = i;
				relation[i] = 1; 
			}

			for (int i = 0; i < f; i++) {
				String a = sc.next();
				String b = sc.next();

				if (!hm.containsKey(a)) {
					hm.put(a, idx++);
				}

				if (!hm.containsKey(b)) {
					hm.put(b, idx++);
				}
				
				int ai = hm.get(a);
				int bi = hm.get(b);
				
				merge(ai, bi);
			}
		}
		System.out.println(sb.toString());
	}

	public static void merge(int u, int v) {
		u = find(u);
		v = find(v);
		
		if (u == v) {
			sb.append(relation[u] + "\n");
			return;
		}
		
		if (level[u] > level[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		
		parent[u] = v;
		relation[v] += relation[u];
		sb.append(relation[v] + "\n");
		
		if (level[u] == level[v]) {
			++level[v];
		}
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