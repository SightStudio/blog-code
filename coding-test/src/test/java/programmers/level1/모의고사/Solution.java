package programmers.level1.모의고사;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 문제 링크
 *
 * 레벨 1
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 *
 * 완전 탐색 문제
 */
class Solution {

    @Test
    public void test() {
        assertArrayEquals(new int[]{1}, solution(new int[] {1, 2, 3, 4, 5}));
        assertArrayEquals(new int[]{1, 2, 3}, solution(new int[] {1, 3, 2, 4, 2}));
        assertArrayEquals(new int[]{1}, solution(new int[] {1, 3, 3, 4, 5}));

    }

    public int[] solution(int[] answers) {
        int[] person_1 = new int[] {1, 2, 3, 4, 5};
        int p1_cnt = 0;

        int[] person_2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int p2_cnt = 0;

        int[] person_3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int p3_cnt = 0;


        for (int i = 0; i < answers.length; i++) {
            int p_idx = i % person_1.length;

            if(answers[i] == person_1[p_idx]) {
                p1_cnt++;
            }
        }

        for (int i = 0; i < answers.length; i++) {
            int p_idx = i % person_2.length;

            if(answers[i] == person_2[p_idx]) {
                p2_cnt++;
            }
        }

        for (int i = 0; i < answers.length; i++) {
            int p_idx = i % person_3.length;

            if (answers[i] == person_3[p_idx]) {
                p3_cnt++;
            }
        }

        int max = p1_cnt;
        max = Math.max(max, p2_cnt);
        max = Math.max(max, p3_cnt);

        ArrayList<Integer> result = new ArrayList<>(3);

        if(p1_cnt == max) {
            result.add(1);
        }

        if(p2_cnt == max) {
            result.add(2);
        }

        if(p3_cnt == max) {
            result.add(3);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
