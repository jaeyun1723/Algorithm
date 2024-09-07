import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);

        Set<String> users = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String user = st.nextToken();
            users.add(user);
        }

        int size = users.size();
        int answer = 0;
        if (game == 'Y') {
            answer = size;
        } else if (game == 'F') {
            answer = size / 2;
        } else {
            answer = size / 3;
        }
        System.out.println(answer);

    }

}