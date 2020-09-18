package programmers.level3.단어변환;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 * 사실 진짜 쉬운 DFS 문제이다.
 *
 * 흠.. 코드 더 이쁘게 하고싶은데..
 */
class Solution {

    @Test
    void test() {

        // given
        String[] words = new String[] { "hot", "dot", "dog", "lot", "log", "cog" };
        String begin  = "hit";
        String target = "cog";

        // when
        int result = solution(begin, target, words);

        // then
        assertEquals(4, result);
    }

    @Test
    void test2() {

        // given
        String[] words = new String[] { "hot", "dot", "dog", "lot", "log"};
        String begin  = "hit";
        String target = "cog";

        // when
        int result = solution(begin, target, words);

        // then
        assertEquals(0, result);
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] rootVisited = new boolean[words.length];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if(isReachAble(begin, word)) {
                rootVisited[i] = true;
                dfs(1, words, rootVisited, word, target, result);
            }

            Arrays.fill(rootVisited, false);
        }

        return result
                .stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);
    }

    private void dfs(int depth, String[] words, boolean[] visited, String now, String target, List<Integer> result) {

        if(now.equals(target)) {
            result.add(depth);
            return;
        }

        if(depth == words.length) {
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i])  {
                String next = words[i];

                if(isReachAble(now, next)) {
                    visited[i] = true;
                    dfs(depth+1, words, visited, next, target, result);
                    visited[i] = false;
                }
            }
        }
    }

    private boolean isReachAble(String begin, String word) {
        int diffCnt = 0;

        // 문자 길이 같음
        for (int i = 0; i < begin.length(); i++) {
            if(begin.charAt(i) != word.charAt(i)) {
                diffCnt++;
                if(diffCnt >= 2) break;
            }
        }
        return diffCnt <= 1;
    }
}