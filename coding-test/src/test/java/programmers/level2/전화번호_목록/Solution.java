package programmers.level2.전화번호_목록;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 문제 링크
 *
 * 레벨 2
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 *
 * 접두사가 아닌 경우도 체크해야한다.
 * 문제를 똑바로 읽자... ㅜㅜ
 *
 */
class Solution {

    @Test
    public void test() {
        assertFalse(solution(new String[] { "119", "97674223", "1195524421" }));
        assertFalse(solution(new String[] { "12" , "123", "1235", "567", "88" }));
        assertTrue( solution(new String[] { "123", "456", "789" }));

    }

    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for(String phone : phone_book) {
            map.putIfAbsent(phone, 1);
            map.computeIfPresent(phone, (key, val) -> map.put(key, val+1));
        }

        boolean flag = true;

        Set<String> keySet = map.keySet();

        for (String key : keySet)
        {
            for (String compare : keySet)
            {
                if(key.equals(compare))
                {
                    if(map.get(key) > 1)
                    {
                        flag = false;
                        break;
                    } else {
                        continue;
                    }
                }

                if(key.contains(compare) && key.startsWith(compare)) {
                    flag = false;
                    break;
                }
            }

            if(flag == false) break;
        }

        return flag;
    }
}