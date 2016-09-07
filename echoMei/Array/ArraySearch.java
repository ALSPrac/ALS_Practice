
/*
题目描述： 在一个二维数组中，每一行都按照从左到右递增的顺序排列，每一列是从上到下递增的顺序排列
输入一个这样的二维数组和数字，判断该数字是否在这个二维数组中。

算法描述： 首先选取右上角的数，与待查数比较，若相等，则返回，若比待查数大，则剔除该数所在的列，若比待查找的数小
则剔除出该数所在行。即待查数如果不在数组的右上角，则每一次查找在数组的查找范围中剔除一行或一列，这样可以缩小查找范围。
 */
public class ArraySearch {
    public static boolean isFind(int[][] a, int rows, int columns, int number){ //rows表示行数，columns表示列数
        boolean found = false;
        if(a != null && rows >0 && columns >0 ){
            int row = 0; //行指针
            int column = columns - 1; //列指针
            while (row < rows && column >=0){
                if(a[row][column] == number){
                    found =true;
                    break;
                }
                else if(a[row][column] > number)
                    --column;
                else
                    ++row;
            }
        }
        return found;
    }
    public static void main(String[] args){
        int test[][] = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean res = ArraySearch.isFind(test, 4,4,14);
        System.out.println(res);
    }
}
