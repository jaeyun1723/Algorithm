import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data,new Comparator<int[]>(){
           public int compare(int[] o1, int[] o2){
               if(o1[col-1]==o2[col-1])
                   return o2[0]-o1[0];
               return o1[col-1]-o2[col-1];
           } 
        });
        for(int i=row_begin-1;i<row_end;i++){
            int S_i=0;
            for(int j=0;j<data[i].length;j++){
                S_i+=data[i][j]%(i+1);
            }
            answer=answer^S_i;
        }
        
        return answer;
    }
}