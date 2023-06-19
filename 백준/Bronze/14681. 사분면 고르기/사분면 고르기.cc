#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<stack>
#include<queue>
#include<map>
#include<deque>
#include<list>
using namespace std;


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	int x, y;
	cin >> x >> y;
	if (x > 0) {
		if (y > 0) cout << 1 << '\n';
		else
			cout << 4 << '\n';
	}
	else {
		if (y > 0) cout << 2 << '\n';
		else
			cout << 3 << '\n';
	}
}