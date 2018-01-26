package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> rootStack = new Stack<>();
		Stack<Integer> indexStack = new Stack<>();

		int first = sc.nextInt();
		rootStack.push(first);
		indexStack.push(1);
		sb.append("0 ");
		for(int i=2;i<=n;i++) {
			int value = sc.nextInt();

			// 탑은 가장 가까이 존재하고 자신보다 높은 탑에 닿는다.
			// 좌측 탑들을 비교할 때 현재 탑보다 높이가 낮다면 더 이상 비교할 필요가 없다.
			// 예를 들어 7 9 가 존재한다면, 다음 탑이 3이라면 좌측 탑 중 9에 닿는다.
			// 이후 5가 들어온다면, 이전 탑 3이 아닌 9에 닿는다.
			// 이후 2가 들어온다면, 이전 탑 5에 닿는다.
			// 7 9 3 5 2 -> 왼쪽 탑보다 오른쪽 탑이 클 경우 왼쪽 탑은 무시해도 상관없다. 3과 5처럼 5가 높이 3을 막고 있기 때문이다.   
		
			while(!rootStack.isEmpty()) {
				if (value < rootStack.peek()) {
					sb.append(indexStack.peek() + " ");
					break;
				}
				rootStack.pop();
				indexStack.pop();
			}
			if (rootStack.isEmpty()) {
				sb.append("0 ");
			}
			rootStack.push(value);
			indexStack.push(i);
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