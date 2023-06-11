package lib.algs.sort;


import java.util.Arrays;
import java.lang.Math;

public class BubbleSort {

    public static void main(String[] args) {
        int i = 0;
        int[] arry = new int[100];
        for (i = 0; i < 100; i ++) {
            // arry[i] = StdRandom.uniformInt(1000); // 使用 StdRandom 生成随机数
            arry[i] = (int) (Math.random() * 1000);
        }

        String bef = Arrays.toString(arry);
        System.out.println(bef);
        int[] sdd = sortInts(arry);
        String aft = Arrays.toString(sdd);
        System.out.println(aft);
    }



    /**
     * Basic sort algorithm, a sample for bubble sort.
     * @param nums
     * @return {@code int[] ret}
     */
    public static int[] sortInts(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        
        int i; // 外层循环
        int j; // 内层循环
        int temp; // 交换变量

        // 拷贝数组
        for (i = 0; i < len; i++) {
            ret[i] = nums[i];
        }

        for (i = 0; i < len; i++) {
            for (j = 0; j < len - 1 - i; j++) {
                if (ret[j] > ret[j+1]) {
                    temp = ret[j+1];
                    ret[j+1] = ret[j];
                    ret[j] = temp;
                } 
            }
        }

        return ret;
    }



    /**
     * 冒泡排序 泛型版 未完成
     * @param nums
     * @return
     */
    public static Object[] sortBubble(Object[] nums) {
        Object[] ret = new Object[100];

        return ret;
    }
}
