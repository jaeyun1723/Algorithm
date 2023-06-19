import java.util.*;

class Solution {
    public String solution(int[] numbers) {
		String answer="";
		String[] str = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			str[i] = String.valueOf(numbers[i]);
		Comparator<String> comparator=new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return(o2+o1).compareTo(o1+o2);
			}
		};
		Arrays.sort(str, comparator);
		if(str[0].equals("0")) return "0";
		for (int i = 0; i < str.length; i++)
			answer+=str[i];
		return answer;
        
    
    }
}