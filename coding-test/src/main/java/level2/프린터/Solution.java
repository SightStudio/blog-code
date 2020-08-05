package level2.프린터;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] prop1 = {2, 1, 3, 2};
//        int location = 2;

        int[] prop1 = { 1, 1, 9, 1, 1, 1 };
        int location = 0;

        System.out.println(
            solution.solution(prop1, location)
        );
    }

    public int solution(int[] priorities, int location) {
        PriorityQueue<PrintJob> priorityQueue = new PriorityQueue<>();

        initQueue(priorityQueue, priorities);

        boolean flag = true;
        int processCnt = 0;
        while(flag) {
            PrintJob job = priorityQueue.poll();
            processCnt++;

            if(job == null || job.idx == location) {
                flag = false;
            }
        }
        return processCnt;
    }

    private void initQueue(PriorityQueue<PrintJob> priorityQueue, int[] priorities) {
        for (int i = 0; i < priorities.length; i++) {
            priorityQueue.offer(new PrintJob(i, priorities[i]));
        }
    }
}

class PrintJob implements Comparable<PrintJob> {
    int idx;
    int priority;

    public PrintJob(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }

    @Override
    public int compareTo(PrintJob o) {
        if(this.priority == o.priority) {
            return o.idx - this.idx;
        } else {
            return o.priority - this.priority;
        }
    }
}