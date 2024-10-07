import java.util.*;

class Solution {

    public int solution(int[][] scores) {
        int answer = 0;
        int[] wonho = scores[0];
        Arrays.sort(scores, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0] + o2[1], o1[0] + o1[1]);
            }
        });
        int num=1;
        
        for (int i = 0; i < scores.length; i++) {
            // 현재 scores[i]
            if (wonho[0] < scores[i][0] && wonho[1] < scores[i][1]) {
                return -1;
            }
            boolean flag=false;
            for(int j=0;j<i;j++){
                if(scores[j][0]>scores[i][0]&&scores[j][1]>scores[i][1]){
                    flag=true;
                    break;
                }
            }
            if(flag) continue;
            if (wonho[0] == scores[i][0] && wonho[1] == scores[i][1]) {
                answer = num;
                break;
            }
            num++;
        }

        return answer;
    }
}