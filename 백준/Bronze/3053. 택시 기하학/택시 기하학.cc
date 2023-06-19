#include<iostream>
#include<string>
#include<vector>
#include<cmath>
using namespace std;

int main() {
	int R;
	cin >> R;
	double PI = 3.141592653589793238462643383279502884197169399;


	cout << fixed;
	cout.precision(6);
	cout << pow(R,2) * PI << '\n';
	cout << pow(R,2)*2 << '\n';
}