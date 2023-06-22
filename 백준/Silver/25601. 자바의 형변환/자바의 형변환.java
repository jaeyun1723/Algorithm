import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<String, ArrayList<String>> map;

    static boolean isCasting(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (map.get(s1) == null) {
            return false;
        }
        for (String str : map.get(s1)) {
            if (isCasting(str, s2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();
            if (!map.containsKey(child)) {
                map.put(child, new ArrayList<>());
            }
            map.get(child).add(parent);
        }
        st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();
        System.out.println((isCasting(s1, s2) || isCasting(s2, s1)) ? 1 : 0);


    }//
}//
