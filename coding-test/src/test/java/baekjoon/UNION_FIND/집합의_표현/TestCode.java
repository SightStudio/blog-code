package baekjoon.UNION_FIND.집합의_표현;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.acmicpc.net/problem/1717
 *
 * 골드 | UNION - FIND 기초 문제
 */
public class TestCode {

    static List<String> result;

    @BeforeEach
    void setup() {
        result = new ArrayList<>();
    }

    @Test
    void test() {

        // given
        int n = 7;
        int m = 8;

        int[][] inputs = {
                { 0, 1, 3 },
                { 1, 1, 7 },
                { 0, 7, 6 },
                { 1, 7, 1 },
                { 0, 3, 7 },
                { 0, 4, 2 },
                { 0, 1, 1 },
                { 1, 1, 1 }
        };

        int[] parents = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            parents[i] = i;
        }
        // when
        for (int[] input : inputs) {
            int type   = input[0];
            int parent = input[1];
            int child  = input[2];

            String answer = solution(parents, type, parent, child);

            if (type == 1) result.add(answer);
        }

        // then
        assertEquals("NO" , result.get(0));
        assertEquals("NO" , result.get(1));
        assertEquals("YES", result.get(2));
    }

    private String solution (int[] parents, int type, int parent, int child) {
        if(type == 0) {
            unionParent(parents, parent, child);
            return "";
        }

        if(type == 1) {
            int pRoot = getRootParent(parents, parent);
            int cRoot = getRootParent(parents, child);

            return pRoot == cRoot ? "YES" : "NO";
        }
        return "";
    }

    private int getRootParent(int[] parents, int x) {
        int parent = parents[x];
        if(parent == x) return parent;
        else return getRootParent(parents, parent);
    }

    private void unionParent(int[] parents, int a, int b) {
        int aParent = getRootParent(parents, a);
        int bParent = getRootParent(parents, b);

        if(aParent > bParent) parents[aParent] = bParent;
        else if(aParent < bParent) parents[bParent] = aParent;
    }
}
