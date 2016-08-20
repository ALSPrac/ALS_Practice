/**
题目描述： 将字符串中的空格全部替换为“%20”，字符串必须由大小写组成
给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。

分析：逐个遍历字符串中的每一个字符，若为空格则替换为 %20, 主要是使用StringBuilder数据结构。
时间复杂度为O(n).

 测试样例：
 "Mr John Smith”,13
 返回："Mr%20John%20Smith"
 ”Hello  World”,12
 返回：”Hello%20%20World”
 */
public class ReplaceString {

    public static void main(String[] args){
        System.out.print(replaceSpace("hello  world my lover", 21));
    }
    public static String replaceSpace(String iniString, int length) {
        StringBuilder sb = new StringBuilder();
        for(int i =0;i< length;i++){
            if (iniString.charAt(i) != ' ')
                sb.append(iniString.charAt(i));
            else
                sb.append("%20");
        }
        return sb.toString(); //StringBuilder与String是不同的类型，记得转换。
    }
}
