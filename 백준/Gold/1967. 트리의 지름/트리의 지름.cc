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

#define MAX 10001

vector<pair<int, int>> tr[MAX];
bool visited[MAX];
int dist[MAX];
queue<int> q;

void bfs(int idx) {
	visited[idx] = true;
	q.push(idx);
	while (!q.empty()) {
		int node = q.front();
		q.pop();
		for (int i = 0; i < tr[node].size(); i++) {
			int next = tr[node][i].first;
			if (!visited[next]) {
				visited[next] = true;
				dist[next] = dist[node] + tr[node][i].second;
				q.push(next);
			}
		}
	}
}

int main() {
	int n;
	cin >> n;
	for (int i = 1; i < n; i++) {
		int par, chi, eg;
		cin >> par >> chi >> eg;
		tr[par].push_back({ chi,eg });
		tr[chi].push_back({ par,eg });
	}

	bfs(1);
	int start = 1;
	for (int i = 2; i <= n; i++)
		if (dist[i] > dist[start]) start = i;

	memset(visited, false, sizeof(visited));
	memset(dist, 0, sizeof(dist));

	bfs(start);

	int max = 0;
	for (int i = 1; i <= n; i++)
		if (dist[i] > max) max = dist[i];
	cout << max << '\n';
}
