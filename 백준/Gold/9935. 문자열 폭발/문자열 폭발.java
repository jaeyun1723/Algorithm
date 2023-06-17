import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();

		st = new StringTokenizer(br.readLine());
		String bomb = st.nextToken();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
			if (sb.length() >= bomb.length()) {
				boolean flag = false;
				for (int j = 0; j < bomb.length(); j++) {
					if (sb.charAt(sb.length() - bomb.length() + j) != bomb.charAt(j)) {
						flag = true;
						break;
					}
				}
				if (!flag) 
					sb.delete(sb.length() - bomb.length(), sb.length());
			}
		}
		if(sb.length()==0) System.out.println("FRULA");
		else System.out.println(sb);
	}//
}//