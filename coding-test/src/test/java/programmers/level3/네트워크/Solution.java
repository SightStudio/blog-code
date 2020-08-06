package programmers.level3.네트워크;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 문제 링크
 *
 * 레벨 3
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */
class Solution {

    @Test
    public void test() {
        // given
        int n = 3;
        int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

        // when
        int result = solution(n, computers);

        //then
        Assertions.assertEquals(2, result);
    }


    @Test
    public void test2() {
        // given
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        // when
        int result = solution(n, computers);

        //then
        Assertions.assertEquals(1, result);
    }

    public int solution(int n, int[][] computers) {
        Boolean[] visited = new Boolean[n]; // false init
        Arrays.fill(visited, false);

        List<List<Integer>> adjList = initAdjList(computers);

        for (int i = 0; i < computers.length; i++) {
            if(visited[i]) continue;

            List<Integer> nodeAdj = adjList.get(i);

            for (int j = 0; j < nodeAdj.size(); j++) {
                if( i != j &&nodeAdj.get(j) == 1 ) {
                    visited[j] = true;
                    visited[i] = true;
                }
            }
        }

        return (int) Arrays.stream(visited)
                .filter(visit -> visit)
                .count();
    }

    private List<List<Integer>> initAdjList(int[][] computers) {
        List<List<Integer>> adjList = new ArrayList<>(computers.length);

        for(int[] node: computers) {
            List<Integer> nodeAdj = new ArrayList<>(node.length);
            for (int i : node) {
                nodeAdj.add(i);
            }
            adjList.add(nodeAdj);
        }
        return adjList;
    }
}
