package baekjoon.UNION_FIND.집합의_표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/1717
 *
 * 골드 | UNION - FIND 기초 문제
 */
public class Main {
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main s = new Main();

        int[] n_m = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();

        int n = n_m[0];
        int m = n_m[1];

        // init
        int[] parents = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            parents[i] = i;
        }

        int[][] commands = new int[m][3];
        for (int i = 0; i < m; i++) {
            int[] command = Arrays.stream(br.readLine().split(" "))
                                  .mapToInt(Integer::parseInt)
                                  .toArray();

            commands[i][0] = command[0];
            commands[i][1] = command[1];
            commands[i][2] = command[2];
        }

        // when
        for (int[] command : commands) {
            int type   = command[0];
            int parent = command[1];
            int child  = command[2];

            String answer = s.solution(parents, type, parent, child);

            if (type == 1) result.add(answer);
        }

        String resultStr = String.join("\n", result);
        System.out.print(resultStr);
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
