package programmers.level2.구명보트;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 문제 링크
 *
 * 레벨 2
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 *
 * 매우 쉬움. 덱에 다 넣고 정렬 -> 앞뒤로 빼면서 greedy
 */
class Solution {

    @Test
    public void test() {
        // given
        int[] people = { 70, 50, 80, 50 };
        int limit = 100;

        // when
        int result = solution(people, limit);

        //then
        Assertions.assertEquals(3, result);
    }

    public int solution(int[] people, int limit) {
        Deque<Integer> dq = new ArrayDeque<>(people.length);
        int result = 0;
        Arrays.sort(people);

        for (Integer person : people) {
            dq.push(person);
        }

        while(!dq.isEmpty()) {
            int smaller = dq.peekLast();
            int bigger  = dq.peekFirst();

            if(dq.size() == 1) {
                dq.poll();
                result++;
                continue;
            }

            if(limit >= bigger + smaller) {
                dq.pollLast();
                dq.pollFirst();
                result++;
            } else {
                dq.pollFirst(); // remove bigger
                result++;
            }
        }
        return result;
    }

//    ?? 시간 초과 -> 스트림이 이렇게나 느립니다.
//    public int solution(int[] people, int limit) {
//        Deque<Integer> dq = new ArrayDeque<>(people.length);
//        int result = 0;
//
//        Integer[] boxedPeople = IntStream.of(people).boxed().sorted((o1, o2) -> o1- o2).toArray(Integer[]::new);
//
//        for (Integer boxedPerson : boxedPeople) {
//            dq.push(boxedPerson);
//        }
//
//        while(!dq.isEmpty()) {
//            int front = dq.peekFirst();
//            int back  = dq.peekLast();
//
//            if(dq.size() == 1) {
//                dq.pollFirst();
//                result++;
//                continue;
//            }
//
//            if(limit >= front + back) {
//                dq.pollFirst();
//                dq.pollLast();
//                result++;
//            } else {
//                dq.pollFirst();
//                result++;
//            }
//        }
//        return result;
//    }
}
