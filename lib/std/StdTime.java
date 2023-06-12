package lib.std;

public class StdTime {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private int mill;
    private int weekday;
    private int weelNumber;

    /**
     * 获取一个标准时间(GMT)对象
     */
    public StdTime() {
        int[] daysAndTime = subStdTimeFunction.timeFormat();
        this.hour = daysAndTime[1];
        this.minute = daysAndTime[2];
        this.second = daysAndTime[3];
        this.mill = daysAndTime[4];

        int[] yearsMonthsDaysAndWeeks = subStdTimeFunction.daysFormat(daysAndTime[0]);
        this.year = yearsMonthsDaysAndWeeks[0];
        this.month = yearsMonthsDaysAndWeeks[1];
        this.day = yearsMonthsDaysAndWeeks[2];
        this.weekday = yearsMonthsDaysAndWeeks[3];
        this.weelNumber = yearsMonthsDaysAndWeeks[4];
    }

    @Override
    public String toString() {
        String ret = "";
        ret = year + "-" + month + "-" + day;
        ret += " | " + hour + ":" + minute + ":" + second;
        return ret;
    }

    /**
     * Only for driver test.
     * @param args
     */
    public static void main(String[] args) {
        int[] sample = subStdTimeFunction.timeFormat();
        int[] tex = subStdTimeFunction.daysFormat(sample[0]);
        System.out.printf("It's %d now, today is %d %d.\n", tex[0], tex[1], tex[2]);
        System.out.printf("Now is %d:%d:%d.\n", sample[1], sample[2], sample[3]);
        System.out.println("Today is weekday-" + tex[3]);
    }

    /**
     * 为了消除 mill, weekday, weeknumber 这三个没有使用到的属性的警告设置的方法
     * @deprecated
     */
    public void doNothing() {
        var nwed = this.mill + this.weekday + this.weelNumber;
        System.out.println(nwed);
    }
}

/**
 * subStdTimeFunction 是辅助 StdTime 的静态方法类
 * 
 * @Statement
 *            提供对时间戳进行格式化的静态方法
 * 
 */
class subStdTimeFunction {

    private static final int[] daysList = {
            365, 365, 366, 365, // 1973
            365, 365, 366, 365, // 1977
            365, 365, 366, 365, // 1981
            365, 365, 366, 365, // 1985
            365, 365, 366, 365, // 1989
            365, 365, 366, 365, // 1993
            365, 365, 366, 365, // 1997
            365, 365, 366, 365, // 2001
            365, 365, 366, 365, // 2005
            365, 365, 366, 365, // 2009
            365, 365, 366, 365, // 2013
            365, 365, 366, 365, // 2017
            365, 365, 366, 365, // 2021
            365, 365, 366, 365, // 2025
            365, 365, 366, 365, // 2029
    };

    private static final int[] commonYearDaysDistribution = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    private static final int[] leapYearDaysDistribution = {
            31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    /**
     * 通过当前时间戳常量格式化时间
     * 
     * @return {@code days, hours, minutes, seconds, mills}
     */
    public static int[] timeFormat() {
        long rightNow = System.currentTimeMillis();
        int mills = (int) (rightNow % 1000);
        rightNow = (rightNow - mills) / 1000; // 缩放为秒
        int timepiece = (int) (rightNow % 3600);
        int seconds = timepiece % 60; // 获取秒数
        int minutes = timepiece / 60; // 获取分钟数
        rightNow = (rightNow - timepiece) / 3600; // 缩放为小时
        int hours = (int) (rightNow % 24); // 获取小时数
        int days = (int) ((rightNow - hours) / 24); // 缩放为日

        int[] ret = { days, hours, minutes, seconds, mills };
        return ret;
    }

    /**
     * 通过给定的时间戳常量获取格式化时间
     * 
     * @return {@code days, hours, minutes, seconds, mills}
     */
    public static int[] timeFormat(long timeMills) {
        long rightNow = timeMills;
        int mills = (int) (rightNow % 1000);
        rightNow = (rightNow - mills) / 1000; // 缩放为秒
        int timepiece = (int) (rightNow % 3600);
        int seconds = timepiece % 60; // 获取秒数
        int minutes = timepiece / 60; // 获取分钟数
        rightNow = (rightNow - timepiece) / 3600; // 缩放为小时
        int hours = (int) (rightNow % 24); // 获取小时数
        int days = (int) ((rightNow - hours) / 24); // 缩放为日

        int[] ret = { days, hours, minutes, seconds, mills };
        return ret;
    }

    /**
     * 将一个整数变为一个数组，分别存放年，月，日，星期几
     * 
     * @return {@code year, month, day, weekday, weeknumber}
     */
    public static int[] daysFormat(int days) {
        int year = 1970;
        int month = 0;
        int day = 0;
        int weekday = (days + 4) % 7;
        int weeknumber = 0;

        int i = 0;
        while (days > 365) {
            days -= daysList[i];
            i++;
        }

        year += i;

        if (i % 4 == 2) {
            int daysSum = 0;
            while (daysSum <= days) {
                daysSum += leapYearDaysDistribution[month];
                month++;
            }
            for (i = 0; i < month; i++) {
                days -= leapYearDaysDistribution[i];
            }
            day = days + leapYearDaysDistribution[i];
        } else {
            int daysSum = 0;
            while (daysSum <= days) {
                daysSum += commonYearDaysDistribution[month];
                month++;
            }
            for (i = 0; i < month; i++) {
                days -= commonYearDaysDistribution[i];
            }
            day = days + commonYearDaysDistribution[i];
        }

        int ret[] = { year, month, day, weekday, weeknumber };
        return ret;
    }
}