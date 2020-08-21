package leetcode.medium.p678;


import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

// https://leetcode.com/problems/valid-parenthesis-string/
class Solution {

    @Test
    void test() {
        assertTrue(checkValidString("()"));
        assertTrue(checkValidString("(*)"));
        assertTrue(checkValidString("(*))"));
        assertTrue(checkValidString("(*()"));

        assertFalse(checkValidString("***(()"));
        assertFalse(checkValidString("(((((()*)(*)*))())())(()())())))((**)))))(()())()"));
        assertFalse(checkValidString(")"));


        assertTrue(checkValidString("((*)"));
        assertTrue(checkValidString("(((******))"));
        assertFalse(checkValidString("(()(()))(()()()))))((((()*()*(())())(()))((*()(*((*(*()))()(())*()()))*)*()))()()(())()(()))())))"));
    }

    public boolean checkValidString(String s) {
        int max_open_left = 0;
        int min_open_left = 0;

        for (char c : s.toCharArray()) {

            if(c == '(') min_open_left++;
            else if(min_open_left > 0) min_open_left--;

            if(c != ')') max_open_left++;
            else if(max_open_left == 0) return false;
            else max_open_left--;
        }
        return min_open_left == 0;
    }

//    public boolean checkValidString(String s) {
//        if(s.isEmpty()) return true;
//
//        Deque<Character> from = new LinkedList<>();
//        Deque<Character> to   = new LinkedList<>();
//        Deque<Character> star = new LinkedList<>();
//
//        // init
//        for(char c : s.toCharArray()) {
//            from.push(c);
//        }
//
//        char initC = from.peek();
//
//        if(initC == '(') return false;      // 마지막이 ( 일때
//        if(s.length() == 1 && initC != '*') return false;  // ) 나 ( 하나만 있을 때
//
//        while(!from.isEmpty()) {
//            Character c = from.peek();
//
//            if (c == ')') {
//                to.push(from.pop());
//                continue;
//            }
//
//            if (c == '(') {
//                if (to.isEmpty()) {
//                    if (!star.isEmpty()) {
//                        from.pop();
//                        star.pop();
//                    } else {
//                        return false;
//                    }
//                    continue;
//                }
//
//                if (to.peek() == ')') {
//                    to.pop();
//                    from.pop();
//
//                } else {
//                    if (!star.isEmpty()) {
//                        from.pop();
//                        star.pop();
//                    } else {
//                        return false;
//                    }
//                }
//                continue;
//            }
//
//            if (c == '*') {
//                char all = from.pop();
//                if(!to.isEmpty()) {
//                    to.pop();
//                }
//                else if(!from.isEmpty()) {
//                    from.pop();
//                } else {
//                    star.push('*');
//                }
//                continue;
//            }
//        }
//
//        if(to.size() == star.size()) {
//            return true;
//        } else {
//            return star.size() - to.size() > 0;
//        }
//    }
}