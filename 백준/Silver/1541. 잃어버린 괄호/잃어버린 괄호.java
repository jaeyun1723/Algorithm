import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int negative = str.indexOf("-");

        int answer = 0;
        if (negative == -1) {
            String[] num = str.split("\\+");
            for (int i = 0; i < num.length; i++)
                answer += Integer.parseInt(num[i]);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= negative; i++) {
                if (str.charAt(i) == '+' || i == negative) {
                    answer += Integer.parseInt(sb.toString());
                    sb.setLength(0);
                } else
                    sb.append(str.charAt(i));
            }
            for (int i = negative + 1; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    sb.append(str.charAt(i));
                } else {
                    answer -= Integer.parseInt(sb.toString());
                    sb.setLength(0);
                }
            }
            answer -= Integer.parseInt(sb.toString());
        }

        System.out.println(answer);


    }
}