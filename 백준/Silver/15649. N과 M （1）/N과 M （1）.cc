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

void permutation(int n) {
	if (n == slt) {
		for (auto it : v)
			cout << it << " ";
		cout << '\n';
		return;
	}
	for (int i = 1; i <= N; i++) {
		if (!visited[i]){
			v.push_back(i);
			visited[i] = true;
			permutation(n + 1);
			visited[i] = false;
			v.pop_back();
		}
	}
}

int main() {
	cin >> N >> slt;
	visited.resize(N + 1, false);
	permutation(0);
}