package leetCode;

public class MergeTwoTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1==null)
        {
        	return t2;
        }
		if(t2==null)
        {
        	return t1;
        }
		TreeNode temp = new TreeNode(0);
		temp.val=Integer.parseInt(t1.val.toString())+Integer.parseInt(t2.val.toString());
		temp.left=mergeTrees(t1.left, t2.left);
		temp.right=mergeTrees(t1.right, t2.right);
		return temp;
	}
}
