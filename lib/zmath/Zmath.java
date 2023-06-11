package lib.zmath;

import lib.std.StdOut;

public class Zmath {
    
    /**
     * 最基本的对数函数
     * @param num
     * @return
     */
    public static int Zlog2(int num) {
        int ret = 0;

        if (num > 1) {
            while (Zpower(2, ret) <= num) {
                ret++;
            }
            return ret - 1;
        } else {
            return 0;
        }
    }


    /**
     * 最基本的幂函数
     * @param num
     * @param pow
     * @return
     */
    public static int Zpower(int num, int pow) {
        int ret = 1;
        int index;
        for (index = pow; index > 0; index--) {
            ret *= num;
        }

        return ret;
    }


    /**
     * 一个简单的计算阶乘的函数，接收一个整型 N，返回 N!
     * @param N
     * @return
     */
    public static int Zorder(int N) {
        int ret = 1;
        for (int i = N; i > 0; i--) {
            ret *= i;
        }

        return ret;
    }



    /**
     * 快速斐波那契数列！非常快！占用空间非常小！输出绝对准确！
     * @param N
     * @return
     */
    public static long Zquickfib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;

        long[] fibs = new long[3];
        fibs[0] = 1;
        fibs[1] = 1;
        
        for (int i = 2; i < N; i++) {
            fibs[i % 3] = fibs[(i-2) % 3] + fibs[(i-1) % 3];
        }

        return fibs[(N-1) % 3];
    }

    /**
     * 递归型慢速斐波那契数列
     * @param N
     * @return
     */
    public static long fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        
        return fib(N - 1) + fib(N - 2);
    }













    public static void main(String[] args) {
        StdOut.println("Hello Zmath!");

        StdOut.println(Zorder(10));
    }
}
