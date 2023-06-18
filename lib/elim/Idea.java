package util.elim;

import java.time.*;

public class Idea extends MetaIdea{

    public Idea(String name) {
        super(name);
    }

    public void uploadToDatabase() {

    }


    /**
     * 为构造方法 {@code public Idea(String name)} 设计的隐私方法，将时间拆包这一过程抽象到其他函数中
     * @param t
     * @return 一个数组，分别存放年份、月份等整型数据
     * @deprecated
     */
    private int[] getDateTimeIntValues() {
        LocalDateTime dt = LocalDateTime.now();
        int year = dt.getYear(); // 返回年份
        int month = dt.getMonthValue(); // 返回月份的数值
        int dayOfMonth = dt.getDayOfMonth(); // 返回日期
        int dayOfWeek = dt.getDayOfWeek().getValue(); // 返回周几
        int hour = dt.getHour();
        int minute = dt.getMinute();
        int second = dt.getSecond();

        int[] ret = {
            year, month, dayOfMonth, dayOfWeek, hour, minute, second
        };

        return ret;
    }
}
