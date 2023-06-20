import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        while (!str.equals("end")) {
            String pw = "";
            boolean accept = false, flag = false;
            for (int i = 0; i < str.length(); i++) {
                int size = pw.length();
                for (int j = 0; j < vowel.length; j++) {
                    if (str.charAt(i) == vowel[j]) {
                        pw += "1";
                        accept = true;
                        break;
                    }
                }
                if (size == pw.length()) {
                    pw += "0";
                }
            }
            if (accept) {
                accept = !accept; // step1
            } else {
                System.out.println("<" + str + ">" + " is not acceptable.");
                flag = true;
            }
            if (!flag && (pw.contains("000") || pw.contains("111"))) {  // step2
                System.out.println("<" + str + ">" + " is not acceptable.");
                flag = true;
            }
            char prev = str.charAt(0);
            if (!flag) {
                for (int i = 1; i < str.length(); i++) {    // step3
                    if (prev == str.charAt(i) && (prev != 'e' && prev != 'o')) {
                        System.out.println("<" + str + ">" + " is not acceptable.");
                        flag = true;
                        break;
                    }
                    prev = str.charAt(i);
                }
            }
            if (!flag) {
                System.out.println("<" + str + ">" + " is acceptable.");
            }
            str = br.readLine();

        }//while


    }//
}//
