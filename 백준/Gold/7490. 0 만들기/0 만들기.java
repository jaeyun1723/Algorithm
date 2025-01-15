import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static boolean isZero(String formula) {
        int sum = 0;
        formula = formula.replace(" ", "") + "=";
        StringBuilder sb = new StringBuilder();
        char symbol = '+';
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (c >= '1' && c <= '9') {
                sb.append(c);
            } else {
                switch (symbol) {
                    case '+':
                        sum += Integer.parseInt(sb.toString());
                        break;
                    case '-':
                        sum -= Integer.parseInt(sb.toString());
                        break;
                }
                symbol = c;
                sb.setLength(0);
            }
        }
        return sum == 0;
    }

    public static void formula(int num, int N, String str) {
        str += num;
        if (num == N) {
            if (isZero(str)){
                System.out.println(str);
            }
            return;
        }
        formula(num + 1, N, str + " ");
        formula(num + 1, N, str + "+");
        formula(num + 1, N, str + "-");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            formula(1, N, "");
            System.out.println();
        }
    }

}