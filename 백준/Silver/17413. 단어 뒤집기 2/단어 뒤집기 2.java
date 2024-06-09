import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && !flag) { // 문자의 끝일때
                sb.append(tmp.reverse()).append(' ');
                tmp = new StringBuilder();
            } else {
                if (str.charAt(i) == '<') {
                    flag = true;
                    sb.append(tmp.reverse());
                    tmp = new StringBuilder(str.charAt(i));
                    tmp.append(str.charAt(i));
                } else if (str.charAt(i) == '>') {
                    sb.append(tmp).append(str.charAt(i));
                    flag = false;
                    tmp = new StringBuilder();
                } else {
                    tmp.append(str.charAt(i));
                }
            }

        }
        sb.append(tmp.reverse());
        System.out.println(sb.toString());
    }

}