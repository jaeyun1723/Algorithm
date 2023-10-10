class Solution {
    static char[] digit={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    static String convert(int num, int n){
        String str="";
        while(num>0){
            int r=num%n;
            str+=String.valueOf(digit[r]);
            num/=n;
        }
        return str;
    }
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        // m(t-1)+p 
        char[] game=new char[m*(t-1)+p+1];
        game[1]='0';
        int num=1,idx=2;
        while(idx<game.length){
            String str=convert(num,n);
            for(int i=str.length()-1;i>=0;i--){
                if(idx>=game.length) break;
                game[idx++]=str.charAt(i);
            }
            num++;
        }
        for(int i=0;i<game.length;i++){
            if(m*i+p>=game.length) break;
            answer+=String.valueOf(game[m*i+p]);
        }
        return answer;
    }
}