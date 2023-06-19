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
	int N;
	cin >> N;

	int cnt;
	int cnt2 = 0;
	int cnt5 = 0;
	for (int i = 2; i <= N; i++)
	{
		cnt = i;
		while (cnt % 2 == 0)
		{
			cnt2++;
			cnt /= 2;
		}
		while (cnt % 5 == 0)
		{
			cnt5++;
			cnt /= 5;
		}
	}

	cout << (int)fmin(cnt2, cnt5) << '\n';
}