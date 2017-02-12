package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		
		int aN = sc.nextInt();
		int aM = sc.nextInt();
		int[][] a = new int[aN+1][aM+1];
		
		create(a,aN,aM);
		
		int bN = sc.nextInt();
		int bM = sc.nextInt();
		int[][] b = new int[bN+1][bM+1];
		
		create(b,bN,bM);
		
		int[][] c = new int[aN+1][bM+1];
		
		for(int i=1;i<=aN;i++) {
			
			for(int j=1;j<=bM;j++) {
				
				for(int k=1;k<=aM;k++) {
					
					c[i][j] += a[i][k] * b[k][j];
					
				}
				
			}
			
		}
		
		for(int i=1;i<=aN;i++) {
			
			for(int j=1;j<=bM;j++) {
				
				System.out.print(c[i][j] + " ");
				
			}
			System.out.println();
		}
		
	}
	
	public static void create(int[][] array, int n, int m) {
		
		for(int i=1;i<=n;i++) {
			
			for(int j=1;j<=m;j++) {
				
				array[i][j] = sc.nextInt();
				
			}
			
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