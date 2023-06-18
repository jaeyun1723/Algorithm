#include<iostream>
using namespace std;
#include<string>


int main() {
	int n;
	cin >> n;
	int cnt = n;

	for (int i = 0; i < n; i++) {
		string k;
		cin >> k;
		int check[101] = { 0, };
		for (int j = 1; j < k.size(); j++) {
			if (k.at(j - 1) != k.at(j) && check[k.at(j) - 97] == 1)
			{
				cnt--;
				break;
			}
				check[k.at(j - 1) - 97] = 1;
		}
	}
	cout << cnt;
}
