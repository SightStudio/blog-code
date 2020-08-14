package baekjoon.이분탐색.달팽이는_올라가고_싶다;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCode {

    @Test
    void test() {
        int A = 2;
        int B = 1;
        int V = 5;

        int result = solution(A, B, V);

        Assertions.assertEquals(4, result);
    }

    private int solution (int A, int B, int V) {
        return ( V - B - 1) / ( A - B ) + 1;
    }

    private int solution_시간초과 (int a, int b, int y) {

        int current = 0;
        int day = 0;
        while(current < y) {
            current+=a;
            current-=b;
            day ++;
        }
        return day;
    }
}
