package com.example.hp.muxi_workbench_android.net.bean;

import java.util.List;

public class ScheduleInfo {


    /**
     * author_id : 3
     * commentList : [{"avatar":"http://ossworkbench.muxixyz.com/1552868798.6947563.TIM20190318082620.jpg","cid":1,"content":"请吃饭","time":"2019-03-16 15:30:35","username":"Summer"},{"avatar":"http://ossworkbench.muxixyz.com/t.jpg1552724200.820682","cid":2,"content":"请吃饭","time":"2019-03-16 15:30:47","username":"Darren"},{"avatar":"http://ossworkbench.muxixyz.com/1552730712.1079993.group-product.png","cid":3,"content":"牛逼????","time":"2019-03-16 17:07:01","username":"赵鑫晖"},{"avatar":"http://ossworkbench.muxixyz.com/img.png1552721356.9483771","cid":12,"content":"我请我自己吃饭","time":"2019-03-18 18:47:52","username":"今天豆豆写代码了嘛w"}]
     * content : <p>哈哈哈哈终于上线了！！！！！</p>
     * iflike : 0
     * likeCount : 3
     * sid : 1
     * time : 2019/03/16 15:29:43
     * title : 工作台的第一条进度
     * userID : 43
     * username : 赵弟发
     */

    private int author_id;
    private String content;
    private int iflike;
    private int likeCount;
    private int sid;
    private String time;
    private String title;
    private int userID;
    private String username;
    private List<CommentListBean> commentList;

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIflike() {
        return iflike;
    }

    public void setIflike(int iflike) {
        this.iflike = iflike;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CommentListBean> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentListBean> commentList) {
        this.commentList = commentList;
    }

    public static class CommentListBean {
        /**
         * avatar : http://ossworkbench.muxixyz.com/1552868798.6947563.TIM20190318082620.jpg
         * cid : 1
         * content : 请吃饭
         * time : 2019-03-16 15:30:35
         * username : Summer
         */

        private String avatar;
        private int cid;
        private String content;
        private String time;
        private String username;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
