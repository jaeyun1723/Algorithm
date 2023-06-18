#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
using namespace std;

int main() {
	int N;
	cin >> N;
	string num = to_string(N);
	vector <int> v;
	for (int i = 0; i < num.size(); i++)
	{
		v.push_back((int)num[i]-48);
	}
	sort(v.begin(), v.end(), greater<int>());
	for (int i = 0; i < v.size(); i++)
		cout << v[i];
	cout << '\n';
}