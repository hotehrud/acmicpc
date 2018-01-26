package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		
		// 방문 여부는 boolean이 아닌 단지 번호를 삽입.
		
		int[][] a = new int[n+1][n+1];
		int[][] c = new int[n+1][n+1];
		int[] ans = new int[n*n];
		
		for(int i=1;i<=n;i++) {
			String[] s = sc.readLine().split("");
			
			for(int j=1;j<=n;j++) {
				a[i][j] = Integer.parseInt(s[j-1]);
			}
			
		}
		
		int cnt = 0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if (a[i][j] == 1 && c[i][j] == 0) {
					bfs(a,c,i,j,++cnt);
				}				
			}
			
		}
		
		for(int i=1;i<=n;i++) {
			
			for(int j=1;j<=n;j++) {
				ans[c[i][j]] += 1;
			}
			
		}
		
		System.out.println(cnt);
		Arrays.sort(ans, 1,cnt+1);
		for(int i=1;i<=cnt;i++) {
			System.out.println(ans[i]);
		}
		
	}
	
	public static void bfs(int[][] a, int[][] c, int x, int y, int cnt) {
		int n = a.length - 1;
		int ax = 0;
		int ay = 0;
	
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x,y));
		c[x][y] = cnt;
		
		while(!q.isEmpty()) {
			ax = q.peek().x;
			ay = q.peek().y;
			q.poll();
			
			// 상하좌우 4방향만 고려하면 됨.
	
			if (ax > 1 && a[ax-1][ay] == 1 && c[ax-1][ay] == 0) {
				q.add(new Pair(ax-1,ay));
				c[ax-1][ay] = cnt;
			}
			if (ax < n && a[ax+1][ay] == 1 && c[ax+1][ay] == 0) {
				q.add(new Pair(ax+1,ay));
				c[ax+1][ay] = cnt;
			}
			if (ay > 1 && a[ax][ay-1] == 1 && c[ax][ay-1] == 0) {
				q.add(new Pair(ax,ay-1));
				c[ax][ay-1] = cnt;
			}
			if (ay < n && a[ax][ay+1] == 1 && c[ax][ay+1] == 0) {
				q.add(new Pair(ax,ay+1));
				c[ax][ay+1] = cnt;
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