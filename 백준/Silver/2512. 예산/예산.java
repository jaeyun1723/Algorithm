import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N, limit;
    static int[] assets;

    public static boolean possible(int std) {
        int tot = limit;
        for (int asset : assets) {
            if (std > asset) {
                tot -= asset;
            } else {
                tot -= std;
            }
            if (tot < 0) {
                return false;
            }
        }
        if (tot >= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        assets = new int[N];

        int answer = 0;
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            assets[i] = Integer.parseInt(st.nextToken());
            sum += assets[i];
        }

        st = new StringTokenizer(br.readLine());
        limit = Integer.parseInt(st.nextToken());

        Arrays.sort(assets);
        if (sum <= limit) {
            System.out.println(assets[N - 1]);
            return;
        }

        int left = 0;
        int right = limit;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }

}