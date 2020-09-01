package leetcode.medium.p46_permutations;

/**
 *
 * @see
 * https://leetcode.com/problems/permutations/description/
 *
 * 46. 순열 문제
 * 백트래킹 풀이
 *
 */
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    @Test
    public void test() {

        List<List<Integer>> permute = permute(new int[]{1, 2, 3, 4, 5});
        String resultStr = permute.stream()
                                 .map(Object::toString)
                                 .collect(Collectors.joining("\n"));

        System.out.println(resultStr);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        
        backtrack(nums, ret, tmp);

        return ret;
    }

    private void backtrack(int[] nums, List<List<Integer>> ret, List<Integer> tmp) {
        if(tmp.size() == nums.length) {
            ret.add(new ArrayList<>(tmp));
            return;
        }

        for (int num : nums) {
            if(tmp.contains(num)) continue;
            tmp.add(num);
            backtrack(nums, ret, tmp);
            tmp.remove(tmp.size() - 1 );
        }
    }
}