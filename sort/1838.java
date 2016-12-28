package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		// http://mygumi.tistory.com/84
		int n = sc.nextInt();
		ArrayList<Pair> list = new ArrayList<>();
				
		for(int i=0;i<n;i++) {
			list.add(new Pair(i, sc.nextInt()));
		}
		
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.value > o2.value) {
	                return 1;
	            } else if (o1.value == o2.value) {
	                return 0; 
	            } else {
	                return -1;
	            }
			}
		});
		
		int ans = 0;
		for(int i=0;i<n;i++) {
			if (ans < list.get(i).index - i) {
				ans = list.get(i).index - i;
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static class Pair {
		int index;
		int value;
		
		Pair(int index,int value) {
			this.index = index;
			this.value = value;
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