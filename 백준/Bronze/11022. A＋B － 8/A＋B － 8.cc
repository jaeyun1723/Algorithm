#include<iostream>
using namespace std;

int main() {

	int k, i;
	cin >> k;
	for (i = 0; i < k; i++) {
		int a, b;
		cin >> a >> b;
		cout << "Case #" << i + 1 << ": "<< a<< " + " << b << " = " <<a + b << endl;
	}
}