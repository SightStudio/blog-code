package programmers.level2.카펫;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 문제 링크
 *
 * 레벨 2
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 *
 *
 *   음.. 나는 아래와 같은 상황을 염두에 두고 했는데 해당 TC는 따로 없는듯 하다
 *
 *   BBBBB
 *   BBYBB
 *   BBBBB
 */
class Solution {

    @Test
    public void test() {

        assertArrayEquals(new int[]{4, 3}, solution(10, 2));
        assertArrayEquals(new int[]{3, 3}, solution(8 , 1));
        assertArrayEquals(new int[]{6, 3}, solution(14 , 4));
        assertArrayEquals(new int[]{8, 6}, solution(24 , 24));
        assertArrayEquals(new int[]{8, 3}, solution(18,6));
        assertArrayEquals(new int[]{24, 3}, solution(50 , 22));

    }

    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int x = 0;
        int y = 0;

        int size = (int) Math.sqrt(brown+yellow);
        for (int i = 3; i <= size; i++) {

            if(sum % i == 0) {
                int another = sum/i;
                x = i;
                y = another;

                if(another > i) {
                    x = another;
                    y = i;
                }

                if((y-2)*(x-2) != yellow)
                    continue;

                break;
            }
        }
        
        return new int[] { x, y };
    }
}
