package programmers.level2.타켓넘버;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 문제 링크
 *
 * 레벨 2
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 *
 * 정말 기초적인 DFS 문제이다.
 */
class Solution {

    @Test
    public void test() {

        // given
        int[] number = {1, 1, 1, 1, 1};
        int target = 3;

        // when
        int result = solution(number, target);

        //then
        Assertions.assertEquals(5, result);
    }

    public int solution(int[] numbers, int target) {
        int[] result = {0};
        dfs(numbers, 0, 0, target, result);

        return result[0];
    }

    private void dfs(int[] numbers, int value, int idx, int target, int[] result) {

        if(idx >= numbers.length) {
            return;
        }

        if(idx == numbers.length - 1) {
            if (value + numbers[idx] == target || value - numbers[idx] == target) {
                result[0]++;
                return;
            }
        }

        dfs(numbers, value + numbers[idx], idx + 1, target, result);
        dfs(numbers, value - numbers[idx], idx + 1, target, result);
    }
}