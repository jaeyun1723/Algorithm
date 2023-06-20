import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static class Key {

        int x;
        int y;

        public Key(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
//            if(this == obj) return true;
//            if(obj == null || getClass()!=obj.getClass() ) return false;

            Key key=(Key) obj;
            return x==key.x && y==key.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Map<Key, Integer> map = new HashMap<>();
        Map<Integer,Integer> aaa=new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    Key key = new Key(j, k);
                    aaa.put(2, 2);
                    map.put(key, 1);
                }
            }
        }
        System.out.println(map.size());

    }//
}//
