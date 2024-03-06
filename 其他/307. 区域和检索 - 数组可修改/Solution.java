class NumArray {
    private int[] nums;
    private int[] tree;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new int[nums.length+1];
        //下标从1开始
        //tree[i+1]代表以i为末尾的拆分

//        for(int i=0;i<nums.length;i++){
//            for(int j =i+1;j<tree.length;j += j&-j){
//                tree[j] += nums[i];
//            }
//        }
        for(int i =1;i<tree.length;i++){
            tree[i] += nums[i-1];
            int next = i + (i&-i);
            if(next<tree.length){
                tree[next] += tree[i];
            }
        }

    }

    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val;
        for(int i = index+1;i<tree.length;i += i&-i){
            tree[i] += delta;
        }
    }

    private int getSum(int n){
        int res = 0;
        for(int i = n;i>0;i -= i&-i){
            res += tree[i];
        }
        return res;
    }

    public int sumRange(int left, int right) {
        return getSum(right+1) - getSum(left);
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */