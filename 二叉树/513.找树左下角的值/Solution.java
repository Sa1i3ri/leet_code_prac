import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode cur = root;

        while (!queue.isEmpty()){
            cur = queue.poll();
            if(cur.right!=null) queue.add(cur.right);
            if(cur.left!=null) queue.add(cur.left);
        }
        return cur.val;

    }
}