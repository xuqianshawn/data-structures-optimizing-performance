package leetCode;

public class Node {
    private Node leftChild, rightChild;
    
    public Node(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    
    public Node getLeftChild() {
        return this.leftChild;
    }
    
    public Node getRightChild() {
        return this.rightChild;
    }

    public int height() {
    	     if(leftChild==null&&rightChild==null)
    	     {
    	    	 return 0;
    	     }
             /* compute the depth of each subtree */
             int lDepth =0;
             if(leftChild!=null)
            	 lDepth=leftChild.height();
             int rDepth = 0;
             if(rightChild!=null)
            	 rDepth=rightChild.height();
   
             /* use the larger one */
             if (lDepth > rDepth)
                 return (lDepth + 1);
              else
                 return (rDepth + 1);
         
    }

    public static void main(String[] args) {
        Node leaf1 = new Node(null, null);
        Node leaf2 = new Node(null, null);
        Node node = new Node(leaf1, null);
        Node root = new Node(node, leaf2);

        System.out.println(root.height());
    }
}