#include<iostream>
#include<vector>
#include<string>
#include<queue>
using namespace std;

int matrix[1000][1000];

class graph {
public:
	int* visited;
	int size;

	graph(int n)
	{
		visited = new int[n + 1];
		for (int i = 0; i <= n; i++)
		{
			visited[i] = 0;
		}
		size = n;
	}

	void InsertEdge(int n1, int n2)
	{
		matrix[n1][n2] = 1;
		matrix[n2][n1] = 1;
	}

	void DFS(int n)
	{
		if (visited[n] == 1)
			return;
		else
		{
			cout << n << " ";
			visited[n] = 1;
			for (int i = 1; i <= size; i++)
			{
				if (matrix[n][i] == 1)
					DFS(i);
			}
		}
	}

	void Reset()
	{
		for (int i = 1; i <= size; i++)
		{
			visited[i] = 0;
		}
	}
	queue<int> q;

	void BFS(int n)
	{
		q.push(n);
		while (!q.empty())
		{
			cout << q.front() << " ";
			for (int i = 1; i <= size; i++)
			{
				if (matrix[q.front()][i] == 1 && visited[i] == 0)
				{
					q.push(i);
					visited[i] = 1;
				}
			}
			visited[q.front()] = 1;
			q.pop();
		}
		cout << '\n';
	}

};

int main() {
	int a, b, c;
	cin >> a >> b >> c;
	graph g(a);
	for (int i = 0; i < b; i++)
	{
		int n1, n2;
		cin >> n1 >> n2;
		g.InsertEdge(n1, n2);
	}
	g.DFS(c);
	cout << '\n';
	g.Reset();
	g.BFS(c);
}