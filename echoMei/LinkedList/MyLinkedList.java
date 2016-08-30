import java.util.Stack;

class Node{
    Node next = null;
    int data;
    public Node(int data){
        this.data = data;
    }
}
public class MyLinkedList {
    Node head = null; //链表头结点引用

    public void addNode(int d){ //在链表末尾插入数据
        System.out.println("----add node:" + d);
        Node newNode = new Node(d);
        if (head == null){
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    public Boolean deleteNode(int index){ //删除索引index处的节点
        if(index<0 || index > myLength()){
            return false;
        }
        if(index == 1){
            head = head.next;
            return true;
        }
        int i=1;
        Node preNode = head; //设置两个指针，两指针相邻
        Node curNode = preNode.next; //curNode索引为index的节点，待删
        while(curNode != null){
            if(i == index){ //i负责计数
                preNode.next = curNode.next; //删除，只需改变next域的值
                return true;
            }
            preNode = curNode; //两指针同时往后移，直至找到待删节点
            curNode = curNode.next;
            i++;
        }
        return true;
    }

    public int myLength(){ //返回链表长度
        int length = 0;
        Node tmp = head;
        while(tmp != null){
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    public Node orderList(){ //对链表进行插入排序，返回排序后的头结点
        Node nextNode = null;
        int temp = 0;
        Node curNode = head;
        while(curNode.next != null){ //将curNode与后面每一个节点都进行比较，找到最大的，然后curNode后移一个，再继续进行这样的比较，找到第二大的
            nextNode = curNode.next;  //时间复杂度为O（length*length）
            while (nextNode != null){
                if(curNode.data > nextNode.data){
                    temp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }
    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    /*
    删除链表中的重复元素，方法一：遍历列表把所有的值存储到一个Hashtable中，在遍历过程中，若当前访问的值在Hashtable中已存在，则删除
    优点：时间复杂度低，不足之处在于需要额外的存储空间。
    方法二： 对链表进行双层循环遍历，外循环正常遍历，假设外循环当前节点为cur，内循环从cur开始遍历，若碰到与cur所指向的节点值相同，则删除，
    此方法不需要额外的存储空间，但是时间复杂度比较高。
     */
    public void deleteDuplicate(){
        Node p = head;
        while (p!=null){
            Node q = p;
            while (q.next != null){
                if(p.data == q.next.data){
                    q.next = q.next.next;
                }
                else{
                    q = q.next;
                }
            }
            p = p.next;
        }
    }

    public Node findElem( int k){ //找出链表中倒数第K个元素
        /*
        普通的算法是将倒数第k个元素转换为正数第n-k个元素，为此需要两次遍历，第一次遍历求出链表的长度，第二个遍历到n-k处。
        更高效的算法是： 只需一次遍历。设置两个指针，一个指针比另一个指针先移动 k-1 步，然后两个指针同时往前走，
        前面指针到达链表末尾时，后一个指针的位置就是倒数第k个节点
         */
        int n = k;
        Node later = head;
        Node prev = head;
        while( n <= k-1){
            n--;
            prev = prev.next;
            while (prev != null){
                later = later.next;
                prev = prev.next;
            }
        }
        return later;
    }

    public void reverseList(){ //逆转列表的意思是将链表next域的指向改变,非递归实现链表反转。
        Node pReversedHead = head;
        Node pNode= head;
        Node pPrev = null;
        while(pNode != null) {
            Node pNext = pNode.next;
            if (pNext == null)
                pReversedHead = pNode;
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        this.head = pReversedHead;
    }
    /*
    从尾到头输出单链表：
    方法一：从头到尾遍历单链表，每经过一个节点，就把该节点压入栈中，当遍历完链表后从栈顶开始输出节点
    方法二： 采用递归，每访问一个栈，先递归输出后面的节点再输出此节点本身。
     */
    public void printListReverseWithStack(){
        Node p = head;
        Stack<Node> stack = new Stack<Node>();
        while(p != null){
            stack.push(p);
            p = p.next;
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop().data);
        }
    }
    public void printListWithDIGUI(Node pListHead){

        if(head != null){
            printListWithDIGUI(head.next);
            System.out.println(head.data);
        }
    }
    /*
    寻找单链表的中间节点: 设置两个指针，快指针一次走两步，慢指针一次走一步，快指针先到达链表尾部，慢指针则恰好到达链表中部
    链表长度为奇数：慢指针指向即是链表的中间节点，链表长度为偶数，慢指针和慢指针的下一个节点就是链表的中间节点
     */
    public Node searchMid(){
        Node p = head;
        Node q = head;
        while(p != null && p.next !=null && p.next.next != null){
            p = p.next.next;
            q = q.next;
        }
        return q;
    }

    /*
    检测链表是否有环：定义两个指针fast和slow，初始值都指向链表头，slow每次向前移动一步，fast向前移动两步，两指针同时向前移动
    快指针每移动一次都要跟慢指针比较，若快指针等于慢指针为止，就证明此链表是带环的单向链表。否则，此链表就是不带环的循环链表。
    fast先行到达尾部为NULL，则为无环链表。
     */
    public boolean isLoop(){
        Node fast =head;
        Node slow =head;
        if(fast == null){
            return false;
        }
        while(fast != null || fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return !(fast == null || fast.next == null); //无环
    }
    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList();

        list.addNode(3);
        list.addNode(1);
        list.addNode(8);
        list.addNode(3);
        list.addNode(7);
        System.out.println("listlen = " + list.myLength());
        System.out.println("Before order: ");
        list.printList();

        System.out.println("delete duplicate:");
        list.deleteDuplicate();
        list.printList();

        System.out.println("find the elem reverse:");
        System.out.println(list.findElem(2).data);

        System.out.println("after order:");
        list.orderList();
        list.printList();

        System.out.println("print reversely:");
        list.printListReverseWithStack();

    }
}
