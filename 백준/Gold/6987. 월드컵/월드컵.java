import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static class Info {
		int win;
		int draw;
		int lose;

		public Info() {
		}

		public Info(int win, int draw, int lose) {
			this.win = win;
			this.draw = draw;
			this.lose = lose;
		}
	}

	static Info[] nation, candidate;
	static boolean flag;
	static int[] team1 = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
	static int[] team2 = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };

	// 0 1 0 2 0 3 0 4 0 5
	// 1 2 1 3 1 4 1 5
	// 2 3 2 3 2 4 2 5
	// 3 4 3 5
	// 4 5
	static boolean isAvailable(int cnt) {
		if (cnt == 15)
			return true;

		// team1이 이기는 경우
		if (nation[team1[cnt]].win > 0 && nation[team2[cnt]].lose > 0) {
			nation[team1[cnt]].win--;
			nation[team2[cnt]].lose--;
			if (isAvailable(cnt + 1))
				return true;
			nation[team1[cnt]].win++;
			nation[team2[cnt]].lose++;
		}

		// team1이 비기는 경우
		if (nation[team1[cnt]].draw > 0 && nation[team2[cnt]].draw > 0) {
			nation[team1[cnt]].draw--;
			nation[team2[cnt]].draw--;
			if (isAvailable(cnt + 1))
				return true;
			nation[team1[cnt]].draw++;
			nation[team2[cnt]].draw++;
		}

		// team1이 지는 경우
		if (nation[team1[cnt]].lose > 0 && nation[team2[cnt]].win > 0) {
			nation[team1[cnt]].lose--;
			nation[team2[cnt]].win--;
			if (isAvailable(cnt + 1))
				return true;
			nation[team1[cnt]].lose++;
			nation[team2[cnt]].win++;
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine());
			flag = false;
			int total = 0;
			nation = new Info[6];
			int drawSize = 0;
			for (int i = 0; i < 6; i++) {
				nation[i] = new Info();
				nation[i].win = Integer.parseInt(st.nextToken());
				nation[i].draw = Integer.parseInt(st.nextToken());
				nation[i].lose = Integer.parseInt(st.nextToken());
				total += nation[i].win + nation[i].draw + nation[i].lose;
			}
			if (total != 30) {
				System.out.print(0 + " ");
				continue;
			}
			if (isAvailable(0))
				System.out.print(1 + " ");
			else
				System.out.print(0 + " ");

		}

	}//

}//