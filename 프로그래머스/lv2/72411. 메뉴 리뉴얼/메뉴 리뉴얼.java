import java.util.*;

class Solution {
    static int[] dish = new int[26]; // 요리 주문 횟수
    static int max;
    static String[] select, order;  // select : 조합으로 선택된 요리, order :orders
    static ArrayList<String> sub,ans; // sub : course[i]번 선택된 요리집합
    static Map<String,Integer> map;
    static int mainCourse(){    // 조합이 몇 개 해당되는지
        int res=0;
        for(int i=0;i<order.length;i++){
            int cnt=0;
            for(int j=0;j<select.length;j++){
                if(order[i].contains(select[j]))
                    cnt++;
                else break;
            }
            if(cnt==select.length)
                res++;
        }
       return res;
    }
    
    static void function(int cnt, int idx){
        if(cnt==select.length){
            int num=mainCourse();
            max=Math.max(max,num);
            if(num>=2){
                String str="";
                for(int i=0;i<select.length;i++)
                    str+=select[i];
                map.put(str,num);
            }
            return;
        }
        for(int i=idx;i<sub.size();i++){
            select[cnt]=sub.get(i);
            function(cnt+1,i+1);
        }
    }
    static void subSet(){
        for(int i=0;i<26;i++){
            if(dish[i]>=2){
                char c=(char)(i+65);
                sub.add(String.valueOf(c));
            }
        }
    }
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ans=new ArrayList<>();
        sub=new ArrayList<>();
        order=orders;
        int[] len=new int[11];
        int maxLen=0;
        for(int i=0;i<orders.length;i++){
            maxLen=Math.max(maxLen,orders[i].length());
            len[orders[i].length()]++;
            for(int j=0;j<orders[i].length();j++){
                dish[orders[i].charAt(j)-65]++;
                len[j]++;
            }
        }
        subSet();
        for(int i=0;i<course.length;i++){
            if(len[course[i]]<2||maxLen<course[i]) continue;
            map=new HashMap<>();
            // 조합으로 선택된 요리
            select=new String[course[i]];
            max=0;
            function(0,0);
            for(String key : map.keySet())
                if(map.get(key)==max)
                    ans.add(key);
    }
        Collections.sort(ans);
        answer=ans.toArray(new String[ans.size()]);
        return answer;
    }
}