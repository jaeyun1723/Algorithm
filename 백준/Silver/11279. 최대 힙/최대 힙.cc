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

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	priority_queue <int, vector<int>, less<int> > pq;
	int N;
	cin >> N;
	while (N--)
	{
		int num;
		cin >> num;
		if (num == 0)
		{
			if (pq.empty())
				cout << 0 << '\n';
			else
			{
				cout <<  pq.top() << '\n';
				pq.pop();
			}
		}
		else
			pq.push(num);
	}
}