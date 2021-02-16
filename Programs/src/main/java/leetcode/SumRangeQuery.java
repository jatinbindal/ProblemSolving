package leetcode;

//Sum Range Query
// Segment Tree implemeted
public class SumRangeQuery {

    class NumArray {

        class segmentNode{
            int start;
            int end;
            int sum;
            segmentNode left;
            segmentNode right;
            public segmentNode(int start,int end){
                this.start = start;
                this.end = end;
                this.left = null;
                this.right = null;
                this.sum = 0;
            }
        }

        segmentNode node;
        int[] nums;
        public NumArray(int[] nums) {
            this.nums = new int[nums.length];
            for(int i=0;i<nums.length;i++)
                this.nums[i]=nums[i];
            this.node = buildtree(nums,0,nums.length-1);
        }

        public segmentNode buildtree(int[] nums, int start, int end){
            if(start>end) return null;
            segmentNode node = new segmentNode(start,end);
            if(start==end){
                node.sum = nums[start];
                return node;
            }
            int mid = start + (end - start)/2;
            node.left = buildtree(nums,start,mid);
            node.right = buildtree(nums,mid+1,end);
            node.sum = node.left.sum+node.right.sum;
            return node;
        }

        public void update(int i, int val) {
            int diff = nums[i] - val;
            nums[i] = val;
            treeUpdate(node,i,diff);
        }

        public void treeUpdate(segmentNode root, int index, int diff){
            if(root==null||index>root.end||index<root.start) return;
            if(root.start<=index && root.end>=index) root.sum-=diff;
            treeUpdate(root.left,index,diff);
            treeUpdate(root.right,index,diff);

        }

        public int sumRange(int i, int j) {
            return node==null?0:getSum(node,i,j);
        }

        public int getSum(segmentNode root, int start, int end){
            if(root==null|| start > root.end || end < root.start) return 0;
            if(start<=root.start && end>=root.end)  return root.sum;
            int left = getSum(root.left,start,end);
            int right = getSum(root.right,start,end);
            return left+right;
        }
    }
}
