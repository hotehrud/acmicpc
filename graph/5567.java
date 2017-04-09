package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		int n = sc.nextInt();
		int m = sc.nextInt();

		boolean[][] array = new boolean[n + 1][n + 1];
		boolean[] visited = new boolean[n + 1];
		ArrayList<Integer> list = new ArrayList<>();
		int ans = 0;

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (a == 1) {
				list.add(b);
				ans++;
				visited[b] = true;
			}
			
			array[a][b] = true;
			array[b][a] = true;
		}
		
		for(int v : list) {
			
			for(int i=2;i<=n;i++) {
				if (array[v][i] && !visited[i]) {
					
					ans++;
					visited[i] = true;
					
				}
			}
			
		}
		System.out.println(ans);
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