package level1.체육복;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        int n = 5;
//        int[] lost = {2, 4};
//        int[] reserve = {1, 3, 5};

//        int n = 7;
//        int[] lost = {1, 3, 4, 6};
//        int[] reserve = {2, 7, 5};

//        int n = 5;
//        int[] lost = {2,4};
//        int[] reserve = {3};

        int n = 8;
        int[] lost = {5, 6};
        int[] reserve = { 4, 5 };

        Solution solution = new Solution();

        System.out.println(
                solution.solution(n, lost, reserve)
        );
    }

    /**
     * 3. reserve
     * 2. normal
     * 1. lost
     */
    public int solution(int n, int[] lost, int[] reserve) {
        int[] studentArr = new int[n+1];

        Arrays.fill(studentArr, 2);

        // init reserve
        for (int i = 0; i < reserve.length; i++) {
            int reserveIdx = reserve[i];
            studentArr[reserveIdx] = 3;
        }

        // init lost
        for (int i = 0; i < lost.length; i++) {
            int lostIdx = lost[i];
            studentArr[lostIdx]--;
        }

        // do process
        for (int i = 0; i < lost.length; i++) {
            if(studentArr[lost[i]] != 1) continue;

            int[] getNear = getNearIdx(studentArr, lost[i]);

            for (int j = 0; j < getNear.length; j++) {
                if(studentArr[getNear[j]] == 3) {
                    studentArr[lost[i]]++;
                    studentArr[getNear[j]]--;
                    break;
                }
            }
        }

        int lostCnt = 0;
        for (int i = 1; i < studentArr.length; i++) {
            if(studentArr[i] == 1) {
                lostCnt++;
            }
        }
        return n - lostCnt;
    }

    private int[] getNearIdx(int[] studentArr, int i) {
        if(i == 1) {
            return new int[] { 2 };
        } else if (i == studentArr.length-1) {
            return new int[] {studentArr.length - 2};
        } else {
            return new int[] { i-1, i+1};
        }
    }
}