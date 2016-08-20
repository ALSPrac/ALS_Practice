/**
 * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
 
 其实就是两个字符串的逆转，根据要移动的前缀长度，将字符串分割为两个子字符串，然后交换位置就可以了
 分析： 主要是使用String的 substring函数，不会截取后面索引的字符。
 和concat函数。
 */
public class Translation {
    public static void main(String[] args){
        System.out.println(stringTranslation("abcde", 5, 3));
    }
    public static String stringTranslation(String A, int n, int len) { //A表示要移位的字符串，n表示A的长度，len表示要移位的前缀字符串的长度。
        String frontString = A.substring(0, len); // 0..3 abc
        String endString = A.substring(len, n); //3.. 5    de
        //System.out.println(frontString + "   " + endString);
        return endString.concat(frontString);
    }
}
