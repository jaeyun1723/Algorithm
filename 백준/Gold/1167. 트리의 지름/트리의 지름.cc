#include<iostream>
#include<string>
#include<cstring>
#include<vector>
#include<cmath>
#include<cstring>
#include<algorithm>
#include<stack>
#include<queue>
#include<map>
#include<deque>
#include<bitset>
using namespace std;

#define MAX 100001

bool visited[MAX];
vector<pair<int, int>> tr[MAX];
int N, dist[MAX];
queue<int> q;
// 트리라 1부터 무조건 함, 1엔 다 이어져있으니까
void bfs(int idx) {
	q.push(idx);
	visited[idx] = true;
	while (!q.empty()) {
		int node = q.front();
		q.pop();
		for (int i = 0; i < tr[node].size(); i++) {
			int next = tr[node][i].first;
			if (!visited[next]) {
				dist[next] = dist[node] + tr[node][i].second;
				visited[next] = true;
				q.push(next);
			}
		}
	}
}

int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		int v1, v2, e;
		cin >> v1;
		while (cin >> v2) {
			if (v2 == -1) break;
			cin >> e;
			tr[v1].push_back({ v2,e });
		}
	}
	bfs(1);

	int max = 1;
	for (int i = 2; i <= N; i++)
		if (dist[i] > dist[max]) max = i;

	memset(visited, false, sizeof(visited));
	memset(dist, 0, sizeof(dist));

	bfs(max);

	max = 0;
	for (int i = 1; i <= N; i++)
		if (max < dist[i]) max = dist[i];

	cout << max << '\n';

}