package baekjoon.이분탐색.수_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/2869
 *
 * 브론즈 이분탐색 기초 문제
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main s = new Main();

        int n = Integer.parseInt(br.readLine());
        int[] nArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = Integer.parseInt(br.readLine());
        int[] mArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        s.solution(nArr, mArr);
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

        // 1 3 5 9 10 20 40  |  15
        while(leftIdx <= rightIdx) {
            int middleIdx = ( leftIdx + rightIdx ) / 2;

            if(m == nArr[middleIdx]) {
                return true;
            }

            if(leftIdx == rightIdx) {
                return false;
            }

            // 와 정망 코드가 웅장해진다....
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
