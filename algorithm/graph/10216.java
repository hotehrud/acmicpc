package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		// 적의 그룹 개수 = 그래프 개수
		// 적들간의 거리를 구한 후 범위에 들어온다면, 인접리스트 생성.
		// 인접리스트를 BFS 탐색을 통해 그래프 개수 조사. 
		
		while (t-- > 0) {
			int n = sc.nextInt();
			int ans = 0;

			ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[3001];
			ArrayList<Enemy> list = new ArrayList<>();
			boolean[] c = new boolean[3001];

			for (int i = 1; i <= n; i++) {
				a[i] = new ArrayList<>();
			}

			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int r = sc.nextInt();

				list.add(new Enemy(x, y, r));

			}

			for (int i = 1; i <= n; i++) {

				for (int j = i+1; j <= n; j++) {
					Enemy e1 = list.get(i-1);
					Enemy e2 = list.get(j-1);
					
					if (distance(e1, e2)) {
						
						a[i].add(j);
						a[j].add(i);
						
					}
 					
				}

			}
			
			for(int i=1;i<=n;i++) {
				
				if (!c[i]) {
					ans++;
					bfs(a,c,i);
				}
				
			}

			sb.append(ans + "\n");
			
		}
		System.out.println(sb.toString());
	}

	public static boolean distance(Enemy e1, Enemy e2) {

		int dist = (e1.x-e2.x) * (e1.x-e2.x) + (e1.y-e2.y) * (e1.y-e2.y);
		
		return dist <= ((e1.r + e2.r) * (e1.r + e2.r));
	}

	public static void bfs(ArrayList<Integer>[] a, boolean[] c, int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		c[v] = true;

		while (!q.isEmpty()) {

			v = q.poll();

			for (int x : a[v]) {

				if (!c[x]) {
					c[x] = true;
					q.add(x);
				}

			}
		}

	}

	public static class Enemy {
		int x;
		int y;
		int r;
		
		Enemy(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
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