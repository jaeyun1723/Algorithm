#include <iostream>
#include<iomanip>
using namespace std;

int main() {
	int n;

	cin >> n;
	
	int* p = new int[n];
	
	for (int i = 0; i < n; i++) {
		cin >> p[i];
	}

	int max = p[0];

	for (int i = 0; i < n-1; i++) {
		if (max < p[i + 1]) max = p[i + 1];
	}

	double tot = 0;
	for (int i = 0; i < n; i++) {
		tot += double(p[i]) / max * 100;
	}
	cout << fixed << setprecision(2);
	cout << tot / n << "\n";

	delete[]p;

}