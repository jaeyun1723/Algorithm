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

#define MAX 501

int n, m;
vector<int> tr[MAX];
bool visited[MAX];

bool istree(int vt, int before) {
	visited[vt] = true;
	for (int i = 0; i < tr[vt].size(); i++) {
		int next = tr[vt][i];
		if (next == before) continue;
		if (visited[next]) return false;
		if (!istree(next, vt)) return false;
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);
	int cnt = 1;
	while (cin >> n >> m) {
		if (m == 0 && n == 0) return 0;

		for (int i = 1; i <= n; i++) tr[i].clear();
		memset(visited, false, sizeof(visited));

		for (int i = 1; i <= m; i++) {
			int v1, v2;
			cin >> v1 >> v2;
			tr[v1].push_back(v2);
			tr[v2].push_back(v1);
		}
		int res = 0;
		
		for (int i = 1; i <= n; i++) {
			if (!visited[i])
				if (istree(i, 0)) res++;
		}
		cout << "Case " << cnt++;
		if (res == 0) cout << ": No trees.";
		else if (res == 1) cout << ": There is one tree.";
		else
			cout << ": A forest of " << res << " trees.";
		cout << '\n';
	}
}