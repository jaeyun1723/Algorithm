import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    static int m;
    static ArrayList<ArrayList<Player>> rooms = new ArrayList<>();

    public static int enterRoom(Player p) {
        if (rooms.isEmpty()) return -1;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).size() >= m) continue;
            Player owner = rooms.get(i).get(0);
            if (owner.level - 10 <= p.level && owner.level + 10 >= p.level) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Player[] list = new Player[P];

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            list[i] = new Player(l, n);
        }
        
        for (int i = 0; i < list.length; i++) {
            int roomNum = enterRoom(list[i]);
            if (roomNum == -1) {
                ArrayList<Player> newRoom = new ArrayList<>();
                newRoom.add(list[i]);
                rooms.add(newRoom);
            } else {
                rooms.get(roomNum).add(list[i]);
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).size() == m) {
                System.out.println("Started!");
            } else
                System.out.println("Waiting!");
            ArrayList<Player> room = rooms.get(i);
            room.sort((o1, o2) -> o1.nickname.compareTo(o2.nickname));
            for (Player p : room)
                System.out.println(p.toString());

        }
    }

    public static class Player {
        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return this.level + " " + this.nickname;
        }
    }


}