import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<Character> set = new HashSet<>();
        String[] result = new String[N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            boolean flag = false;

            // Step 1
            String[] words = str.split(" ");
            int idx = 0;
            for (int j = 0; j < words.length; j++) {
                char tmp = words[j].toLowerCase().charAt(0);
                if (!set.contains(tmp)) {
                    set.add(tmp);
                    flag = true;
                    break;
                } else
                    idx += words[j].length() + 1;
            }
            if (flag) {
                result[i] = str.substring(0, idx) + "[" + str.charAt(idx) + "]" + str.substring(idx + 1);
                continue;
            }

            // Step 2
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ' ') continue;
                if (!set.contains(str.toLowerCase().charAt(j))) {
                    set.add(str.toLowerCase().charAt(j));
                    idx = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                result[i] = str.substring(0, idx) + "[" + str.charAt(idx) + "]" + str.substring(idx + 1);
            } else {
                result[i] = str;
            }
        }

        for (String s : result)
            System.out.println(s);

    }

}