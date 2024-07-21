import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*

문제
도현이는 우주의 신이다.
이제 도현이는 아무렇게나 널브러져 있는 n개의 별들을 이어서 별자리를 하나 만들 것이다. 별자리의 조건은 다음과 같다.

별자리를 이루는 선은 서로 다른 두 별을 일직선으로 이은 형태이다.
모든 별들은 별자리 위의 선을 통해 서로 직/간접적으로 이어져 있어야 한다.
별들이 2차원 평면 위에 놓여 있다
선을 하나 이을 때마다 두 별 사이의 거리만큼의 비용이 든다고 할 때, 별자리를 만드는 최소 비용을 구하시오.

입력
첫째 줄에 별의 개수 n이 주어진다. (1 ≤ n ≤ 100)

둘째 줄부터 n개의 줄에 걸쳐 각 별의 x, y좌표가 실수 형태로 주어지며, 최대 소수점 둘째자리까지 주어진다.
좌표는 1000을 넘지 않는 양의 실수이다.

3
1.0 1.0
2.0 2.0
2.0 4.0

출력
첫째 줄에 정답을 출력한다. 절대/상대 오차는 10-2까지 허용한다.

3.41

 */
class Main {

    static double[][] stars;
    static int[] parent;

    public static double getDistance(int v1, int v2) {
        double xDis = Math.pow(stars[v1][0] - stars[v2][0], 2);
        double yDis = Math.pow(stars[v1][1] - stars[v2][1], 2);
        return Math.sqrt(xDis + yDis);
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    public static void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if (p1 != p2) {
            if (p1 < p2) {
                parent[p1] = p2;
            } else {
                parent[p2] = p1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        stars = new double[N][2];
        parent = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
            parent[i] = i;
        }

        ArrayList<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                edgeList.add(new Edge(i, j, getDistance(i, j)));
            }
        }

        Collections.sort(edgeList, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Double.compare(o1.cost, o2.cost);
            }
        });

        int cnt = 0;
        double ans = 0;

        for (int i = 0; i < edgeList.size(); i++) {
            Edge e = edgeList.get(i);
            if (find(e.from) != find(e.to)) {
                union(e.from, e.to);
                ans += e.cost;
                cnt++;
            }
            if (cnt == N - 1) {
                break;
            }
        }

        System.out.println(Math.floor(ans * 100) / 100);
    }

    public static class Edge {

        int from;
        int to;
        double cost;

        public Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

    }
}