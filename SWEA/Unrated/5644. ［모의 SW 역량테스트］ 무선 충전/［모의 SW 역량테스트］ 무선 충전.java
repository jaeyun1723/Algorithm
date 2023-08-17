import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// x, y 좌표 바뀜
/*
1.summary
만약 한 BC에 두 명의 사용자가 접속한 경우, 접속한 사용자의 수만큼 충전 양을 균등하게 분배한다.
BC의 정보와 사용자의 이동 궤적이 주어졌을 때, 모든 사용자가 충전한 양의 합의 최댓값을 구하는 프로그램을 작성하라
2. strategy

3. 특이사항

*1. 지도의 가로,세로 크기는 10이다.
*2. 사용자는 총 2명이며,사용자A는 지도의 (1, 1) 지점에서, 사용자B는 지도의 (10, 10) 지점에서 출발한다.
*3. 총 이동 시간 M은 20이상 100이하의 정수이다. (20 ≤ M ≤ 100)
*4. BC의 개수 A는 1이상 8이하의 정수이다. (1 ≤ A ≤ 8)
*5. BC의 충전 범위 C는 1이상 4이하의 정수이다. (1 ≤ C ≤ 4)
*6. BC의 성능 P는 10이상 500이하의 짝수이다. (10 ≤ P ≤ 500)
*7. 사용자의 초기 위치(0초)부터 충전을 할 수 있다.
*8. 같은 위치에 2개 이상의 BC가 설치된 경우는 없다. 그러나 사용자A, B가 동시에 같은 위치로 이동할 수는 있다.
*	사용자가 지도 밖으로 이동하는 경우는 없다.
 */
public class Solution {

    static int[][] map, info;
    static int[] dx = {0, 0, 1, 0, -1}; // 0:x 1:상 2:우 3:하 4:좌
    static int[] dy = {0, -1, 0, 1, 0}; // 내 식으로 바꿈
    static int[] userA, userB;
    static int M, A;

    static class BC {

        int performance;
        char type;

        BC(int performance, char type) {
            this.performance = performance;
            this.type = type;
        }

    }

    static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }


    static int coverage(int[] a, int[] b) {
        int sum = 0;
        ArrayList<BC> list = new ArrayList<>();
        boolean[] who = new boolean[2]; // A B
        for (int i = 0; i < info.length; i++) {
            int aDist = distance(a[0], a[1], info[i][0], info[i][1]);
            int bDist = distance(b[0], b[1], info[i][0], info[i][1]);
            if (aDist <= info[i][2] && bDist <= info[i][2]) {
                list.add(new BC(info[i][3], 'D'));
            } else if (aDist <= info[i][2]) {
                list.add(new BC(info[i][3], 'A'));
            } else if (bDist <= info[i][2]) {
                list.add(new BC(info[i][3], 'B'));
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        Collections.sort(list, new Comparator<BC>() {
            @Override
            public int compare(BC o1, BC o2) {
                return o2.performance - o1.performance;
            }
        });

        int cnt = 0, idx = 0;
        while (cnt < 2 && idx < list.size()) {
            if (list.get(idx).type == 'D') {
                sum += list.get(idx).performance;
                cnt++;
            } else if (!who[0] && list.get(idx).type == 'A') {
                who[0] = true;
                sum += list.get(idx).performance;
                cnt++;
            } else if (!who[1] && list.get(idx).type == 'B') {
                who[1] = true;
                sum += list.get(idx).performance;
                cnt++;
            }
            idx++;
        }
        return sum;
    }

    static int batteryCharge() {
        // 초기 위치에서
        int[] A = {1, 1};
        int[] B = {10, 10};
        int sum = coverage(A, B);
        for (int i = 0; i < M; i++) {
            A[0] += dx[userA[i]];   // x
            A[1] += dy[userA[i]];   // y
            B[0] += dx[userB[i]];   // x
            B[1] += dy[userB[i]];   // y
            // 위치 구하기
            int cnt = coverage(A, B);
            sum += cnt;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            map = new int[11][11];
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            userA = new int[M];
            userB = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                userA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                userB[i] = Integer.parseInt(st.nextToken());
            }

            info = new int[A][4];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                info[i][0] = Integer.parseInt(st.nextToken());  // y
                info[i][1] = Integer.parseInt(st.nextToken());  // x
                info[i][2] = Integer.parseInt(st.nextToken());  // 충전 범위
                info[i][3] = Integer.parseInt(st.nextToken());  // 성능
            }
            int result = batteryCharge();
            System.out.println("#" + t + " " + result);
        }

    }//


}//