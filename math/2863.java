package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		double d = sc.nextDouble();
		Double[] array = new Double[4];
		ArrayList<Integer> maxList = new ArrayList<>();
		
		array[0] = ((a/c+b/d));
		array[1] = ((c/d+a/b));
		array[2] = ((d/b+c/a));
		array[3] = ((b/a+d/c));
		
		double max = 0;
		double min = Integer.MAX_VALUE;
		
		for(int i=0;i<4;i++) {
			if (max < array[i]) {
				max = array[i];
			}
			
			if (min > array[i]) {
				min = array[i];
			}
		}

		for(int i=0;i<4;i++) {
			if (array[i] == max) {
				maxList.add(i);
			}
		}
	
		if(maxList.size() == 1) {
			System.out.println(maxList.get(0));
		} else {
			System.out.println(min);
		}
	}

	public static int max(int a, int b) {
		if (a < b) {
			return b;
		} else {
			return a;
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