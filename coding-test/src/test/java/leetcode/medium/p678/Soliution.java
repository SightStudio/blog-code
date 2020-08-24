package leetcode.medium.p678;


import org.junit.jupiter.api.Test;
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

    public boolean checkValidString(String s)
    {
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
}