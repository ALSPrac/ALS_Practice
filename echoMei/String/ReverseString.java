/**
 * 问题描述：将一个以空格分隔的字符串逆转，如pig loves dog逆转为 dog loves pig。
 
 分析： 先将此字符串拆分为字符串数组，以空格为准拆分，然后将此字符串数组中的字符串逆序输出，采用的方法是头尾互换，然后将逆转之后的字符串数组重新拼接为字符串。
 时间复杂度为 O(n*n/2)
 
 */
public class ReverseString {
    public static void main(String[] args){
        System.out.print(reverseSentence("TUM MKIALI KVJUBEN VBSEWFT JAD AIZWEL CP LG PTB", 47));
    }

    public static String reverseSentence(String A, int n) {
        if(n==0)
            return null;
        String[] stringArray = A.split(" "); //拆分为字符串数组
        String temp;
        int len = stringArray.length;
        for(int i = 0; i< len/2; i++){ //字符串数组头尾互换
            temp = stringArray[i];
            stringArray[i] = stringArray[len-1-i];
            stringArray[len-1-i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for(int s = 0; s < stringArray.length; s++){ //拼接，需重新加上空格
            sb.append(stringArray[s]);
            if(s != stringArray.length-1) //如果是最后一个字符串，就不要添加空格了，这样会造成比原来的字符串多一个空格
                sb.append(" ");
        }
        System.out.println(sb.length());
        return sb.toString();
    }
}
