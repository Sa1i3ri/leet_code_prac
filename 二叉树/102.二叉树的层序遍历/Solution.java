import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            for(int i =0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);

                layer.add(cur.val);
            }
            res.add(layer);
        }
        return res;
    }
}