import java.util.*;

class Solution {
    static class Element {
		int node;
		int length;

		Element(int node, int length) {
			this.node = node;
			this.length = length;
		}
	}

    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer>[] info=new ArrayList[n+1];
        Deque<Element> queue= new ArrayDeque<>();
       		for (int i = 0; i < info.length; i++)
			info[i] = new ArrayList<>();
		for (int i = 0; i < edge.length; i++) {
			info[edge[i][0]].add(edge[i][1]);
			info[edge[i][1]].add(edge[i][0]);
		}
		queue.addFirst(new Element(1, 0));
		int[] len = new int[n + 1];
		len[1] = -1;
		int max = 0;
		while (!queue.isEmpty()) {
			Element element = queue.pollFirst();
			max = Math.max(max, element.length);
			for (int i = 0; i < info[element.node].size(); i++) {
				if (len[info[element.node].get(i)] == 0) {
					len[info[element.node].get(i)] = element.length + 1;
					queue.addLast(new Element(info[element.node].get(i), element.length + 1));
				}
			}
		}
		for (int i = 0; i < len.length; i++)
			if (len[i] == max)
				answer++;

        return answer;
    }
}