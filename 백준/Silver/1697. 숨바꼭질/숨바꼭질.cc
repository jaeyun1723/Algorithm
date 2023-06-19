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

int N, K;
int visited[100001];

queue<int> q;

int bfs()
{
	int sec;
	visited[N] = 1;
	q.push(N);
	while (!q.empty())
	{
		int x = q.front();
		int tx[3];
		tx[0] = x - 1;
		tx[1] = x + 1;
		tx[2] = 2 * x;		
		for (int i = 0; i < 3; i++)
		{
			if (tx[i] < 0 || tx[i]>100000) continue;
			if (visited[tx[i]] == 0)
			{
				q.push(tx[i]);
				visited[tx[i]] = visited[x] + 1;
			}
			if (tx[i] == K)
				return visited[tx[i]];
		}
		q.pop();
	}
}

int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> N >> K;
	int time = bfs();
	cout << time - 1 << '\n';
	
}