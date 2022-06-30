package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

// 每个 model.Blog 对象, 对应 blog 表里的一条记录
public class Blog {
    private int blogId;
    private String title;
    private String content;
    private int userId;
    private Timestamp postTime;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    public Timestamp getPostTime() {
//        return postTime;
//    }

    // 把这里的 getter 方法给改了, 不是返回一个时间戳对象, 而是返回一个 String (格式化好的时间)
    public String getPostTime() {
        // 使用 SimpleDateFormat 来完成时间戳到格式化日期时间的转换.
        // 这个转换过程, 需要在构造方法中指定要转换的格式, 然后调用 format 来进行转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(postTime);
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }
}
