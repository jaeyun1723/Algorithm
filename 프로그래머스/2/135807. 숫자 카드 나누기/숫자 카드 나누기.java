import java.util.*;

class Solution {

  public static int gcd(int a, int b) {
    if (a % b == 0) {
      return b;
    }
    return gcd(b, a % b);
  }

  public static int conidtion(int[] arr1, int[] arr2) {
    Arrays.sort(arr1);
    int result = arr1[0];
    for (int i = 1; i < arr1.length; i++) {
      result = gcd(result, arr1[i]);
    }
    for (int i = 0; i < arr2.length; i++) {
      if (arr2[i] % result == 0) {
        return 0;
      }
    }
    return result;
  }

  public int solution(int[] arrayA, int[] arrayB) {
    return Math.max(conidtion(arrayA, arrayB), conidtion(arrayB, arrayA));
  }
}