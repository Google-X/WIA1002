/*
 * 1. Draw the BST based on the input 50, 30, 25, 71, 80, 99, 40, 1, 7, 5. Then, list the items in the order of pre-order, in-order and post-order. 
 */
package T7;

public class BSTOrder {
    public static void main(String[] args) {
        
        // DRAWN
        int[] arr = {50, 30, 25, 71, 80, 99, 40, 1, 7, 5};
        BST<Integer> tree = new BST<>();
        
        for(int i : arr) tree.addNode(i);
        
        System.out.print("Pre-Order\t: ");
        displayTree(tree, BST.PREORDER);
        
        System.out.print("In-Order\t: ");
        displayTree(tree, BST.INORDER);
        
        System.out.print("Post-Order\t: ");
        displayTree(tree, BST.POSTORDER);
        
    }
    
    public static void displayTree(BST<Integer> tree, int a){
        tree.setOrder(a);
        tree.showTree();
        System.out.println();
    }
}
