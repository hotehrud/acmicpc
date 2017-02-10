package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int l;
	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };

	private void solve() {

		// 기본적인 BFS . 탐색 방향이 응용된 문제
		
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			l = sc.nextInt();
			int[][] a = new int[l][l];
			int[][] dist = new int[l][l];
			
			for(int i=0;i<l;i++) {
				Arrays.fill(dist[i], -1);
			}

			int y = sc.nextInt();
			int x = sc.nextInt();
			int yy = sc.nextInt();
			int xx = sc.nextInt();

			bfs(a,dist,y,x);
			
			sb.append(dist[yy][xx] + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void bfs(int[][] a, int[][] dist, int y, int x) {

		Queue<Point> q = new LinkedList<>();

		dist[y][x] = 0;
		q.add(new Point(x, y));
		
		while(!q.isEmpty()) {
			
			Point p = q.poll();
			
			x = p.x;
			y = p.y;
			
			for(int i=0;i<8;i++) {
				
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if (0 <= xx && xx < l && 0 <= yy && yy < l) {
					
					if (dist[yy][xx] == -1) {
						q.add(new Point(xx, yy));
						
						dist[yy][xx] = dist[y][x] + 1;						
					}
				}
				
			}
			
		}
		
	}

	public static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
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