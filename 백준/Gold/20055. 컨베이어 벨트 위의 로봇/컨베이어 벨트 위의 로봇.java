import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int[] durability = new int[2 * N];
        boolean[] robot = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 2 * N; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        int step = 1;
        while (true) {
            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            int tmp = durability[durability.length - 1];
            for (int i = durability.length - 1; i >= 0; i--) {
                if (i != 0)
                    durability[i] = durability[i - 1];
                else
                    durability[i] = tmp;
            }
            for (int i = robot.length - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = robot[N - 1] = false;
            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
            // 만약 이동할 수 없다면 가만히 있는다.
            // 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
            for (int i = robot.length - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && durability[i] >= 1) {
                    robot[i - 1] = false;
                    robot[i] = true;
                    durability[i]--;
                }
            }
            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if (durability[0] > 0) {
                robot[0] = true;
                durability[0]--;
            }

            // 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            int cnt = 0;
            for (int i = 0; i < durability.length; i++) {
                if (durability[i] == 0) cnt++;
            }
            if (cnt >= K)
                break;
            step++;
        }

        System.out.println(step);
    }
}