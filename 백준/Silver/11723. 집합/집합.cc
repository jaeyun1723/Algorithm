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

typedef long long ll;
int T;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> T;
	int num = 0;
	while (T--) {
		string s;
		cin >> s;
		if (s == "add") {
			int x;
			cin >> x;
			num |= (1 << x);
		}
		else if (s == "check") {
			int x;
			cin >> x;
			if (num & (1 << x)) cout << 1 << '\n';
			else cout << 0 << '\n';
		}
		else if (s == "remove") {
			int x;
			cin >> x;
			num &= ~(1 << x);
		}
		else if (s == "toggle") {
			int x;
			cin >> x;
			num ^= (1 << x);
		}
		else if (s == "all")
			num = (1 << 21) - 1;
		else if (s == "empty")
			num = 0;
	}
}