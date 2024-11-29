import java.util.*;

class Solution {
    public static int maxSheep;
    public static ArrayList<Integer>[] edgeList;

    public static void dfs(int node, int[] info, int sheep, int wolf, ArrayList<Integer> lastNode) {
        if (info[node] == 0)
            sheep++;
        else
            wolf++;
        if (sheep <= wolf) return;
        maxSheep = Math.max(maxSheep, sheep);

        ArrayList<Integer> newLastNode = new ArrayList<>(lastNode);
        for (int i = 0; i < edgeList[node].size(); i++) {
            newLastNode.add(edgeList[node].get(i));
        }
        newLastNode.remove((Integer) node);

        for (int next : newLastNode) {
            dfs(next, info, sheep, wolf, newLastNode);
        }
    }

    public int solution(int[] info, int[][] edges) {
        edgeList = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            edgeList[edges[i][0]].add(edges[i][1]);
        }

        dfs(0, info, 0, 0, new ArrayList<>());
        return maxSheep;
    }
}