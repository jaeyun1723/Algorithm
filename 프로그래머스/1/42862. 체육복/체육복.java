class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[][] stud = new boolean[n + 1][2];
        for (int i = 1; i <= n; i++) {
            stud[i][0] = true;
        }
        for (int i = 0; i < lost.length; i++) {
            stud[lost[i]][0] = false;
        }
        for (int i = 0; i < reserve.length; i++) {
            if (stud[reserve[i]][0]) {
                stud[reserve[i]][1] = true;
            } else {
                stud[reserve[i]][0] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (stud[i][0]) {
                answer++;
            } else { // 체육복 없을 경우
                if (i - 1 > 0 && stud[i - 1][1]) {
                    stud[i][0] = true;
                    stud[i - 1][1] = false;
                    answer++;
                } else if (i + 1 <= n && stud[i + 1][1]) {
                    stud[i][0] = true;
                    stud[i + 1][1] = false;
                    answer++;
                }
            }
        }
        return answer;
    }
}