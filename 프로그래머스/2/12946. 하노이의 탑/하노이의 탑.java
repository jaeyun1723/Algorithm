import java.util.*;

class Solution {

    static ArrayList<int[]> list;

    public static void hanoi(int n, int start, int mid, int end) {
        if (n == 0) {
            return;
        }
        hanoi(n - 1, start, end, mid);
        // 1. 맨 마지막 원판을 end로 옮기기 위해선 나머지를 mid로 옮겨라.
        list.add(new int[]{start, end});
        // 2. 마지막 원판을 c로 이동
        hanoi(n - 1, mid, start, end);
        // 3. 나머지 원판(mid)을 c로 이동시켜라.
    }

    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        // hanoi(N, start, mid, end): start에서 end로 mid를 거쳐 총 N개의 원반을 운반할                                            때 각 이동 과정을 출력하라
        int[][] answer = list.stream().toArray(int[][]::new);

        return answer;
    }
}