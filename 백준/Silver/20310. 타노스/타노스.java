import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 앞의 1제거, 뒤에 0제거

        int zero = 0;
        int one = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') zero++;
            else one++;
        }
        zero /= 2;
        one /= 2;

        boolean[] isEliminated = new boolean[str.length()];
        int start = 0;
        int end = str.length() - 1;
        while (zero > 0 || one > 0) {
            if (str.charAt(start) == '1' && one > 0) {
                isEliminated[start] = true;
                one--;
            }
            if (str.charAt(end) == '0' && zero > 0) {
                isEliminated[end] = true;
                zero--;
            }
            start++;
            end--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!isEliminated[i])
                sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }
}