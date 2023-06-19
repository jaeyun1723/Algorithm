#include<iostream>
#include<string>
#include<cstring>
#include<vector>
#include<cmath>
#include<cstring>
#include<algorithm>
#include<stack>
#include<queue>
#include<map>
#include<deque>
#include<bitset>
using namespace std;

int K, N;
long long Start, End, Max, lan[10001];

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> K >> N;
	Start = End = 1;
	for (int i = 0; i < K; i++) {
		cin >> lan[i];
		End = (lan[i] > End) ? lan[i] : End;
	}
	
	while (Start <= End) {
		long long mid = (Start + End) / 2;
		int res = 0;
		for (int i = 0; i < K; i++)
			res += lan[i] / mid;
		if (res >= N) {
			Start = mid + 1;
			Max = (mid > Max) ? mid : Max;
		}
		else
			End = mid - 1;
	}

	cout << Max << '\n';
}