/*
题目描述： 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。设A节点个数为m， B节点个数为n。

分析：此题的普通解法可归为二叉树的遍历以及匹配问题，时间复杂度为O（m*n）。最优解将问题转换为二叉树序列化为字符串 + kmp算法（最优的字符串匹配算法），时间复杂度可达到O（m+n）

知识点：
1.  二叉树的序列化：指将二叉树以某种遍历方式保存到文件中。
2. 二叉树的遍历： 先序，中序，后序。
3. 二叉树的结构定义
4. KMP算法（不熟)
*/

class TreeNode{ //定义二叉树结构
    int value = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int value){
        this.value = value;
    }
}
public class IdenticalTree {

    public static void main(String[] args){ // test
        TreeNode pt = new TreeNode(5);
        TreeNode p1 = new TreeNode(3);
        TreeNode p2 = new TreeNode(12);
        TreeNode p3 = new TreeNode(7);
        TreeNode p4 = new TreeNode(9);
        TreeNode p5 = new TreeNode(6);
        TreeNode p6 = new TreeNode(8);
        pt.left = p1;
        pt.right =p2;
        p1.left = p3;
        p1.right = p4;
        p2.left = p5;
        p2.right = p6;
        printTreeByPre(pt);

        TreeNode sn = new TreeNode(3);
        TreeNode s1 = new TreeNode(7);
        TreeNode s2 = new TreeNode(9);
        sn.left = s1;
        sn.right = s2;

        boolean result = checkIdenticalTree(pt, sn);
        System.out.println(result);

    }

    public static void printTreeByPre(TreeNode tn){ //先序打印二叉树
        if(tn == null){
            return;
        }
        System.out.println(tn.value);
        printTreeByPre(tn.left);
        printTreeByPre(tn.right);
    }

    public static boolean checkIdenticalTree(TreeNode pt, TreeNode st){
        String ps = serilizeByPre(pt);
        String ss = serilizeByPre(st);

        int res = getIndexOf(ps, ss);
        if(res == -1)
            return false;
        else
            return  true;

    }

    public static String  serilizeByPre(TreeNode head){ //先序遍历序列化二叉树，结果保存在string中。
        if (head == null){
            return "#!";
        }
        String res = head.value + "!"; //先遍历根节点
        res += serilizeByPre(head.left);  //递归调用遍历左子树
        res += serilizeByPre(head.right);  //遍历右子树
        System.out.println(res);
        return res;
    }

    //kmp算法
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray(); //转换为字符数组
        char[] ms = m.toCharArray();
        int[] nextArr = getNextArray(ms);
        int index = 0;
        int mi = 0;
        while (index < ss.length && mi < ms.length) {
            if (ss[index] == ms[mi]) {
                index++;
                mi++;
            } else if (nextArr[mi] == -1) {
                index++;
            } else {
                mi = nextArr[mi];
            }
        }
        return mi == ms.length ? index - mi : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] nextArr = new int[ms.length];
        nextArr[0] = -1;
        nextArr[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < nextArr.length) {
            if (ms[pos - 1] == ms[cn]) {
                nextArr[pos++] = ++cn;
            } else if (cn > 0) {
                cn = nextArr[cn];
            } else {
                nextArr[pos++] = 0;
            }
        }
        return nextArr;
    }
}
