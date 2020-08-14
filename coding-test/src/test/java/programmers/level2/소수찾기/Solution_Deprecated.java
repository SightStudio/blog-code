package programmers.level2.소수찾기;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 문제 링크
 *
 * 레벨 2
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */
class Solution_Deprecated {

    @Test
    public void test() {

        // given
        String number = "17";

        // when
        int result = solution(number);

        //then
        Assertions.assertEquals(3, result);
    }

    @Test
    public void primeNumTest() {
        // given
        int maxNum = 99;

        // when
        int result = getPrimNumCnt(maxNum);

        // then
        Assertions.assertEquals(24, result);
    }


    public int solution(String numbers) {

        char[] nums = numbers.toCharArray();
        Arrays.sort(nums);

        Deque<Character> deque = new LinkedList<>();

        for (Character c : nums) {
            if(c == '0') {
                deque.offerLast(c);
            } else {
                deque.offerFirst(c);
            }
        }

        int biggestNum =  Integer.parseInt(deque.stream().map(String::valueOf).collect(Collectors.joining()));

        return getPrimNumCnt(biggestNum);
    }

    private int getPrimNumCnt(int biggestNum) {
        boolean[] primeNumArr = new boolean[biggestNum+1];

        for (int i = 2; i <= biggestNum; i++) {

            if(primeNumArr[i] == true) {
                continue;
            }

            for (int j = i*2; j <= Math.sqrt(biggestNum); j+=i) {
                primeNumArr[j] = true;
            }
        }

        int cnt = 0;
        for (int i = 3; i < primeNumArr.length; i++) {
            boolean isPrimeNum = !primeNumArr[i];
            if(isPrimeNum) {
                System.out.println(i);
                cnt++;
            }
        }

        return cnt;
    }
}