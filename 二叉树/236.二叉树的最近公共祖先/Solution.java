import java.util.ArrayList;
import java.util.List;

class Solution {
    List<TreeNode> path1;
    List<TreeNode> path2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path = new ArrayList<>();
        path1 = new ArrayList<>();
        path2 = new ArrayList<>();
        path.add(root);

        dfs(path,root,p,q);

        for(int i =0;i<Math.max(path1.size(),path2.size());i++){
            if(i>=Math.min(path1.size(),path2.size()))return path1.get(i-1);;
            TreeNode p1 = path1.get(i);
            TreeNode p2 = path2.get(i);
            if(p1.val != p2.val && i!=0){
                return path1.get(i-1);
            }
        }
        return root;

    }

    private void dfs(List<TreeNode> path,TreeNode root,TreeNode p, TreeNode q){
        if(!path1.isEmpty() && !path2.isEmpty()) return;
        if(root==null) return;
        if(root.val==p.val){
            path1 = new ArrayList<>(path);
        }else if(root.val == q.val){
            path2 = new ArrayList<>(path);
        }

        path.add(root.left);
        dfs(path,root.left,p,q);
        path.remove(path.size()-1);

        path.add(root.right);
        dfs(path,root.right,p,q);
        path.remove(path.size()-1);

    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val||root.val==q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        }else{
            return null;
        }
    }

    public static void main(String[] args){
//        TreeNode q = new TreeNode(4);
//        TreeNode p = new TreeNode(5,new TreeNode(6),new TreeNode(2,new TreeNode(7),q));
//        TreeNode root = new TreeNode(3,p
//        ,new TreeNode(1,new TreeNode(0),new TreeNode(8)));

        TreeNode q = new TreeNode(4);
        TreeNode left = new TreeNode(2,null,q);
        TreeNode p = new TreeNode(3);
        TreeNode root = new TreeNode(1,left,p);

        System.out.println(new Solution().lowestCommonAncestor(root,p,q).val);

    }
}