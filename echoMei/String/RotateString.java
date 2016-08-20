/**
 问题描述：判断字符串A与B是否互为旋转词,选装字符串是指将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。
 
 算法思想：将其中任何一个字符串与自身拼接形成一个大字符串，此字符串穷举了所有互为旋转词的字串，所以只需判断另一个字符串是否是大字符串
 的一个子串即可。
 字符串匹配其实应该用KMP算法，我用了contains函数，图方便 = =。
  
注意在编程之前要考虑边界情况。
 */
public class RotateString {
    public static void main(String[] args){
        System.out.println(chkRotation("121345",6, "123451", 6));
    }
    public static boolean chkRotation(String A, int lena, String B, int lenb) {
        if(lena != lenb)
            return false;
        String sb= A + A;
        if(sb.contains(B))
            return true;
        return false;
    }
}
