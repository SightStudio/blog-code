package level3.이중우선순위큐;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

        String[] op1 = { "I 16", "D 1" };
        String[] op2 = { "I 7" , "I 5", "I -5", "D -1" };
        String[] op3 = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
        String[] op4 = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        String[] op5 = { "I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        String[] op6 = { "D 16", "I 653", "I 653", "D 1" };

        Solution solution = new Solution();

        System.out.println(
                Arrays.toString(solution.solution(op5))
        );
    }

    public int[] solution(String[] operations) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> minHeap = new PriorityQueue<>();

        for(String op : operations) {
            String[] parseOp = op.split(" ");
            String command = parseOp[0];
            int value = Integer.parseInt(parseOp[1]);

            switch (command) {
                case "I":
                    maxHeap.offer(value);
                    minHeap.offer(value);
                    break;

                case "D":
                    if(maxHeap.isEmpty()) {
                        break;
                    }

                    if(value == 1) {
                        minHeap.remove(maxHeap.poll());
                    }

                    if(value == -1) {
                        maxHeap.remove(minHeap.poll());
                    }
                    break;
            }
        }

        if(maxHeap.isEmpty() || minHeap.isEmpty()) {
            return new int[] { 0, 0 };
        } else {
            return new int[] { maxHeap.poll(), minHeap.poll() };
        }
    }
}