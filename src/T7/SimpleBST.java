/*
 * 2. Create the BSTNode.java and BST.java file (only the methods required based on the lecture notes).  Then, perform the following: 
a. Insert the characters F, A, C, U, L, T, and Y into the BST
b. Print the number of elements in the BST
c. Display the BST elements (PREORDER, INORDER, POSTORDER) 
d. Remove character L from BST 
e. Display the BST elements (PREORDER, INORDER,POSTORDER)

Example output: 

The number of elements in the tree : 7
The tree elements - PREORDER : F --> A --> C --> U --> L --> T --> Y --> 
The tree elements - INORDER : A --> C --> F --> L --> T --> U --> Y --> 
The tree elements - POSTORDER : C --> A --> T --> L --> Y --> U --> F -->

Remove 1 Character L
The number of elements in the tree : 6
The tree elements - PREORDER : F --> A --> C --> U --> T --> Y --> 
The tree elements - INORDER : A --> C --> F --> T --> U --> Y --> 
The tree elements - POSTORDER : C --> A --> T --> Y --> U --> F -->

*/
package T7;

public class SimpleBST {
    public static void main(String[] args) {
        
        String str = "FACULTY";
        BST<Character> tree = new BST<>();
        
        for(char c : str.toCharArray()) tree.addNode(c);
        displayTree(tree);
        
        System.out.println("Remove 1 Character L");
        tree.remove('L');
        displayTree(tree);
    }
    
    public static void displayTree(BST<Character> tree){
        System.out.println("The number of elements in the tree : " + tree.getSize());
        System.out.print("The tree elements - PREORDER : ");
        tree.setOrder(BST.PREORDER);
        tree.showTree();
        
        System.out.print("\nThe tree elements - INORDER : ");
        tree.setOrder(BST.INORDER);
        tree.showTree();
        
        System.out.print("\nThe tree elements - POSTORDER : ");
        tree.setOrder(BST.POSTORDER);
        tree.showTree();
        System.out.println("\n");
        
    }
}
