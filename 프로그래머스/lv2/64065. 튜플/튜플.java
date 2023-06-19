import java.util.*;

class Solution {
    public int[] solution(String s) {
       int[] answer = {};
		String str = s.replace("},{", ",");
		str = str.substring(2, str.length() - 2);
		String[] num = str.split(",");
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < num.length; i++) {
			int number = Integer.parseInt(num[i]);
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		List<Integer> list=new ArrayList<>(map.keySet());
		Collections.sort(list,(v1, v2)->(map.get(v2)-map.get(v1)));
		answer=new int[list.size()];
		for(int i=0;i<list.size();i++)
			answer[i]=list.get(i);
        return answer;
    }
}