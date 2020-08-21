package programmers.level2.멀쩡한_사각형;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 문제 링크
 *
 * 레벨 2
 * https://programmers.co.kr/learn/courses/30/lessons/62048
 */
class Solution {

    @Test
    public void test() {

        // given
        int w = 8;
        int h = 12;

        // when
        long result = solution(w, h);

        //then
        Assertions.assertEquals(80, result);
    }

    @Test
    public void gcdInPrimeNumberTest() {

        // given
        int x = 15;
        int y = 17;

        // when
        long result = getGCD(x, y);

        // then
        Assertions.assertEquals(1, result);
    }

    public long solution(int w, int h) {
        long wl = Long.parseLong(String.valueOf(w));
        long hl = Long.parseLong(String.valueOf(h));

        return wl * hl - ( wl + hl - getGCD(wl, hl));
    }


    @Test
    public void getGCD_LCD() {

        // given
        int x = 85;
        int y = 51;

        // when
        long gcd = getGCD(x, y);
        long lcd = getLCD(x, y, gcd);

        // then
        Assertions.assertEquals(17, gcd);
        Assertions.assertEquals(255, lcd);
    }

    public long getGCD(long x, long y) {
        long remain  = Math.max(x, y);
        long divider = Math.min(x, y);

        while(true) {
            remain = remain % divider;

            if(remain == 0) {
                break;
            }

            divider = divider ^ remain;
            remain  = divider ^ remain;
            divider = divider ^ remain;
        }
        return divider;
    }

    public long getLCD(long x, long y, long gcd ) {
        return x * y / gcd;
    }
}
