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
	int N, M;
	cin >> N >> M;
	deque <int> dq;
	for (int i = 1; i <= N; i++)
		dq.push_back(i);
	int cnt = 0;
	while (M--)
	{
		int num;
		cin >> num;
		int idx = -1;
		for (int i = 0; i < dq.size(); i++)
			if (dq[i] == num)
				idx = i;
		int ele;
		if (idx >= (dq.size() + 1) / 2)	// idx+1 : 몇번째
		{
			int src = dq.size() - idx;
			while (src--)
			{
				ele = dq.back();
				dq.pop_back();
				dq.push_front(ele);
				cnt++;
			}
			dq.pop_front();
		}
		else
		{
			while (idx--)
			{
				ele = dq.front();
				dq.pop_front();
				cnt++;
				dq.push_back(ele);
			}
			dq.pop_front();
		}
	}
	cout << cnt << '\n';
}