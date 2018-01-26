package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<>();
			list.add((int) sc.next().charAt(0));
            
			for(int j=1;j<n;j++) {
				int card = sc.next().charAt(0);
				if (list.getFirst() >= card) {
					list.addFirst(card);
				} else {
					list.addLast(card);
				}
			}
			
			for(int value : list) {
				sb.append((char) value);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
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