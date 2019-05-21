package com.example.hp.muxi_workbench_android.net.bean;

import java.util.List;

public class MessageList {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * action : 编辑
         * fromAvatar : http://ossworkbench.muxixyz.com/1553093139.3948538.jpg
         * fromName : 赵弟发
         * projectID : 9
         * readed : false
         * sourceID : 15
         * sourceKind : 0
         * time : 2019-03-20 14:33:35
         */

        private String action;
        private String fromAvatar;
        private String fromName;
        private int projectID;
        private boolean readed;
        private int sourceID;
        private int sourceKind;
        private String time;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getFromAvatar() {
            return fromAvatar;
        }

        public void setFromAvatar(String fromAvatar) {
            this.fromAvatar = fromAvatar;
        }

        public String getFromName() {
            return fromName;
        }

        public void setFromName(String fromName) {
            this.fromName = fromName;
        }

        public int getProjectID() {
            return projectID;
        }

        public void setProjectID(int projectID) {
            this.projectID = projectID;
        }

        public boolean isReaded() {
            return readed;
        }

        public void setReaded(boolean readed) {
            this.readed = readed;
        }

        public int getSourceID() {
            return sourceID;
        }

        public void setSourceID(int sourceID) {
            this.sourceID = sourceID;
        }

        public int getSourceKind() {
            return sourceKind;
        }

        public void setSourceKind(int sourceKind) {
            this.sourceKind = sourceKind;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
