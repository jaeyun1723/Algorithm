class Solution {

    static int[] rate = {10, 20, 30, 40};
    static int[] emoticonPlus = {0, 0};

    public static void discounts(int[] discount, int idx, int[][] users, int[] emoticons) {
        if (idx == discount.length) {
            int member = 0;
            int sales = 0;
            for (int[] user : users) {
                int total = 0;
                for (int i = 0; i < discount.length; i++) {
                    if (user[0] <= discount[i]) {
                        total += emoticons[i] / 100 * (100 - discount[i]);
                    }
                }
                if (user[1] <= total) {
                    member++;
                } else {
                    sales += total;
                }
            }
            if ((emoticonPlus[0] < member) || (emoticonPlus[0] == member
                && emoticonPlus[1] < sales)) {
                emoticonPlus[0] = member;
                emoticonPlus[1] = sales;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            discount[idx] = rate[i];
            discounts(discount, idx + 1, users, emoticons);
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        discounts(new int[emoticons.length], 0, users, emoticons);
        return emoticonPlus;
    }
}