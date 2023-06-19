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

int N, M;
int v[1001][1001];
int visited[1001][1001][2];
queue<pair<pair<int, int>, int> > q;
int X[4] = { 0,-1,0,1 };
int Y[4] = { -1,0,1,0 };

void bfs() {
	q.push({{ 1,1 }, 0});
	visited[1][1][0] = 1;
	while (!q.empty())
	{
		int x = q.front().first.first;
		int y = q.front().first.second;
		int flag = q.front().second;

		for (int i = 0; i < 4; i++)
		{
			int tx = x + X[i];
			int ty = y + Y[i];
			if (tx<1 || ty<1 || tx>N || ty>M) continue;

			if (v[tx][ty] == 0 && visited[tx][ty][flag] == 0)
			{
				q.push({ { tx,ty }, flag });
				visited[tx][ty][flag] = visited[x][y][flag] + 1;
			}
			if (v[tx][ty] == 1 && flag == 0)
			{
				q.push({ { tx,ty }, 1 });
				visited[tx][ty][1] = visited[x][y][flag] + 1;
			}
		}
		q.pop();
	}
}

int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> N >> M;

	for (int i = 1; i <= N; i++)
	{
		string s;
		cin >> s;
		for (int j = 1; j <= M; j++)
			v[i][j] = s[j - 1] - '0';
	}
	bfs();

	if (visited[N][M][0] == 0 && visited[N][M][1] == 0) cout << -1;
	else if (visited[N][M][0] == 0) cout << visited[N][M][1];
	else if (visited[N][M][1] == 0) cout << visited[N][M][0];
	else cout << (int)fmin(visited[N][M][0], visited[N][M][1]);

}
