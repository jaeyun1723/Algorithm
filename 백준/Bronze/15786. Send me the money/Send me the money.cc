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
	int N, M;
	cin >> N >> M;
	string code;
	cin >> code;
	for (int i = 0; i < M; i++) {
		string cal;
		cin >> cal;
		bool flag = false;
		int idx = 0;
		for (int j = 0; j < cal.size(); j++) {
			if (cal[j] == code[idx]) idx++;
			if (idx == N) {
				cout << "true\n";
				flag = true;
				break;
			}
		}
		if(!flag) cout << "false\n";
	}
}