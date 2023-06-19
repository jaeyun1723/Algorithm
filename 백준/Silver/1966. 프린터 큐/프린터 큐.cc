#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<stack>
#include<queue>
#include<map>
using namespace std;

int main() {
	int T;
	cin >> T;
	vector <int> v;
	while (T--)
	{
		queue < pair<int, int> >* q = new queue< pair<int, int> >;
		int N, M;
		cin >> N >> M;
		for (int i = 0; i < N; i++)
		{
			int prior;
			cin >> prior;
			q->push(make_pair(prior, i));
			v.push_back(prior);
		}
		sort(v.begin(), v.end(), greater<int>());
		pair<int, int> src;
		int cnt = 0;
		int i = 0;
		while (1)
		{
			while (v[i] != q->front().first)
			{
				src = q->front();
				q->pop();
				q->push(src);
			}
			if (q->front().second == M)
			{
				cout << cnt + 1 << '\n';
				break;
			}
			else
			{
				q->pop();
				cnt++;
				i++;
			}
		}
		v.clear();
		delete q;
	}
}