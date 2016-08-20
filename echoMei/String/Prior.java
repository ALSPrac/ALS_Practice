/**
 问题描述：对于一个给定的字符串数组，找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的最小字典序的字符串。
 
 分析：单个比较数组中字符串的做法不可取，有些case无法覆盖。eg：{“ba”, "b"},如果单独比较ba 和b,结果是bba,而实际上字典序最小的拼接应该是bab.
 所以应比较拼接之后的大字符串的字典序,即 str1+ str2 与 str2+str1的大小
 时间复杂度： O(n)
 
 知识点：
 1. 如何实现自己的比较器函数：实现Comparator<String>接口，覆盖compare方法为自己的比较规则。
 2. 使用Arrays静态类对数组进行排序。
 
 测试样例：
 ["abc","de"],2
 "abcde"
 */
public class Prior {
    public static void main(String[] args){
        String[] test = {"acd", "be", "adc"};
        System.out.print(findSmallest(test, 3));
    }
    
    public static class MyComparator implements Comparator<String> { //自定义一个比较器，重写compare方法
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }
    public static String findSmallest(String[] strs, int n) {
        if (strs == null || n == 0) {
            return "";
        }
        // 根据新的比较方式排序
        Arrays.sort(strs, new MyComparator()); //对字符数组进行排序，排序规则是两字符串拼接比较字典序，排好的顺序就是要拼接的顺序
        String res = "";
        for (int i = 0; i < n; i++) {
            res += strs[i]; //拼接
        }
        return res;
    }
}
