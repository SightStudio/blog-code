package leetcode.easy.p938_Range_Sum_of_BST;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 *
 * Given the root node of a binary search tree,
 * return the sum of values of all nodes with value between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 */
class Solution {

    @Test
    void test() {

    }

    /**
     * 1. root == null return 0;
     * 2. root.val < L       | only recurse right
     * 3. root.val > R       | only recurse left
     * 4. L <= root.val <= R | recurse left + rool.val + recurse right
     *
     * 2 5 8 -> 5  ( 5 )
     * 3 5 7 -> 15 ( 3 + 5 + 7 )
     *
     * root.val = 5 + recurse left + recurse right
     * 1 2 [3 4 5 6 7] 8 9 10
     *
     * ex 1)
     * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
     * Output: 32
     *
     * ex 2)
     * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
     * Output: 23
     * */
    public int rangeSumBST(TreeNode root, int L, int R) {

        // empty tree
        if(root == null) return 0;
        else if(root.val > R) {
            return rangeSumBST(root.right, L, R);
        }
        else if(root.val < L) {
            return rangeSumBST(root.left, L , R);
        } else {
            return rangeSumBST(root.left, L, R) + root.val +
                    rangeSumBST(root.right, L, R);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}