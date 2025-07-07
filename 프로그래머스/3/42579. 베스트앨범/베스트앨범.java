import java.lang.reflect.Array;
import java.util.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, ArrayList<Music>> map = new HashMap<>();
        Map<String, Integer> tot = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            tot.put(genres[i], tot.getOrDefault(genres[i], 0) + plays[i]);
            if (map.containsKey(genres[i])) {
                ArrayList<Music> m = map.get(genres[i]);
                m.add(new Music(i, plays[i]));
            } else {
                ArrayList<Music> m = new ArrayList<>();
                m.add(new Music(i, plays[i]));
                map.put(genres[i], m);
            }
        }

        List<String> genre = new ArrayList<>(tot.keySet());
        genre.sort((o1, o2) -> Integer.compare(tot.get(o2), tot.get(o1)));

        for (String g : genre) {
            ArrayList<Music> list = map.get(g);
            list.sort(null);
            for (int i = 0; i < Math.min(2, list.size()); i++) {
                answer.add(list.get(i).idx);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static class Music implements Comparable<Music> {

        int idx;
        int plays;

        public Music(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }

        @Override
        public int compareTo(Music m) {
            if (this.plays == m.plays) {
                return Integer.compare(this.idx, m.idx);
            }
            return Integer.compare(m.plays, this.plays);
        }
    }

}