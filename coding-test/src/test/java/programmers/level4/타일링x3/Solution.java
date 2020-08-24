package programmers.level4.타일링x3;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class Solution {

    @Test
    void test() {
        assertEquals(11, solution(4));
        assertEquals(41, solution(6));
        assertEquals(153, solution(8));
        assertEquals(658712818, solution(5000));
        Queue a = new LinkedList();
    }


    public int solution(int n) {
        int[] DP = new int[n+1];
        DP[1] = 1;
        DP[2] = 3;
        DP[3] = 0;
        DP[4] = 11; // 3 * 4 - 1

        for (int i = 5; i <= n ; i++) {
            DP[i]  = DP[i-2]*4 - DP[i-4]   ;
        }

        return DP[n] % 1000000007;
    }

    /*
     *      n = 1  1
     *      n = 2  3
     *      n = 3  0
     *      n = 4  11 ->  3 * 4 - 1
     *      n = 5  0
     *      n = 6  41  -> 11 * 4 - 3
     *      n = 7  0
     *      n = 8  153 -> 41 * 4 - 11
     *
     *      n[1] = 1
     *      n[2] = 2
     *      n[3] = 0
     *      n[4] = 11
     *
     *      점화식
     *      n[m] = n[m-2] * 4 - n[m-4]
     *
     *
     *      단, 1,000,000,007 로 나눔
     */

}