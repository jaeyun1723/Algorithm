import java.util.*;

class Solution {


    public static void addList(String str, ArrayList<String> list) {
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if (c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') {
                list.add(str.substring(i, i + 2));
            }
        }
    }

    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();
        addList(s1, list1);
        addList(s2, list2);
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        for (String str : list1) {
            if (list2.contains(str)) {
                intersection.add(str);
                list2.remove(str);
            }
            union.add(str);
        }
        int common = intersection.size();
        double sum = union.size() + list2.size();
        if (sum == 0) {
            return 65536;
        }
        return (int) (common / sum * 65536);
    }
}