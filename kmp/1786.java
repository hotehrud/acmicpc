import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  // http://mygumi.tistory.com/61
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

        String s = br.readLine();
		String p = br.readLine();
		ArrayList<Integer> list = kmp(s, p);
		
		int size = list.size();
		
		sb.append(size + "\n");
		for(int i=0;i<size;i++) {
			sb.append((list.get(i) + 1) + " ");
		}
		System.out.println(sb.toString());
	}

	public static int[] getPi(String pattern) {
		int m = pattern.length();
		int j = 0;
		char[] p = new char[m];
		int[] pi = new int[m];

		p = pattern.toCharArray();

		for (int i = 1; i < m; i++) {
			while (j > 0 && p[i] != p[j]) {
				j = pi[j - 1];
			}
			if (p[i] == p[j]) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}

	public static ArrayList<Integer> kmp(String str, String pattern) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] pi = getPi(pattern);
		int n = str.length(), m = pattern.length(), j = 0;
		char[] s = str.toCharArray();
		char[] p = pattern.toCharArray();
		//j - 찾을 문자열의 비교 인덱스.

		for (int i = 0; i < n; i++) {
			while (j > 0 && s[i] != p[j]) {
				//중간 단계 뛰어넘기.
				//pi배열을 이용하여 j인덱스를 변경시킴으로써 while문 중단.
				j = pi[j - 1];
			}
			if (s[i] == p[j]) {
				if (j == m - 1) {
					//j는 비교 인덱스로써, 인덱스가 찾을 문자열의 크기에 도달하면 문자열 찾음.
					list.add(i - m + 1);
					//여러 개의 찾을 문자열이 있을 수 있기 때문.
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		return list;
	}

}