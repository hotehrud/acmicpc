package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		// LIS 
		// 증가하는 순으로 배치돼있는 가장 긴 아이들의 조합을 기준으로 잡으면 걔네는 건드릴 필요 없이 나머지만 옮김으로써 줄 세울 수 있다.

		int n = sc.nextInt();
		
		int[] array = new int[n+1];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			array[i] = sc.nextInt();
		}
		
		for(int num : array) {
			
			if (list.size() == 0 || list.get(list.size()-1) < num) {
				list.add(num);
			} else {
				
				int i = 0;
				int j = list.size() - 1;
				
				while(i<j) {
					
					int mid = (i + j) / 2;
					
					if (list.get(mid) < num) {
						i = mid + 1;
					} else {
						j = mid;
					}
					
				}
				
				list.set(j, num);
				
			}
			
		}
		
		System.out.println(n - list.size());
		
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
				String input = br.readLine();

				st = new StringTokenizer(input);

				return input;
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

		static boolean hasNext() {
			return st.hasMoreTokens();
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