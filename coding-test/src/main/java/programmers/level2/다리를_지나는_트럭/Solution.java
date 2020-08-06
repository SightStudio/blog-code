package programmers.level2.다리를_지나는_트럭;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitingQ = initWaitingQ(truck_weights);
        Queue<Integer> que = new LinkedList<>();



        return 0;
    }

    private Queue<Integer> initWaitingQ(int[] truck_weights) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            list.add(truck_weights[i]);
        }
        return list;
    }
}