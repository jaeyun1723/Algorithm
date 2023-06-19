import java.util.*;

class Solution {
   
  public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		ArrayList<String> cache = new ArrayList<String>();
		if (cacheSize == 0 || cacheSize >= cities.length)
			answer = 5 * cities.length;
		else {
			for (int i = 0; i < cities.length; i++) {
				String name = cities[i].toLowerCase();
				if (cache.contains(name)) {
					answer++;
					cache.remove(name);
				} else {
					answer += 5;
					if (cache.size() == cacheSize)
						cache.remove(0);
				}
				cache.add(name);
			}
		}
		return answer;
	}

}