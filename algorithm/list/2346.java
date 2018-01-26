package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		Deque<Pair> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		// 양수일 경우에는 뒤로 보낸다.
		// 음수일 경우에는 앞으로 보낸다.
		
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			q.addLast(new Pair(i,sc.nextInt()));
		}
		
		Pair p = q.pollFirst();
		sb.append(p.idx +  " ");
		int dist = p.move;
		
		while(!q.isEmpty()) {
			
			int tmp = 0;
			
			if (dist > 0) {
				
				while(++tmp < dist) {
					q.addLast(q.pollFirst());
				}
				p = q.pollFirst();
				
			} else {
				
				while(--tmp > dist) {
					q.addFirst(q.pollLast());
				}
				p = q.pollLast();
			}
			
			sb.append(p.idx + " ");
			dist = p.move;
		}
		System.out.println(sb.toString());
	}

	public static class Pair {
		int idx;
		int move;
		
		Pair(int idx, int move) {
			this.idx = idx;
			this.move = move;
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