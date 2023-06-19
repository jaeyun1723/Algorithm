
import java.awt.image.DataBufferDouble;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static char[] str, tmp;
	static int L, C;
	static String answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		str = new char[C];
		tmp = new char[L];
		for (int i = 0; i < C; i++)
			str[i] = st.nextToken().charAt(0);
		Arrays.sort(str);
		combination(0, 0);
	}//

	static void combination(int cnt, int idx) {
		if (cnt == L) {
			answer = new String(tmp);
			if(isCode(answer))
				System.out.println(answer);
			return;
		}
		for (int i = idx; i < C; i++) {
			tmp[cnt] = str[i];
			combination(cnt + 1, i + 1);
		}
	}

	static boolean isCode(String str) {
		String code = new String(str);
		if(code.contains("a")||code.contains("e")||code.contains("i")||code.contains("o")||code.contains("u"))
		{
			code=code.replaceAll("[aeiou]", "");
			if(code.length()>=2) return true;
			else return false;
		}
		return false;
	}
}//
