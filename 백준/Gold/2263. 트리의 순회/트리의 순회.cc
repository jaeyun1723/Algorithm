#include<iostream>
#include<string>
#include<cstring>
#include<vector>
#include<cmath>
#include<cstring>
#include<algorithm>
#include<stack>
#include<queue>
#include<map>
#include<deque>
#include<bitset>
using namespace std;

int N;
int idx[100001];
int inorder[100001];
int postorder[100001];

// postorder는 root 찾음
// inorder는 왼쪽 노드, 오른쪽 노드 찾음
void preorder(int ins, int ine, int posts, int poste) {
	if (ins > ine || posts > poste)
		return;
	int rootidx = idx[postorder[poste]];	// inorder에서 root가 있는 idx값
	int left = rootidx - ins;
	int right = ine - rootidx;
	cout << inorder[rootidx] << " ";

	preorder(ins, rootidx - 1, posts, posts + left - 1);
	preorder(rootidx + 1, ine, posts + left, poste - 1);
}

int main() {
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> inorder[i];
		idx[inorder[i]] = i;	// inorder 요소들의 index 정보 저장 
	}
	for (int i = 1; i <= N; i++)
		cin >> postorder[i];

	preorder(1, N, 1, N);
}