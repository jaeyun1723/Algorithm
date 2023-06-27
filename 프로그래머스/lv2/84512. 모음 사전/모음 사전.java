class Solution {
    static String[] vowel={"A","E","I","O","U"};
    static String target;
    static int answer = -1, cnt=0;
    static void dictionary(String word)
    {
        if(target.equals(word)) {
            answer=cnt;
            return;
        }
        if(word.length()==5) return;
        for(int i=0;i<vowel.length;i++){
            cnt++;
            dictionary(word+vowel[i]);
        }

    }
    
    public int solution(String word) {
        target=word;
        dictionary("");
        return answer;
    }
}