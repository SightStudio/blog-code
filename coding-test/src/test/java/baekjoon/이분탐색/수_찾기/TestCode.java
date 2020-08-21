package baekjoon.이분탐색.수_찾기;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestCode {

    @Test
    void test() {
        int nCnt = 5;
        int[] n = { 4, 1, 5, 2, 3 }; // 1 2 3 4 5

        int mCnt = 5;
        int[] m = { 1, 3, 7, 9, 5 };

        solution(n, m);
    }

    private void solution(int[] nArr, int[] mArr) {
        Arrays.sort(nArr);
        List<Integer> result = new ArrayList<>(mArr.length);

        for (int m : mArr) {
            int isExist = binarySearch(nArr, m) ? 1 : 0;
            result.add(isExist);
        }

        String resultStr = result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));

        System.out.print(resultStr);
    }

    private boolean binarySearch(int[] nArr, int m) {
        int leftIdx = 0;
        int rightIdx = (nArr.length - 1);

        if(m > nArr[rightIdx] || m < nArr[leftIdx]) {
            return false;
        }

        while(leftIdx <= rightIdx) {
            int middleIdx = ( leftIdx + rightIdx ) / 2;

            if(m == nArr[middleIdx]) {
                return true;
            }

            if(leftIdx == rightIdx) {
                return false;
            }

            if (m < nArr[middleIdx]) {
                if(rightIdx == middleIdx) {
                    leftIdx  = rightIdx;
                } else {
                    rightIdx  = middleIdx;
                }
            } else {

                if(leftIdx == middleIdx) {
                    leftIdx  = rightIdx;
                } else {
                    leftIdx  = middleIdx;
                }
            }
        }
        return false;
    }
}
