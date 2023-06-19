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

typedef long long ll;

vector<ll> segment;
vector<ll> arr;
int N, M, K;
//1번째 인덱스 = root
ll init(ll node, ll left, ll right) {
   if (left == right) return segment[node] = arr[left];
   ll mid = (left + right) / 2;
   segment[node] = init(node * 2, left, mid) + init(node * 2 + 1, mid + 1, right);
   return segment[node];
}

ll query(ll node, ll start, ll end, ll left, ll right) {
   if (left > end || right < start) return 0;
   if (left <= start && end <= right) return segment[node];
   int mid = (start + end) / 2;
   return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
}

//ll update(int node, int start, int end, int idx, int diff) {
//   if (idx<start || idx>end) return 0;
//   segment[node] = segment[node] + diff;
//   if (start != end) {
//      int mid = (start + end) / 2;
//      update(node * 2, start, mid, idx, diff);
//      update(node * 2 + 1, mid + 1, end, idx, diff);
//   }
//}

void update_value(ll node, ll start, ll end, ll idx, ll value) {
   if (idx<start || idx>end) return;
   if (start == end) {
      segment[node] = value;
      return;
   }
   ll mid = (start + end) / 2;
   update_value(node * 2, start, mid, idx, value);
   update_value(node * 2 + 1, mid + 1, end, idx, value);
   segment[node] = segment[node * 2] + segment[node * 2 + 1];

}
int main() {
   ios_base::sync_with_stdio(0);
   cin.tie(0);
   cin >> N >> M >> K;
   arr.resize(N);
   for (int i = 0; i < N; i++) cin >> arr[i];
   int height = (int)ceil(log2(N));
   ll tree_size = (1 << (height + 1));
   segment.resize(tree_size);
   init(1, 0, N - 1);   // root번호=1;
   for (int i = 0; i < M + K; i++) {
      ll a, b, c;
      cin >> a >> b >> c;
      if (a == 1)
         update_value(1, 0, N - 1, b - 1, c);
      else
         cout << query(1, 0, N - 1, b - 1, c - 1) << "\n";
   }
}