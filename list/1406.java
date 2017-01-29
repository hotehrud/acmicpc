import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
	private void solve() {
		char[] chars = sc.next().toCharArray();
		LinkedList<Character> list = new LinkedList<>();

		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		
		for(char ch : chars) {
			list.add(ch);
		}
		
		ListIterator iterator = list.listIterator(list.size());

		for(int i=0;i<n;i++) {
			String command = sc.next();
			
			if (command.equals("L")) {
				if (iterator.hasPrevious()) {
					iterator.previous();
				}
			} else if (command.equals("D")) {
				if (iterator.hasNext()) {
					iterator.next();
				}
			} else if (command.equals("B")) {
				if (iterator.hasPrevious()) {
					iterator.previous();
					iterator.remove();
				}
			} else {
				iterator.add(sc.next().charAt(0));
			}
		}
		for(char ch : list) {
			sb.append(ch);
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

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}