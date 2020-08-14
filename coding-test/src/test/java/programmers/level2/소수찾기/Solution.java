package programmers.level2.소수찾기;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * 문제 링크
 *
 * 레벨 2
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 *
 * 조합 짜는부분에서 꽤나 애를 먹었다. 결국 조합짜는 부분 답을 보고야 말았다.
 * 나 같은 경우는 경우에 수가 많아 질것 같아서
 * 미리 제일 큰 수 까지의 소수를 미리 구해 대입하는 방식으로 했다.
 *
 * 안 구해놔도 될 것 같다.
 */
class Solution {

    @Test
    public void test() {

        // given
        String number = "17";

        // when
        int result = solution(number);

        //then
        Assertions.assertEquals(3, result);
    }

    public int solution(String numbers) {

        char[] nums = numbers.toCharArray();
        Arrays.sort(nums);

        Deque<Character> deque = new LinkedList<>();

        for (Character c : nums) {
            if(c == '0') {
                deque.offerLast(c);
            } else {
                deque.offerFirst(c);
            }
        }

        String biggestNumStr = deque.stream()
                                    .map(String::valueOf)
                                    .collect(Collectors.joining());

        int biggestNum = Integer.parseInt(biggestNumStr);

        LinkedList<Integer> primeNumList = getPrimNumCnt(biggestNum);
        HashSet<Integer> permutations = new HashSet<>();

        permutation("", new String(nums), permutations);

        int resultCnt = 0;
        for(int perm : permutations) {
            for (int i = 0; i < primeNumList.size(); i++) {
                if(perm == primeNumList.get(i)) {
                    primeNumList.remove(i);
                    resultCnt++;
                    break;
                }
            }
        }
        return resultCnt;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();

        if(!prefix.isEmpty()) {
            set.add(Integer.valueOf(prefix));
        }

        for (int i = 0; i < n; i++) {
            String subPrefix = prefix + str.charAt(i);
            String subStr = str.substring(0, i) + str.substring(i+1, n);
            permutation(subPrefix, subStr, set);
        }
    }

    /**
     * 에라토스 테네스의 체를 이용해 소수를 담은 리스트 생성
     *
     * @param biggestNum ~ 까지의 경계값
     * @return 소수 개수
     */
    private LinkedList<Integer> getPrimNumCnt(int biggestNum) {
        boolean[] primeNumArr = new boolean[biggestNum+1];
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 2; i <= Math.sqrt(biggestNum); i++) {

            if(primeNumArr[i] == true) {
                continue;
            }

            for (int j = i*2; j <= biggestNum; j+=i) {
                primeNumArr[j] = true;
            }
        }

        for (int i = 3; i < primeNumArr.length; i++) {
            boolean isPrimeNum = !primeNumArr[i];
            if(isPrimeNum) {
                result.add(i);
            }
        }

        return result;
    }
}