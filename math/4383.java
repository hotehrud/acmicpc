package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
						
			int len = scanner.nextInt();
			int[] array = new int[len];

			for (int i = 0; i < len; i++) {
				array[i] = scanner.nextInt();
			}
			
			System.out.println(isJolly(array) ? "Jolly" : "Not jolly");

		}

	}
	
	public static boolean isJolly (int[] array) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i =0;i<array.length - 1;i++) {
			
			int gap = Math.abs(array[i] - array[i+1]);
			
			if (gap == 0 || gap >= array.length) {
				return false;
			}
			
			if (list.contains(gap)) {
				return false;
			}
			
			list.add(gap);
		}
		
		return true;
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