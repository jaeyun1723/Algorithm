#include<iostream>
using namespace std;
#include<string>

//11720번

int main() {
	int n;
	cin >> n;
	string k;
	cin >> k;
	int sum = 0;
	for (int i = 0; i < n; i++) {
		sum += k.at(i)-'0';
	}
	cout << sum << '\n';
}