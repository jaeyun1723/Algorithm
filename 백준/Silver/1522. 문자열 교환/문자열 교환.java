import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int aCnt = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == 'a')
                aCnt++;

        int answer = 1001;
        for (int i = 0; i < str.length(); i++) {
            int bCnt = 0;
            for (int j = i; j < i + aCnt; j++) {
                if (str.charAt(j % str.length()) == 'b')
                    bCnt++;
            }
            answer = Math.min(answer, bCnt);
        }

        System.out.println(answer);
    }


}