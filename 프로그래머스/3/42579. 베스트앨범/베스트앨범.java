import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        for (int i = 0; i < map.size(); i++) {
            String genre = list.get(i);
            Map<Integer, Integer> music = new HashMap<>();
            for (int j = 0; j < genres.length; j++) {
                if (genre.equals(genres[j])) {
                    music.put(j, plays[j]);
                }
            }
            List<Integer> mlist = new ArrayList<>(music.keySet());
            mlist.sort(new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    if (Objects.equals(music.get(o1), music.get(o2)))
                        return o1 - o2;
                    return music.get(o2) - music.get(o1);
                }
            });
            answer.add(mlist.get(0));
            if (mlist.size() > 1)
                 answer.add(mlist.get(1));
        }
        int[] result=new int[answer.size()];
        for(int i=0;i<result.length;i++){
            result[i]=answer.get(i);
        }
        return result;
    }
}