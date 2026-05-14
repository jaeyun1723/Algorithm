class Solution {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {
            String filtered = tree.replaceAll("[^" + skill + "]", "");
            if (skill.indexOf(filtered) == 0) {
                answer++;
            }
        }

        return answer;
    }
}