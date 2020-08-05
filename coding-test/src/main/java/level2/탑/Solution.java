//package level2.탑;
//
//import java.util.*;
//
//public class Solution {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//
//        int[] height  = { 6,9,5,7,4 };
//        int[] height2 = { 3,9,9,3,5,7,2 };
//        int[] height3 = { 1,5,3,6,7,6,5 };
//
//        System.out.println(
//                Arrays.toString(solution.solution(height))
//        );
//
//    }
//
//    public int[] solution(int[] heights) {
//        Deque<Tower> towers  = new LinkedList<>();
//        Stack<Tower> senders = new Stack<>();
//        List<Integer> result = new ArrayList<>(heights.length);
//
//        initTower(towers, heights);
//
//        while (!towers.isEmpty()) {
//            Tower sender = towers.pop();
//            sender.setReceiver(findReceiver(towers, sender));
//            senders.push(sender);
//        }
//
//        while (!senders.isEmpty()) {
//            result.add(senders.pop().getReceiver());
//        }
//
//        return result.stream().mapToInt(Integer::intValue).toArray();
//    }
//
//    private int findReceiver(Deque<Tower> towers, Tower sender) {
//        Iterator<Tower> it = towers.iterator();
//        while(it.hasNext()) {
//            Tower tower = it.next();
//            if(tower.getH저eight() > sender.getHeight()) {
//                return tower.idx;
//            }
//        }
//        return 0;
//    }
//
//    private void initTower(Deque<Tower> towers, int[] heights) {
//        for (int i = 0; i < heights.length; i++) {
//            towers.push(new Tower(i+1, heights[i]));
//        }
//    }
//}
//
//class Tower {
//    int idx;
//    int height;
//    int receiver;
//
//    public Tower(int idx, int height) {
//        this.idx = idx;
//        this.height = height;
//    }
//
//    public void setReceiver(int receiver) {
//        this.receiver = receiver;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public int getReceiver() {
//        return receiver;
//    }
//}