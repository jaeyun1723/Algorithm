import java.util.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        Map<String, ArrayList<Music>> map = new HashMap<>();
        Map<String, Integer> musics = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            ArrayList<Music> list;
            if (map.containsKey(genre)) {
                list = map.get(genre);
            } else {
                list = new ArrayList<>();
            }
            list.add(new Music(i, play, genre));
            map.put(genre, list);
            musics.put(genre, musics.getOrDefault(genre, 0) + play);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<String> gen = new ArrayList<>(musics.keySet());
        gen.sort((m1, m2) -> (Integer.compare(musics.get(m2), musics.get(m1))));
        for (String str : gen) {
            ArrayList<Music> list = map.get(str);

            list.sort((m1, m2) -> {
                if (m1.plays == m2.plays) {
                    return Integer.compare(m1.idx, m2.idx);
                }
                return Integer.compare(m2.plays, m1.plays);
            });
            for (int i = 0; i < Math.min(2, list.size()); i++) {
                answer.add(list.get(i).idx);
            }
        }
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }

    public class Music {

        int idx;
        int plays;
        String genre;

        public Music(int idx, int plays, String genre) {
            this.idx = idx;
            this.plays = plays;
            this.genre = genre;
        }
    }

}