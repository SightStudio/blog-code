package leetcode.medium.p36_next_permutation;

/**
 * @see
 * https://leetcode.com/problems/next-permutation/
 *
 * 31. C++ STL의 next_permutation을 직접 구현한다.
 *
 * 시간 복잡도 O(2n)
 *
 * 순열에서 맨 뒤에는 오름차순으로 되어있다.
 *
 * 오름차순의 경게가 되는 idx를 구한뒤,
 *
 * 해당 idx 까지 뒤로 스왑해주다가,
 * 해당 idx 까지 앞으로 다시 스왑해주면 된다.
 */
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution {

    @Test
    public void test() {

        int[] input = new int[] {5, 1, 1};
        nextPermutation(input);
        assertArrayEquals(new int[] {1, 1, 5}, input);

        input = new int[] {3, 2, 1};
        nextPermutation(input);
        assertArrayEquals(new int[] {1, 2, 3}, input);

        input = new int[] {1, 1};
        nextPermutation(input);
        assertArrayEquals(new int[] {1, 1}, input);

        input = new int[] {2, 3, 1};
        nextPermutation(input);
        assertArrayEquals(new int[] {3, 1, 2}, input);


        input = new int[] {1, 3, 2};
        nextPermutation(input);
        assertArrayEquals(new int[] {2, 1, 3}, input);


        input = new int[] {1, 2, 5, 4, 3};
        nextPermutation(input);

        assertArrayEquals(new int[] {1, 3, 2, 4, 5}, input);
    }

    public void nextPermutation(int[] nums) {

        if(nums.length == 1) return;

        int t_idx = nums.length - 2;

        while(nums[t_idx]  > nums[t_idx + 1]) {
            t_idx--;

            if(t_idx == 0) {
                break;
            }
        }

        reverse(nums, t_idx+1);

        int swap_idx = t_idx;
        for (int i = t_idx+1; i < nums.length; i++) {
            if(nums[i] > nums[t_idx]) {
                swap_idx = i;
                break;
            }
        }

        if(t_idx == swap_idx) {
            Arrays.sort(nums);
            return;
        }

        swap(nums, t_idx, swap_idx);
    }

    private void swap(int[] nums, int idx_a, int idx_b) {
        int temp    = nums[idx_a];
        nums[idx_a] = nums[idx_b];
        nums[idx_b] = temp;
    }

    private void reverse(int[] nums, int targetIdx) {

        int start = targetIdx;
        int end   = nums.length-1;

        while(start < end) {
            swap(nums, start, end);

            start++;
            end--;
        }
    }
}