#include<iostream>
using namespace std;

int main() {
	int n, x, i;
	int a[10000] = { 0 };

	cin >> n >> x;

	for (i = 0; i < n; i++) {
		cin >> a[i];
	}
	for (i = 0; i < n; i++) {
		if (a[i] < x)
			cout << a[i] << " ";
	}

}