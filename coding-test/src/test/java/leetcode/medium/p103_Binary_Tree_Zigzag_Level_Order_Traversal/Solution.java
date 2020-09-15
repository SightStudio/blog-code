package leetcode.medium.p103_Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.*;

/*
 * 이진 트리 탐색
 *
 * https://www.youtube.com/watch?v=k-UrJmD457Y
 *
 * 문제 해설
 * - Level-Order-Traversal 인데 방향이 레벨마다 지그재그 하면서 찾아야함
 * flag 값을 줌으로써 좌우 변경
  */
class Solution {

    // 레벨 별 스택 사용
    // 플래그 변수 사용
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();

        if(root == null) return ret;
        Deque<TreeNode> s = new ArrayDeque<>();
        boolean flag = true;

        s.push(root);
        while(!s.isEmpty()) {

            int size = s.size();
            Deque<TreeNode> newStack = new ArrayDeque<>();
            List<Integer> level      = new ArrayList<>();

            // level traversal loop
            for (int i = 0; i < size; i++) {

                // 자손 처리
                TreeNode node = s.pop();
                level.add(node.val);

                if(flag) {
                    if(node.left != null) newStack.push(node.left);
                    if(node.right != null) newStack.push(node.right);
                } else {
                    if(node.right != null) newStack.push(node.right);
                    if(node.left != null) newStack.push(node.left);
                }
            }
            ret.add(level);
            s = newStack;
            flag = !flag;
        }
        return ret;
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

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */