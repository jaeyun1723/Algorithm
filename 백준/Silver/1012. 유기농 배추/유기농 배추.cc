#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<stack>
#include<queue>
#include<map>
#include<deque>
using namespace std;

int T, M, N, K;
int v[51][51];
bool visited[51][51];

void clear() {
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
		{
			v[i][j] = 0;
			visited[i][j] = 0;
		}
}

int dfs(int x, int y)
{
	if (x < 0 || y < 0 || x >= N || y >= M)
		return 0;
	if (v[x][y] == 0 || visited[x][y] == true)
		return 0;
	else
	{
		visited[x][y] = true;
		return dfs(x + 1, y) + dfs(x - 1, y) + dfs(x, y - 1) + dfs(x, y + 1);
	}
}

int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> T;
	while (T--)
	{
		cin >> M >> N >> K; // M:열 N:행
		while (K--)
		{
			int n1, n2;
			cin >> n1 >> n2;
			v[n2][n1] = 1;
		}
		int cnt = 0;
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if (v[i][j] == 1 && visited[i][j] == false)
				{
					cnt++;
					dfs(i, j);
				}
		cout << cnt << '\n';
		clear();
	}
}