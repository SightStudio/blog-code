package baekjoon.이분탐색.달팽이는_올라가고_싶다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2869
 *
 * 브론즈 이분탐색 기초 문제
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main s = new Main();

        String[] command = br.readLine().split(" ");
        int a = Integer.parseInt(command[0]);
        int b = Integer.parseInt(command[1]);
        int y = Integer.parseInt(command[2]);

        System.out.println(
            s.solution(a, b, y)
        );
    }

    private int solution (int A, int B, int V) {
        return ( V - B - 1) / ( A - B ) + 1;
    }
}
