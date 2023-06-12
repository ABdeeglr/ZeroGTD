package lib.elim;

import lib.std.StdTime;
/**
 * 被捕获的想法
 */
public class Idea {
    private String message; // 额外信息
    private String name; // 名称
    private String id; // 唯一 ID
    private String father_id; // 父想法的 ID
    private int locateTimeChunk; // 所在的时间区块

    
    public Idea(String name, String message) {
        this.name = name;
        this.message = message;
        StdTime rightNow = new StdTime();
        this.id = "" + rightNow.year + rightNow.month + rightNow.day + rightNow.hour + rightNow.minute + rightNow.second;
        this.father_id = "x";
        this.locateTimeChunk = 49;
    }
}
