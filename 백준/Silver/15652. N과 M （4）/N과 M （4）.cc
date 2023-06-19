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

int N, slt;
vector<int> v;
vector<bool> visited;

void permutation(int n, int idx) {
	if (n == slt) {
		for (auto it : v)
			cout << it << " ";
		cout << '\n';
		return;
	}
	for (int i = idx; i <= N; i++) {
			v.push_back(i);
			permutation(n + 1, i);
			v.pop_back();
	}
}

int main() {
	cin >> N >> slt;
	visited.resize(N + 1, false);
	permutation(0, 1);
}