#include<iostream>
using namespace std;

int main() {
	int k;

	cin >> k;

	for (int i = 0; i < k; i++) {
		for (int j = 0; j < i + 1; j++) {
			cout << "*";
		}
		cout << '\n';
	}
}