package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int t = sc.nextInt();
		int[] array;
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0) {
			int one = sc.nextInt();
			array = new int[one];
			
			for(int i=0;i<one;i++) {
				array[i] = sc.nextInt();
			}
			
			Arrays.sort(array);
			
			int two = sc.nextInt();
			
			for(int i=0;i<two;i++) {
				// Arrays 클래스 내장 binarySearch 대체 가능
				// sb.append(Arrays.binarySearch(array, sc.nextInt()) > -1 ? "1\n" : "0\n");				
				sb.append(binarySearch(array, sc.nextInt()) + "\n");				
			}
		}
		System.out.println(sb.toString());
	}
	
	public int binarySearch(int[] arr, int target) {
		 int first = 0;
         int last = arr.length - 1;
         int mid;

         while (first <= last) {

                 mid = (first + last) / 2;

                 if (target == arr[mid]) {
                         return 1;
                 } else {

                         if (target < arr[mid]) {
                        	 last = mid - 1;                        	 
                         } else {
                        	 first = mid + 1;                        	 
                         }
                 }
         }
		
		
		return 0;
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