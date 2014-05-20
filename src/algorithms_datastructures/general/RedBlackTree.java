package algorithms_datastructures.general;

public class RedBlackTree {    
    public enum Color {RED, BLACK};
    private Node root;
    public String print(){
        String r=print(root);
        if(r.endsWith(", "))
            return "["+ r.substring(0,r.length()-2)+"]";
        return "[]";
    }    
    private String print(Node node) {
        if(node==null)
            return "";
        return print(node.left)+node+", "+ print(node.right);
    }
    private Node rotateRight(Node h) {
        Node x=h.left;
        h.left=x.right;
        x.right=h;
        x.color=h.color;
        h.color=Color.RED;
        return x;
    }
    private Node rotateLeft(Node h) {
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        x.color=h.color;
        h.color=Color.RED;
        return x;
    }
    private void flipColor(Node node){
        node.color=Color.RED;
        node.left.color=Color.BLACK;
        node.right.color=Color.BLACK;
    }
    public void add(int val){
        root=add(root,val);    
    }
    private Node add(Node node, int val) {
        if(node==null)
            return new Node(val);
        if(node.val>val)
            node.left=add(node.left,val);
        else if(node.val<val)
            node.right=add(node.right,val);
        
        if(isRed(node.right))// && !isRed(node.left)){
            node=rotateLeft(node);
        if(isRed(node.left) && isRed(node.left.left))
            node=rotateRight(node);
        if(isRed(node.left) && isRed(node.right))
            flipColor(node);
        return node;
    }
    private boolean isRed(Node node){
        if(node == null)
            return false;
        return node.color==Color.RED;
    }
    private class Node{
        int val;    
        Color color;
        Node left, right;
        public Node(int val){
            this.val=val;
            this.color=Color.RED;
        }
        public String toString(){
            return String.valueOf(val);
        }
    }
}