package lib.elim;

import lib.std.StdTime;

import java.time.LocalDateTime;

/**
 * @author ABdeeglr
 * 
 * @基本字段
 * 
 * 基本字段包含名称和创建日期数据，各项数据原子化以便调用
 * 
 */
public class MetaIdea {
    
    // 基本字段
    protected String name;
    protected long create_TimeStamp;
    protected String create_Time;
    protected String create_Date;
    protected int create_Year;
    protected int create_Month;
    protected int create_DayOfMonth;
    protected int create_DayOfWeek;
    protected int create_Hour;
    protected int create_Minute;
    protected int create_Second;

    public MetaIdea(String name) {
        this.name = name;
        LocalDateTime dt = LocalDateTime.now();
        this.create_Year = dt.getYear(); // 返回年份
        this.create_Month = dt.getMonthValue(); // 返回月份的数值
        this.create_DayOfMonth = dt.getDayOfMonth(); // 返回日期
        this.create_DayOfWeek = dt.getDayOfWeek().getValue(); // 返回周几
        this.create_Hour = dt.getHour();
        this.create_Minute = dt.getMinute();
        this.create_Second = dt.getSecond();
    }

    public String getName() {
        return this.name;
    }

    public long getCreate_TimeStamp() {
        return this.create_TimeStamp;
    }

    public String getCreate_Time() {
        return this.create_Time;
    }

    public String getCreate_Date() {
        return this.create_Date;
    }

    public int getCreate_Year() {
        return create_Year;
    }

    public int getCreate_Month() {
        return create_Month;
    }

    public int getCreate_Day() {
        return create_DayOfMonth;
    }

    public int getCreate_Hour() {
        return create_Hour;
    }

    public int getCreate_Minute() {
        return create_Minute;
    }

    public int getCreate_Second() {
        return create_Second;
    }

    public int getCreate_Weekday() {
        return create_DayOfWeek;
    }

    public void resetName(String newName) {
        this.name = newName;
    }
}
