package level1.모의고사;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};

        Solution solution = new Solution();

        System.out.println(
                Arrays.toString(solution.solution(answers))
        );
    }

    /**
     * 3. reserve
     * 2. normal
     * 1. lost
     */
    public int[] solution(int[] answers) {
        List<Integer> user1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> user2 = Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5);
        List<Integer> user3 = Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);

        for (int i = 0; i < answers.length; i++) {

        }

        int[] answer = {};
        return answer;
    }
}