/*
实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
测试样例：
[4,3,2,1],4
返回：[1,2,3,4]
 */
public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        if(n == 0)
            return A;
        else{
            int cur = getStackBottom(A,n);
            n--;
            reverseStack(A,n);
            A[n] = cur;
            return A;
        }
    }
    public int getStackBottom(int[] A,int n){
        int result = A[n-1];  //A[5] = 6
        n--;         //n=5
        if(n == 0){ //表示到栈底，返回栈底元素
            return result;
        }
        else{
            int cur = getStackBottom(A,n); // getStackBottom(A,5) -->getStackBottom(A,4)-->getStackBottom(A,3)...最终返回1
            A[n-1] = result;
            return cur;
        }
    }
    public static void main(String[] args){
        StackReverse sr = new StackReverse();
        int[] a = new int[]{1,2,3,4,5,6};  //a已经代表一个给定的栈，所以不需要重新 new Stack.
        a = sr.reverseStack(a,6);
        for(int i:a)
            System.out.println(i);

    }
}
