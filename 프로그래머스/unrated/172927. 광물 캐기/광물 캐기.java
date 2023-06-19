import java.util.*;

class Solution {
    static int what(int[] picks) {
		for(int i=0;i<3;i++)
			if(picks[i]>0) {
				picks[i]--;
				return i;
			}
		return -1;
	}
    
    public int solution(int[] picks, String[] minerals) {
    			int answer = 0;
		int size = 1;
		// 1. 주어진 곡갱이로 광물을 캘수 있는 양 계산
		for (int i = 0; i < 3; i++)
			size += 5 * picks[i];
		size = Math.min(size, minerals.length);
		// 2. 광물을 모두 돌 곡괭이 기준에 맞는 피로도로 설정
		int[] hard = new int[size];
		for (int i = 0; i < size; i++) {
			if (minerals[i].equals("diamond"))
				hard[i] = 25;
			if (minerals[i].equals("iron"))
				hard[i] = 5;
			if (minerals[i].equals("stone"))
				hard[i] = 1;
		}
		
		// 3. <시작인덱스, 연속된 5개의 피로도 총합>
		//	  을 저장하여 다이아곡괭이를 우선적으로 사용할 섹션 결정(총합 기준 내림차순 이용)
		//    *중요
		Map<Integer, Integer> map = new HashMap<>();
		int qu = -1;
		for (int i = 0; i < hard.length; i++) {
			if (i % 5 == 0) {
				map.put(i, hard[i]);
				qu++;
			} else {
				map.put(5 * qu, map.getOrDefault(5 * qu, 0) + hard[i]);
			}
		}
		List<Integer> list = new ArrayList<>(map.keySet());

		Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));

//		for(int num : hard)
//			System.out.print(num+" ");
//		System.out.println();
//		
//		for(Entry<Integer, Integer> entry : map.entrySet()){
//		    System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
//		}

		for (int idx : list) {
			// 도끼 뭐 쓸지 결정
			int axe = what(picks);
			if (axe == -1)
				break;
			// 도끼 써서 계산
			if (axe == 0) {
				for (int i = idx; i < idx + 5; i++) {
					if (i == hard.length)
						break;
					answer += 1;
				}
			} else if (axe == 1) {
				for (int i = idx; i < idx + 5; i++) {
					if (i == hard.length)
						break;
					if (hard[i] > 5)
						answer += 5;
					else
						answer += 1;
				}
			} else {
				for (int i = idx; i < idx + 5; i++) {
					if (i == hard.length)
						break;
					answer += hard[i];
				}
			}
		}

		
		
			return answer;
    }
}