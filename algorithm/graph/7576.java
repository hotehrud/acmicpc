package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static final int[] dx = { 0, 0, 1, -1 };
	public static final int[] dy = { 1, -1, 0, 0 };
	public static int n;
	public static int m;

	private void solve() {
		n = sc.nextInt();
		m = sc.nextInt();
		
		// 1인 경우 모두 큐에 넣고 시작. (동시 시작 위함)
		// dist가 -1이고, 토마토가 익지 않은 상태였을 경우 모두 토마토가 익을 수 없는 상황
		// dist[i][j] == -1 && a[i][j] == 0
		
		
		int[][] a = new int[m+1][n+1];
		int[][] dist = new int[m+1][n+1];
		boolean[][] c = new boolean[m+1][n+1];
		Queue<Pair> q = new LinkedList<>();
		int ans = -1;

		for (int i = 1; i <= m; i++) {
			String[] s = sc.readLine().split(" ");

			for (int j = 1; j <= n; j++) {
				a[i][j] = Integer.parseInt(s[j - 1]);
			}

		}
		
		for(int i=1;i<=m;i++) {
			
			for(int j=1;j<=n;j++) {
				dist[i][j] = -1;
				
				if (a[i][j] == 1) {
					q.add(new Pair(j, i));
					dist[i][j] = 0;					
				}
			}
			
		}
		
		bfs(q,a,c,dist);
		
		for(int i=1;i<=m;i++) {
			
			for(int j=1;j<=n;j++) {
				if (dist[i][j] == -1 && a[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				
				if (ans < dist[i][j]) {
					ans = dist[i][j];
				}
			}
		}
		
		System.out.println(ans);
	}

	public static void bfs(Queue<Pair> q, int[][] a, boolean[][] c, int[][] dist) {

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (0 < nx && nx <= n && 0 < ny && ny <= m) {
					if (a[ny][nx] == 0 && dist[ny][nx] == -1) {
						q.add(new Pair(nx, ny));
						
						dist[ny][nx] = dist[y][x] + 1;
						
					}
				}
			}

		}

	}

	public static void main(String[] args) {
		sc.init();

		new Main().solve();
	}

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
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