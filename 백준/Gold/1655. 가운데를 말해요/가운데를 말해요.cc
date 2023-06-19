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
	cout.tie(NULL);
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int N;
	cin >> N;
	priority_queue <int, vector<int>, greater<int> > MinQ;
	priority_queue <int, vector<int>, less<int> > MaxQ;
	int mid = 11111;
	while (N--)
	{
		int num;
		cin >> num;
		if (mid == 11111)
			mid = num;
		else
		{
			if (mid < num)
				MinQ.push(num);
			else
				MaxQ.push(num);

			if ((int)MinQ.size() - (int)MaxQ.size() >= 2)
			{
				MaxQ.push(mid);
				mid = MinQ.top();
				MinQ.pop();
			}

			if ((int)MaxQ.size() - (int)MinQ.size() >= 2)
			{
				MinQ.push(mid);
				mid = MaxQ.top();
				MaxQ.pop();
			}

			if ((int)MaxQ.size() > (int)MinQ.size() && MaxQ.top() < mid)
			{
				MinQ.push(mid);
				mid = MaxQ.top();
				MaxQ.pop();
			}
		}
		cout << mid << '\n';
	}
}