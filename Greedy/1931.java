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
		
		// 그리디 알고리즘
		// 끝나는 시간을 기준으로 정렬
		// 시작시간과 끝나는시간은 같을 수 있다
		// n = 6 일 경우 -> 1 1, 1 2, 2 2, 3 3, 2 3, 4 4 답은 6

		int n = sc.nextInt();
		ArrayList<Pair> list = new ArrayList<>();
		
		while(n-- >0) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			list.add(new Pair(start,end));
			
		}

		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				
				if (o1.end < o2.end) {
					return -1;
				} else if (o1.end > o2.end){
					return 1;
				} else {
					if (o1.start < o2.start) {
						return -1;
					} else {
						return 0;						
					}
				}
				
			}
		});
		
		int beforeEnd = list.get(0).end;
		int cnt = 1;
		
		for(int i=1;i<list.size();i++) {
			
			int currentStart = list.get(i).start;
			int currentEnd = list.get(i).end;
			
			if (currentStart >= beforeEnd) {
				
				cnt++;
				beforeEnd = currentEnd;
				
			}
			
		}
		
		System.out.println(cnt);
	}
	
	public static class Pair {
		int start;
		int end;
		
		Pair(int start, int end) {
			this.start = start;
			this.end = end;
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