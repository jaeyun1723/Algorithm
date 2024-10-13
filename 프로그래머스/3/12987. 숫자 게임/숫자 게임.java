import java.util.*;
import java.util.stream.*;

class Solution {

    public int binarySearch(int num, List<Integer> arr) {
        int idx = -1;
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) > num) {
                idx = mid;
                right = mid - 1;
            } else { // arr[mid]<=num
                left = mid + 1;
            }
        }
        return idx;
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(B);
        List<Integer> list = Arrays.stream(B).boxed().collect(Collectors.toList());
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            int idx = binarySearch(num, list);
            if (idx == -1) {
                continue;
            }
            list.remove(idx);
            answer++;
        }
        return answer;
    }
}