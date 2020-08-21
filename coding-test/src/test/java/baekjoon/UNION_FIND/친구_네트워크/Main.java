package baekjoon.UNION_FIND.친구_네트워크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://www.acmicpc.net/problem/4195
 *
 * 골드 2 | UNION - FIND 기초 문제
 *
 * 확실히 백준은 TC 작성하기 어렵게 되있다....
 */
public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int F = Integer.parseInt(br.readLine()); // 친구 관계 수
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < F; i++)
        {
            int idx   = 0;
            int tcCnt = Integer.parseInt(br.readLine());
            String[] graph = new String[tcCnt];
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < tcCnt; j++)
            {
                String[] relation = br.readLine().split(" ");
                String left  = relation[0];
                String right = relation[1];

                if(map.get(left) == null) {
                    map.put(left, idx);
                    idx++;
                }

                if(map.get(right) == null) {
                    map.put(right, idx);
                    idx++;
                }

                //result.add(getUnionCnt(map));
            }

            map.clear();
        }
    }

//    private static Integer getUnionCnt(Map<String, Integer> map) {
//
//    }
}
