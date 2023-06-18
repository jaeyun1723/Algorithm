#include<iostream>
#include<cmath>
using namespace std;

int main() 
{
	int x, y, w, h;
	cin >> x >> y >> w >> h;

	cout << fmin(x, fmin(y, fmin(w - x, h - y))) << '\n';
}