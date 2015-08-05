package sse.ustc.edu;

public class KthSmallestElementinaBST {
	//inorder traversal
    // private void getInorderPath(TreeNode root, List<TreeNode> path) {
    //     if(root == null)
    //         return;
    //     getInorderPath(root.left, path);
    //     path.add(root);
    //     getInorderPath(root.right, path);
    // }

    // public int kthSmallest(TreeNode root, int k) {
    //     if(root == null || k < 1)
    //         throw new IllegalArgumentException();
    //     List<TreeNode> path = new ArrayList<>();
    //     getInorderPath(root, path);
        
    //     if(k > path.size())
    //         throw new IllegalArgumentException();
    //     return path.get(k - 1).val;
    // }
    
    
    //solution 2: we use the recursion
//     public int kthSmallest(TreeNode root, int k) {
//         if(root == null || k < 1)
//             throw new IllegalArgumentException();
//         int[] res = new int[1];
//         helper(root, k, res);
//         return res[0];
//     }
    
//     private int count = 0;
//     private void  helper(TreeNode root, int k, int[] res) {
//     	if (root == null) {
// 			return;
// 		}
// 		helper(root.left, k, res);
// 		//如果采用注释的方案会出错，是因为程序return时回到上次循环，此时还没有结束，回到root.right继续递归，此时k的值没有发生变化
// 		//所以改成引用的k或者用count就不会出现问题
// 		//k --;
// 		//if (k == 0) {
		
// 		count ++;
// 		if(count == k) {
// 		    res[0] = root.val;
// 		    return;
// 		}
// 		helper(root.right, k, res);
// 	}

    //solution 3: time complexity T(n) = T(n/2) + O(n) 
    //most important, if we modify the data struct, get number nodes of left tree will only O(1), so time complexity O(logn)
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k < 1)
            throw new IllegalArgumentException();
        return getkthSmallest(root, k);
    }
    //if root is null, which means k is more than the bumber of tree nodes
    private int getkthSmallest(TreeNode root, int k) {
        if(root == null)
            throw new IllegalArgumentException();
        int leftCount = getTreeNodeNumber(root.left);
        if(leftCount + 1 == k)
            return root.val;
        else if(leftCount + 1> k)
            return getkthSmallest(root.left, k);
        else
            return getkthSmallest(root.right, k - leftCount - 1);
    }
    
    private int getTreeNodeNumber(TreeNode root) {
        if(root == null)
            return 0;
        return getTreeNodeNumber(root.left) + getTreeNodeNumber(root.right) + 1;
    }
}
