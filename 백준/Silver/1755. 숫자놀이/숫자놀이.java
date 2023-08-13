import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

    static String translate(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '8') {
                sb.append('a');
            } else if (str.charAt(i) == '5') {
                sb.append('b');
            } else if (str.charAt(i) == '4') {
                sb.append('c');
            } else if (str.charAt(i) == '9') {
                sb.append('d');
            } else if (str.charAt(i) == '1') {
                sb.append('e');
            } else if (str.charAt(i) == '7') {
                sb.append('f');
            } else if (str.charAt(i) == '6') {
                sb.append('g');
            } else if (str.charAt(i) == '3') {
                sb.append('h');
            } else if (str.charAt(i) == '2') {
                sb.append('i');
            } else if (str.charAt(i) == '0') {
                sb.append('j');
            }
        }
        return sb.toString();
    }

    // eight, five, four, nine, one, seven, six, three, two, zero
    // 8,5,4,9,1,7,6,3,2,0
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for (int i = N; i <= M; i++) {
            map.put(translate(String.valueOf(i)), i);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (i % 10 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(map.get(list.get(i))+" ");
        }

    }//
}//