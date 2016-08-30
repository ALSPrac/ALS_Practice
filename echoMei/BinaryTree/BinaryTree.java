/*
实现二叉排序树: 左子树的所有节点值都小于根节点，右子树上所有节点值都大于根节点。
中序遍历二叉排序树会得到有序序列
 */
class Node{
    public int data;
    public Node left;
    public Node right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BinaryTree {
    private Node root;
    public BinaryTree(){
        root = null;
    }
    public void insert(int data){ //将节点插入到二叉排序树中
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
        }
        else{
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if(data<current.data){
                    current = current.left;
                    if(current == null){
                        parent.left = newNode;
                        return;
                    }
                }
                else{
                    current = current.right;
                    if(current == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void buildTree(int[] data){ //将数值输入构建二叉树
        for(int i=0; i<data.length; i++)
            insert(data[i]);
    }
    public void inOrder(Node localRoot){ //中序遍历
        if(localRoot != null){
            inOrder(localRoot.left);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }
    public void inOrder(){
        this.inOrder(this.root);
    }

    public void preOrder(Node localroot){
        if(localroot != null){
            System.out.print(localroot.data + " ");
            preOrder(localroot.left);
            preOrder(localroot.right);
        }
    }
    public void preOrder(){
        this.preOrder(this.root);
    }
    public void postOrder(Node localroot){
        if(localroot != null){
            postOrder(localroot.left);
            postOrder(localroot.right);
            System.out.print(localroot.data + " ");
        }
    }
    public void postOrder(){
        this.postOrder(this.root);
    }
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        int[] data = {2,8,7,4,9,3,1,6,7,5};
        bt.buildTree(data);
        System.out.println("中序遍历：");
        bt.inOrder();
        System.out.println();
        System.out.println("先序遍历：");
        bt.preOrder();
        System.out.println();
        System.out.println("后序遍历：");
        bt.postOrder();
        System.out.println();


    }
}
