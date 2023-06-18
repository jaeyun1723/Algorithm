#include<iostream>
using namespace std;

int main() {
	int a, b;
	int i = 0;
	cin >> a;
	b = a;
	while (1) {
		b = b % 10 * 10 + (b / 10 + b % 10) % 10;
		i++;
		if (a == b)
			break;
	}
	cout << i << endl;
}