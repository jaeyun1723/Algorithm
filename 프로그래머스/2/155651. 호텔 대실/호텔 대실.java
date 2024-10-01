class Solution {
    
    public int cleanTime(int time){
        int cleaning=time+10;
        if(cleaning%100>=60){
            cleaning+=40;
        }
        return cleaning;
    }
    
    public int solution(String[][] book_time) {
        int[] book=new int[2360];
        int answer=1;
        for(int i=0;i<book_time.length;i++){
            int start=Integer.parseInt(book_time[i][0].replace(":",""));
            int end=Integer.parseInt(book_time[i][1].replace(":",""));
            int endClean=cleanTime(end);
            if(endClean>2359) endClean=2359;
            for(int j=start;j<endClean;j++){
                book[j]++;
            }
        }
        for(int i=0;i<2360;i++){
            answer=Math.max(answer,book[i]);
        }
        return answer;
    }
}