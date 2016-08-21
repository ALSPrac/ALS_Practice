/**
 * 注意：队列是先进先出的。而且这个模拟的是单端队列
 * 题目描述： 使用两个栈模拟队列，输入的整数数组中若元素大于0，则入队列，若等于0则出队列。
 *
 * 注意两点 ：stackPush中的数据倒入stackPop中时，必须将stackPush中的数据一次性全部倒入，不能只倒入一部分，
 * 并且如果StackPop中有数据，则不能进行压栈操作。
 */
import java.util.Stack;
public class TwoStack {

    private Stack<Integer> stackPush = new Stack<Integer>(); //第一个栈存放元素入栈顺序。
    private Stack<Integer> stackPop = new Stack<Integer>();   //第二个栈存放元素出栈顺序，

    public static void main(String[] args){
        TwoStack ts = new TwoStack();
        int a[] = {1,2,3,0,4,0};
        for(int e : ts.twoStack(a,6))
            System.out.println(e);
    }

    public void queuePush(int a){
        stackPush.push(a);

    }
    public int queuePop(){
        int elem ;
        if(stackPop.empty()){ //要点一： 先判断stackPop是否为空，为空 才入栈
            while(!stackPush.empty()) { //要点二： 将stackPush中的所有元素依次都压入stackPop中。
                elem = stackPush.pop();
                stackPop.push(elem);
            }
            return stackPop.pop();
        }
        else{
            return stackPop.pop();
        }

    }
    public int[] twoStack(int[] ope, int n) {
        int index=0;
        for(int i=0;i<n;i++){
            if(ope[i]>0){
                queuePush(ope[i]);
            }
            else if(ope[i]==0){
                ope[index] = queuePop();
                index++;
            }
        }
        int[] result = new int[index];
        for(int i=0;i<index;i++){
            result[i] = ope[i];
        }
        return result;
    }

}
