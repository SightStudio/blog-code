package programmers.level2.프린터;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 문제 링크
 *
 * 레벨 2
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */
class Solution {

    @Test
    public void test1() {

        // given
        int[] properties = {2, 1, 3, 2};
        int location = 2;

        // when
        int result = solution(properties, location);

        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    public void test2() {

        // given
        int[] properties = {1, 1, 9, 1, 1, 1};
        int location = 0;

        // when
        int result = solution(properties, location);

        //then
        Assertions.assertEquals(5, result);
    }

    public int solution(int[] priorities, int location) {
        Deque<Job> deque = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            deque.offerLast(new Job(i, priorities[i]));
            pq.offer(priorities[i]);
        }

        Job job = null;
        int maxPriority = 0;
        int printCnt = 0;
        do {
            job = deque.peekFirst();
            maxPriority = pq.peek();

            if(job.priority == maxPriority) {
                deque.removeFirst();
                pq.poll();
                printCnt++;
            } else {
                deque.offerLast(deque.pollFirst());
            }

            if(job.idx == location && maxPriority == job.priority) {
                break;
            }
        } while (true);

        return printCnt;
    }
}

class Job {
    int priority;
    int idx;

    public Job(int idx, int priority) {
        this.priority = priority;
        this.idx = idx;
    }
}