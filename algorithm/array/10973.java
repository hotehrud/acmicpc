package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
private void solve() {
		int n = sc.nextInt();
		int[] array = new int[n];
		
		for(int i=0;i<n;i++) {
			array[i] = sc.nextInt();
		}
		
		if (!nextPermutation(array)) {
			System.out.println(-1);
		}
		
	}

	public static boolean nextPermutation(int[] array) {
		int i = array.length - 1;
		// 증가하지 않는 가장 긴 접미사 인덱스.
		while(i > 0 && array[i] >= array[i-1]) {
			i--;
		}
		
		// 접미사 인덱스가 0이라는 것은 내림차순으로 정렬되었다는 뜻.
		if (i <= 0) {
			return false;
		}
		
		// array[i - 1] 을 피벗으로 잡는다.
		// 피벗을 기준으로 스왑할 피벗을 찾는다. => array[j]
		// 피벗은 찾는 과정에 비교되는 대상들에 비해 오름차순이기에 커야한다.

		int j = array.length - 1;
		while(array[j] >= array[i-1]) {
			j--;
		}
		
		swap(array,i-1,j);
		
		// 1243 -> 1342 경우를 위한 사전순 작업 리팩토링.
		j = array.length - 1;
	    while (i < j) {
	        int tmp = array[i];
	        array[i] = array[j];
	        array[j] = tmp;
	        i++;
	        j--;
	    }
		
		print(array);
		
		return true;
	}
	
	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void print(int[] array) {
		int len = array.length;
		
		for(int i=0;i<len;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
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