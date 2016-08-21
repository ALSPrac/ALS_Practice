/*
题目描述：定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

分析：使用java util包中的Stack。要返回栈中最小的元素，需要两个栈结构，一个data保存栈中数据，
另一个min保存数据中的最小值。（也可以直接用一个变量保存最小值啊，当出现更小值重新赋值就行。）
具体操作有两种方法，
方法一，当元素压栈进入data时，需要与min的栈顶元素进行比较，
如果比min的栈顶元素小，则min将栈顶元素弹栈，然后将较小的元素压入min中，反之如果data中压栈的元素比min的栈顶元素大，
则min不进行任何操作，这样，min中始终保存的都是data中最小的值。

第二种方法，是data与min同步进行压栈操作。当data要压栈的元素大于min的栈顶元素时，min将栈顶元素重新压栈一次（也可以什么都不做啊），
反之，min将较小元素压入，依次进行。

这两种方法的关键都是在元素进入data中时需要与min的栈顶元素进行比较。
两种方法的时间复杂度都是O(1),不过方法一的弹栈操作需要浪费点时间，方法二因为是进行同步压栈，所以压栈操作会花费点时间。

今天才醒悟的一点是：java中的方法调用，要么是静态方法直接调用，要么通过实例化一个对象，通过对象调用，
特别是在静态的main方法中调用非静态的方法，最好是通过对象调用，否则需要将调用的方法改为static方法。
 */
import java.util.Stack;
public class StackUsage {
    private Stack<Integer> data = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();
    public static void main(String[] args){
        StackUsage su = new StackUsage();
        su.push(1);
        su.push(4);
        su.push(8);
        su.push(11);

        su.pop();

        System.out.println(su.top());

        System.out.println(su.min());
    }

    public void push(int node) {
        data.push(node);
        if(min.empty() || min.peek() >= node){
            min.push(node);
        }
        else {
            //方法一： doNOthing
            //方法二：
            min.push(min.peek());
        }
    }

    public void pop() {
        if (data.empty()){
            throw new RuntimeException("Stack is Empty!");
        }
        if(data.peek() == min.peek())
            min.pop();
        data.pop();
    }

    public int top() {
        if(data.empty())
           return -1;
        return data.peek();

    }

    public int min() {
        if (min.empty()){
            throw new RuntimeException("Stack is Empty!");
        }
        return min.peek();
    }
}
