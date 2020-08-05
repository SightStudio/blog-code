package level1.k번째수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] originArr  = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { {2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        Solution solution = new Solution();
        System.out.println(
                Arrays.toString(solution.solution(originArr, commands))
        );
    }

    public int[] solution(int[] originArr, int[][] commands) {
        List<Integer> result = new ArrayList<>(commands.length);

        for (int i = 0; i < commands.length; i++) {
            Command command = new Command(commands[i]);
            int[] arr = slice(originArr, command.from, command.to);
            bubbleSort(arr);

            result.add(arr[command.target]);
        }

        return result
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int[] slice(int[] target, int startInclusive, int endExclusive) {
        int size = ( endExclusive + 1 )  - startInclusive;

        int[] deepCopiedArr = new int[size];
        for (int i = 0; i < deepCopiedArr.length; i++) {
            deepCopiedArr[i] = target[startInclusive - 1 + i];
        }
        return deepCopiedArr;
    }

    // 재활 치료는 버블소트부터
    private void bubbleSort(int[] target) {
        for (int i = target.length - 1; i > 0 ; i--)
        {
            for (int j = 0; j < i ; j++)
            {
                if(target[j] > target[j+1]) {
                    int temp = target[j];
                    target[j] = target[j+1];
                    target[j+1] = temp;
                }
            }
        }
    }
}

class Command {
    int from;
    int to;
    int target;

    public Command(int[] command) {
        this.from   = command[0];
        this.to     = command[1];
        this.target = command[2] - 1;
    }
}