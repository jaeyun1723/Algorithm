import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/17143
 */
public class Main {

    static int R, C, totalSize;
    static Shark[][] arr;
    static ArrayList<Point> list;

    static class Shark {

        int speed, direction, size;
        boolean isShark;

        Shark() {
            this.isShark = false;
        }

        Shark(int speed, int direction, int size) {
            this.speed = speed;
            this.direction = direction;
            this.size = size;
            this.isShark = true;
        }

        @Override
        public String toString() {
            return "Shark{" +
                "speed=" + speed +
                ", direction=" + direction +
                ", size=" + size +
                ", isShark=" + isShark +
                '}';
        }
    }

    static Shark[][] copy(Shark[][] shk) {
        Shark[][] tmp = new Shark[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                tmp[i][j] = shk[i][j];
            }
        }
        return tmp;
    }

    static Point up(int r, int speed) {
        boolean turn = false; // 위
        while (speed-- > 0) {
            if ((r == 1 && !turn) || (r == R && turn)) {
                turn = !turn;
            }
            if (!turn) {
                r--;
            } else {
                r++;
            }
        }
        if (turn) {
            return new Point(r, 2); // 아래
        } else {
            return new Point(r, 1); // 위
        }
    }

    static Point down(int r, int speed) {
        boolean turn = false; // 아래
        while (speed-- > 0) {
            if ((r == 1 && turn) || (r == R && !turn)) {
                turn = !turn;
            }
            if (!turn) {
                r++;
            } else {
                r--;
            }
        }
        if (turn) {
            return new Point(r, 1); // 위
        } else {
            return new Point(r, 2); // 아래
        }
    }

    static Point left(int c, int speed) {
        boolean turn = false; // 왼쪽
        while (speed-- > 0) {
            if ((c == 1 && !turn) || (c == C && turn)) {
                turn = !turn;
            }
            if (!turn) {
                c--;
            } else {
                c++;
            }
        }
        if (turn) {
            return new Point(c, 3); // 오른쪽
        } else {
            return new Point(c, 4); // 왼쪽
        }
    }

    static Point right(int c, int speed) {
        boolean turn = false; // 오른쪽
        while (speed-- > 0) {
            if ((c == 1 && turn) || (c == C && !turn)) {
                turn = !turn;
            }
            if (!turn) {
                c++;
            } else {
                c--;
            }
        }
        if (turn) {
            return new Point(c, 4); // 왼쪽
        } else {
            return new Point(c, 3); // 오른쪽
        }
    }

    static void catchShark(int c) {
        for (int i = 1; i <= R; i++) {
            if (arr[i][c].isShark) {
                totalSize += arr[i][c].size;
                list.remove(new Point(i, c));
                arr[i][c] = new Shark();
                return;
            }
        }
    }

    static void moveShark() {
        Shark[][] next = new Shark[R+1][C+1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                next[i][j]=new Shark();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            // 현재 상어 위치
            int r = list.get(i).x, c = list.get(i).y;
            if (r == -1) {
                continue;
            }
            // 다음 위치로 갈 상어 복사
            Shark shark = new Shark(arr[r][c].speed, arr[r][c].direction, arr[r][c].size);
            Point idx = new Point();
            if (shark.direction == 1) {
                idx = up(r, shark.speed); // 이동한 r
                shark.direction = idx.y;
                if (!next[idx.x][c].isShark) {
                    // 상어가 이동한 자리에 상어가 없으면
                    next[idx.x][c] = shark; // shark 배치
                    list.set(i, new Point(idx.x, c)); // i에 새로 셋팅
                } else { // 이미 상어가 존재하면
                    list.set(i, new Point(-1, -1));
                    if (next[idx.x][c].size < shark.size)
                    // 이동한 상어가 더 크면
                    {
                        next[idx.x][c] = shark; // shark 배치
                    }
                }
            }
            else if (shark.direction == 2) {
                idx = down(r, shark.speed); // 이동한 r
                shark.direction = idx.y;
                if (!next[idx.x][c].isShark) {
                    // 상어가 이동한 자리에 상어가 없으면
                    next[idx.x][c] = shark; // shark 배치
                    list.set(i, new Point(idx.x, c)); // i에 새로 셋팅
                } else { // 이미 상어가 존재하면
                    list.set(i, new Point(-1, -1));
                    if (next[idx.x][c].size < shark.size)
                    // 이동한 상어가 더 크면
                    {
                        next[idx.x][c] = shark; // shark 배치
                    }
                }
            }
            else if (shark.direction == 3) {
                idx = right(c, shark.speed); // 이동한 c
                shark.direction = idx.y;
                if (!next[r][idx.x].isShark) {
                    // 상어가 이동한 자리에 상어가 없으면
                    next[r][idx.x] = shark; // shark 배치
                    list.set(i, new Point(r, idx.x)); // i에 새로 셋팅
                } else { // 이미 상어가 존재하면
                    list.set(i, new Point(-1, -1));
                    if (next[r][idx.x].size < shark.size)
                    // 이동한 상어가 더 크면
                    {
                        next[r][idx.x] = shark; // shark 배치
                    }
                }
            }
            else if (shark.direction == 4) {
                idx = left(c, shark.speed); // 이동한 c
                shark.direction = idx.y;
                if (!next[r][idx.x].isShark) {
                    // 상어가 이동한 자리에 상어가 없으면
                    next[r][idx.x] = shark; // shark 배치
                    list.set(i, new Point(r, idx.x)); // i에 새로 셋팅
                } else { // 이미 상어가 존재하면
                    list.set(i, new Point(-1, -1));
                    if (next[r][idx.x].size < shark.size)
                    // 이동한 상어가 더 크면
                    {
                        next[r][idx.x] = shark; // shark 배치
                    }
                }
            }
        }
        arr = copy(next);

    }

    static void fishKing(int c) {
        // 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다.
        // 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
        catchShark(c);
        // 3. 상어가 이동한다.
        moveShark();
        // 상어가 이동을 마친 후에 한 칸에 상어가 두 마리 이상 있을 수 있다.
        // 이때는 크기가 가장 큰 상어가 나머지 상어를 모두 잡아먹는다.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 상어의 수
        list = new ArrayList<>();
        arr = new Shark[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                arr[i][j] = new Shark();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); // 상어의 위치
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken()); // 속력
            int d = Integer.parseInt(st.nextToken()); // 이동 방향
            int z = Integer.parseInt(st.nextToken()); // 크기
            arr[r][c] = new Shark(s, d, z);
            list.add(new Point(r, c));
        }

        for (int i = 0; i < C; i++) {
            fishKing(i + 1); // 1. 낚시왕이 오른쪽으로 한 칸 이동
        }
        System.out.println(totalSize);
    }

}