class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i=0;i<discount.length;i++)
        {
            int[] cnt=number.clone();
            for(int j=i;j<i+10;j++)
            {
                if(j>=discount.length) break;
                for(int k=0;k<want.length;k++){                   
                    if(discount[j].equals(want[k])&&cnt[k]!=0){                    
                        cnt[k]--;
                        break;
                    }
                }
            }
            boolean flag=false;
            for(int n=0;n<cnt.length;n++){
                if(cnt[n]!=0){
                    flag=true;
                    break;
                } 
            }
            if(!flag) answer++;
        }
        
        return answer;
    }//
}//