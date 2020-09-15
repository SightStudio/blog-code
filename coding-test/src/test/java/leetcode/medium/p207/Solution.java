package leetcode.medium.p207;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 위상정렬 문제
 * https://leetcode.com/problems/course-schedule/description/
 *
 * prerequisites : 전제 조건
 */
class Solution {

    @Test
    void test() {

        // given
        int numCourses = 6;
        int[][] prerequisites = {
                { },
                { },
                { },
        };
    }

    // 1. indegree == 0 인것 탐색
    // 2. 관련 엣지 제거, indegree 업데이트
    // 1, 2를 반복
    // 루프 종료 후, 모든 노드 탐색했는지 확인
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) adjList.add(new ArrayList<>());

        for(int[] edge : prerequisites) {
            indegree[edge[0]]++; // goto 1
            adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        // indegree가 0인 노드들을 탐색
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        // 모든 노드를 탐색했는지 확인
        Set<Integer> visited = new HashSet<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            visited.add(node);
            // 해당 노드부터 인접리스트 탐 -- indegree를 줄여준다.
            for (int dest: adjList.get(node)) {
                if(--indegree[dest] == 0) q.offer(dest); // goto 1 이휴 - 해당 노드의 indegree를 줄였는데 0 일 경우, 큐어넣어서 다시 탐색되도록 함
            }

            adjList.get(node).clear();
        }
        return visited.size() == numCourses;
    }
}