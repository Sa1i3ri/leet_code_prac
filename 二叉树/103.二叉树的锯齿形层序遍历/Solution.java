import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean isLeft = false;

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            for(int i =0;i<size;i++){
                TreeNode cur = queue.poll();
                layer.add(cur.val);
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
            }
            if(isLeft){
                List<Integer> temp = new ArrayList<>();
                for(int i =layer.size()-1;i>=0;i--){
                    temp.add(layer.get(i));
                }
                res.add(temp);
            }else{
                res.add(layer);
            }
            isLeft = !isLeft;
        }
        return res;
    }
}