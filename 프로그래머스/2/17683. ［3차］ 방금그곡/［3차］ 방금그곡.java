import java.util.*;

class Solution {

    public static int playTime(String s, String e) {
        int start = Integer.parseInt(s.split(":")[0]) * 60 + Integer.parseInt(s.split(":")[1]);
        int end = Integer.parseInt(e.split(":")[0]) * 60 + Integer.parseInt(e.split(":")[1]);
        return end - start;
    }

    public static String replaceMusic(String music) {
        music = music.replace("C#", "H")
                .replace("D#", "I")
                .replace("F#", "J")
                .replace("G#", "K")
                .replace("A#", "L")
                .replace("B#", "M");
        return music;
    }

    public static String fullCode(String music, int time) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < time; i++)
            sb.append(music.charAt(i % music.length()));
        return sb.toString();
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int pTime = -1;
        m = replaceMusic(m);
        for (int i = 0; i < musicinfos.length; i++) {
            String[] music = musicinfos[i].split(",");
            int time = playTime(music[0], music[1]);
            String musicInfo = replaceMusic(music[3]); // 음악 코드 치환
            String musicCode = fullCode(musicInfo, time);
            if (musicCode.contains(m) && pTime < time) {
                answer = music[2];
                pTime = time;
            }
        }
        return pTime == -1 ? "(None)" : answer;
    }


}