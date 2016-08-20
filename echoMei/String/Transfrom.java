/**
 * a--97,A--65,依次递增
 问题描述： 判断两个字符串是否是相似字符串，即两个字符串所包含的字符种类相同，相同种类的字符个数也相同
 
 分析： 首先这两个字符串的长度肯定是相等的，判断长度不相等的话直接返回false，在长度相等的情况下，使用固定大小的数组做哈希映射。
 使用字符的asc码值做映射表，不会有冲突，且大小固定，
使用固定长度的数组代替哈希表结构。

知识点：哈希映射，如何选取哈希映射结构。
 */
public class Transfrom {
    public static void main(String[] args){
        System.out.print(chkTransform("abcac", 5, "aabcc", 5));
    }
    public static boolean chkTransform(String A, int lena, String B, int lenb) {
        if(lena != lenb || A == null || B == null)
            return false;

        char[] as = A.toCharArray();
        char[] bs = B.toCharArray();
        //使用字符的asc码值做映射表，不会有冲突，且大小固定，
        //使用固定长度的数组代替哈希表结构。
        int[] map = new int[256]; //new方式创建的数组map初始值为0,不是随机数，为什么是256大小？因为字符的asc码值为0~255
        for(int i =0; i<as.length; i++){
            map[as[i]]++; //字符'a' 或整数 97 。将a映射到数组map索引为97的位置，值为a出现的次数
        }
//打印：
//        for(int i = 0;i< map.length;i++){
//            System.out.print(map[i]+ " ");
//            if(i%10 == 9)
//                System.out.println();
//        }

        for(int i=0; i<bs.length; i++) {
            if(map[bs[i]]-- == 0){ 
                return false;
            }
        }
        return true;


    }
}
