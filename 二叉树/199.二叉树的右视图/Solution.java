import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root==null) return res;
        queue.add(root);
        int deep = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode cur =  queue.poll();
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
                if(i==size-1){
                    res.add(cur.val);
                }
            }
        }
        return res;
    }
}