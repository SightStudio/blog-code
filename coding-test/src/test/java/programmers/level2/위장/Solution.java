package programmers.level2.위장;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 문제 링크
 *
 * 레벨 2
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 *
 * 매우 쉬움. 안고르는 것도 경우의 수로
 */
class Solution {

    @Test
    public void test() {
        // given
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        // when
        int result = solution(clothes);

        //then
        Assertions.assertEquals(5, result);
    }

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int result = 1;
        for (String[] cloth : clothes) {
            map.putIfAbsent(cloth[1], 0);
            map.put(cloth[1], map.get(cloth[1])+1);
        }

        Set<String> keySet = map.keySet();
        for(String key: keySet) {
            result *= (map.get(key) + 1);
        }
        return result - 1;
    }
}
