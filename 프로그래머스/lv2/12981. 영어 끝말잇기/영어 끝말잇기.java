class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        String previous=words[0];
        boolean flag=false;
        for(int i=1;i<words.length;i++){
            for(int j=0;j<i;j++)
                if(words[j].equals(words[i]))    {flag=true; break;}
            if(flag|| previous.charAt(previous.length()-1)!=words[i].charAt(0))
            {
               // System.out.println(words[i]+" "+ flag);
                answer[0]=i%n+1;
                answer[1]=i/n+1;
                flag=true;
                break;
            }
            previous=words[i];
        }
        if(!flag) answer[0]=answer[1]=0;

        return answer;
    }
}