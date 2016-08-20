/*
 题目描述：对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 
 分析：设置一个变量num，当字符为'('时，num加1，当字符为')'时， num减1，当出现非括号字符时，需判断num是否为0，若为0，说明当前括号完全是匹配的，
 源字符串就不合法，若num不为0，需继续判断。（理由： 因为字符串是从左到右依次扫描，若num为0，说明非括号字符不在括号内就不合法）。
 时间复杂度： O(n)
 也可以用栈解决。
 
 测试样例：
 "(()())",6
 返回：true
 测试样例：
 "()a()()",7
 返回：false
 测试样例：
 "()(()()",7
 返回：false
 */
public class Parenthesis {
    public  static void main(String[] args){
        System.out.print(chkParenthesis("()()()",6));
    }
    /*
    检查括号是否匹配，A为字符串，n为字符串的长度。
    */
    public static boolean chkParenthesis(String A, int n) {
        int num = 0;
        for(int i=0;i<n;i++){
            if(A.charAt(i) == '(')
                num++;
            if (A.charAt(i) == ')')
                num--;
            if (A.charAt(i) != '(' && A.charAt(i) != ')' && num == 0) //非括号字符的case
                return false;
        }
        if(num != 0) // num不为0，说明左括号与右括号个数不匹配
            return false;
        else
            return true;
    }
}
