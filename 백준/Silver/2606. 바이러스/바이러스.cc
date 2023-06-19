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


int arr[101][101];
bool visited[101];
queue <int> q;
int n, m;

void bfs()
{
	q.push(1);
	visited[1] = true;
	while (!q.empty())
	{
		for (int i = 1; i <= n; i++)
		{

			if (arr[q.front()][i] == 1 && visited[i] == false)
			{
				q.push(i);
				visited[i] = true;
			}
		}
		visited[q.front()] = true;
		q.pop();
	}
}

int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> n >> m;

	while (m--)
	{
		int n1, n2;
		cin >> n1 >> n2;
		arr[n1][n2] = 1;
		arr[n2][n1] = 1;
	}
	bfs();
	int cnt = 0;

	for (int i = 2; i <= n; i++)
		if (visited[i] == true)
			cnt++;
	cout << cnt << '\n';

}