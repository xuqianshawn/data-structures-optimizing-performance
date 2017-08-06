package leetCode;
import java.lang.reflect.Array;
import java.util.*;
public class serializeTree {
	 public static TreeNode deserializeTree(String treeStr){
		 String[] treeVals=treeStr.split(",");
		TreeNode root=new TreeNode(-1);
		populateTree(root,treeVals,0);
		 return root;
	 }
	 private static void populateTree(TreeNode t, Object[] resultArry, int number)
	 {
		 t.val=Integer.parseInt(resultArry[number].toString());
		 if((2*number+1)<resultArry.length)
		 {
			 if(!resultArry[2*number+1].equals("-1"))
			 {
			  TreeNode tmp=new TreeNode(-1);
			  t.left=tmp;
			 populateTree(tmp,resultArry,2*number+1);
			 }			 
		 }
		 if((2*number+2)<resultArry.length)
		 {
			 if(!resultArry[2*number+2].equals("-1"))
			 {
			  TreeNode tmp=new TreeNode(-1);
			  t.right=tmp;
			 populateTree(tmp,resultArry,2*number+2);
			 }			 
		 }
	 }
    public static String serializeTree(TreeNode t){
    Object[] resultArry=new Object[50];	
    Arrays.fill(resultArry, -1);
    populateArray(t,resultArry,0);
    String resultArrayString="";
    int actualCountOfTree=0;
    for(int i=0;i<50;i++)
    {
    	if(Integer.parseInt(resultArry[i].toString())!=-1)
    	{
    		actualCountOfTree=i+1;
    	}  		
    }
    for(int j=0;j<actualCountOfTree;j++)
    {
    	
    	resultArrayString=resultArrayString+resultArry[j]+",";
    }
    System.out.println(actualCountOfTree);
    resultArrayString=resultArrayString.substring(0, resultArrayString.length()-1);
    return resultArrayString;	
    }
    
    private static void populateArray(TreeNode t, Object[] resultArry, int number)
    {
    	resultArry[number]=t.val;
    	if(t.left!=null){
    	populateArray(t.left,resultArry,number*2+1);
    	}
    	if(t.right!=null){
    	populateArray(t.right,resultArry,number*2+2);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TreeNode t1=new TreeNode(1);
        TreeNode t3=new TreeNode(3);
        TreeNode t2=new TreeNode(2);
        TreeNode t5=new TreeNode(5);
        t1.left=t3;
        t1.right=t2;
        t2.right=t5;
        String treeStr=serializeTree(t1);
        System.out.println(treeStr);
        TreeNode root=deserializeTree(treeStr);
	}

}
