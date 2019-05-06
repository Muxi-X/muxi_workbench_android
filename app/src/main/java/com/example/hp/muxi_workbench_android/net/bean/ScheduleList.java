package com.example.hp.muxi_workbench_android.net.bean;

import java.util.List;

public class ScheduleList {


    /**
     * count : 228
     * page : 1
     * statuList : [{"avatar":"http://ossworkbench.muxixyz.com/1553091093.241192.jpeg","commentCount":0,"content":"<ul><li>写了一个类似qq条目左滑出删除按钮的自定义view，主要练习理解Android view的事件传递机制，坑还是蛮多的，多亏这篇博客<a class=\"link\" href=\"https://blog.csdn.net/sonnyjack/article/details/79376683\">Android事件机制深入探讨<\/a>，总的来说就是 当一个事件被该view/viewgroup/activity消费后，该事件序列后续所有都自动交由它来处理<\/li><\/ul><ul><li>写工作台<\/li><\/ul><ul><li> 参考这篇博客<a class=\"link\" href=\"https://juejin.im/post/5cc3a7495188252e784498b4#heading-7\">手把手叫你实现一个mini-retrofit框架<\/a> 写了一个简单的retrofit框架，还在继续完善中，加深对retrofit的理解，其中主要用到了    java的注解和java的动态代理<\/li><li>leetcode+2<\/li><\/ul><p><\/p>","iflike":0,"likeCount":0,"sid":271,"time":"2019/05/05 23:39:24","title":"一周总结","uid":40,"username":"messi-wpy"},{"avatar":"http://ossworkbench.muxixyz.com/img.png1552721356.9483771","commentCount":0,"content":"<ul><li>Leetcode += 7<\/li><\/ul><p><\/p>","iflike":0,"likeCount":1,"sid":270,"time":"2019/05/05 17:47:45","title":"Leetcode","uid":3,"username":"今天豆豆写代码了嘛w"},{"avatar":"http://ossworkbench.muxixyz.com/1553345313.4236598.d4628535e5dde71100ac80a1a4efce1b9d16616f.jpg","commentCount":0,"content":"<ul><li>最近做了pat中的题<\/li><li>在看深入了解计算机系统的数<\/li><li>在做编辑页面<\/li><\/ul><p><\/p>","iflike":0,"likeCount":0,"sid":269,"time":"2019/05/04 01:22:54","title":"5月3日","uid":71,"username":"张敏跃"},{"avatar":"http://ossworkbench.muxixyz.com/1552821108.3196578.jpg","commentCount":0,"content":"<ul><li>看了六章小册<\/li><li>复习了一下go的一些语法和特性<\/li><li>之后找机会看看shell怎么写<\/li><\/ul><p><\/p>","iflike":0,"likeCount":2,"sid":268,"time":"2019/05/02 21:19:19","title":"5月2日","uid":30,"username":"CGH233"},{"avatar":"http://ossworkbench.muxixyz.com/1552821108.3196578.jpg","commentCount":0,"content":"<ul><li>今天开车回老家，累的一批，看了两章小册。<\/li><li>之后几天没事，把小册看完，跑跑匣子的测试<\/li><\/ul><p><\/p>","iflike":0,"likeCount":2,"sid":267,"time":"2019/05/01 20:06:13","title":"5月1日","uid":30,"username":"CGH233"},{"avatar":"https://static.muxixyz.com/workbench/avatar/4.png","commentCount":0,"content":"<ul><li>主要在学Mysql<\/li><\/ul><ul><li>实现链表<\/li><li>五一将会非常充实（一堆事儿），所谓假期。。<\/li><\/ul><p><\/p>","iflike":0,"likeCount":2,"sid":266,"time":"2019/04/30 21:45:55","title":"4.30","uid":73,"username":"章茗超"},{"avatar":"http://ossworkbench.muxixyz.com/1553345313.4236598.d4628535e5dde71100ac80a1a4efce1b9d16616f.jpg","commentCount":0,"content":"<ul><li>今天看了深入理解计算机系统第二章<\/li><li>在写星球的页面，在修改bug<\/li><\/ul><p><\/p>","iflike":0,"likeCount":2,"sid":265,"time":"2019/04/30 00:06:09","title":"4月29日","uid":71,"username":"张敏跃"},{"avatar":"http://ossworkbench.muxixyz.com/1552730712.1079993.group-product.png","commentCount":1,"content":"<p>这次搭集群顺便实践了一下 <a class=\"link\" href=\"https://docs.traefik.io\">Traefik<\/a><\/p><p><\/p><blockquote>Traefik is a modern HTTP reverse proxy and load balancer that makes deploying microservices easy.<\/blockquote><p><\/p><p>总之就是一个 Cloud Native 版的 Nginx。好处是对微服务支持很好。用 Ingress 就可以动态配置路由规则。功能很多，需要慢慢探索。<\/p><p><\/p><p>Traefik 官方文档里是用的 DaemonSet + hack（securityContext） 来暴露端口到公网的。我之前一直试了没用是因为没把新机器的防火墙打开hhh。后来发现这种方式是可行的。不过不知道如何保留 Request 的真正 IP。总之熟悉了之后发现 Traefik 的文档还是挺不错的。而且 Traefik  支持一键反向代理 GRPC（h2c协议）。所以我可以部署一个 RPC 服务并把这个服务暴露到外网。<\/p><p><\/p>","iflike":0,"likeCount":2,"sid":264,"time":"2019/04/29 20:33:22","title":"Traefik ","uid":22,"username":"赵鑫晖"},{"avatar":"http://ossworkbench.muxixyz.com/1552730712.1079993.group-product.png","commentCount":0,"content":"<p>吹一波 K3s，官方跟进的很快，之前镜像被墙的问题后面的版本就解决了。自带的 core-dns 和 containerd 其实都是更好用的玩意，还降低了资源占用。部署脚本写的很好。部署非常方便。人家瞄准的是边缘计算和 IOT，不过我们学生机这种乞丐配置刚好也落在这个范围里了2333<\/p>","iflike":0,"likeCount":1,"sid":263,"time":"2019/04/29 20:23:13","title":"吹一波 k3s","uid":22,"username":"赵鑫晖"},{"avatar":"http://ossworkbench.muxixyz.com/1552730712.1079993.group-product.png","commentCount":0,"content":"<p>本周完成了 k3s 的集群搭建，后面会作为我们的测试集群使用。之前的测试集群会作为生产机器投入，降低目前生产环境的压力。本来用学生机搭建集群的难点在于不同集群在不同的 VPC 下面，私网不通，但阿里云去年推出了<a class=\"link\" href=\"https://help.aliyun.com/product/59006.html\">云企业网<\/a>，可以免费把同地域的 VPC 连接起来，并且可以跨账号，这一举解决了之前的难题，使得学生机 + k8s 的梦想成为了现实。当然 k3s 也是功不可没的，k3s 对机器的要求非常低，使得学生机也可以顺利的运行 k8s。总之感谢 Rancher 和阿里云，我们现在在 Server 资源上的压力大大降低了。后面我们会尝试用学生机 + k3s 作为第二生产集群，运行比较轻量的业务，比如工作台和小程序等等。<\/p>","iflike":0,"likeCount":1,"sid":262,"time":"2019-04-29 20:18:29","title":"k3s大法好，阿里云真香","uid":22,"username":"赵鑫晖"},{"avatar":"http://ossworkbench.muxixyz.com/1552821108.3196578.jpg","commentCount":0,"content":"<ul><li>终于看到api部分了。<\/li><\/ul><p><\/p>","iflike":0,"likeCount":1,"sid":261,"time":"2019/04/28 22:28:29","title":"4月28日","uid":30,"username":"CGH233"},{"avatar":"http://ossworkbench.muxixyz.com/img.png1552721356.9483771","commentCount":0,"content":"<ul><li>API += 4<\/li><li>Leetcode += 7 (我今天好肝)<\/li><li>Leetcode今天写的效率也出乎意料：94.34%, 88.46%, 100%, 100%, 100%, 98.57%, 100%<\/li><\/ul><p><\/p>","iflike":0,"likeCount":1,"sid":260,"time":"2019/04/28 21:50:21","title":"Leetcode","uid":3,"username":"今天豆豆写代码了嘛w"},{"avatar":"http://ossworkbench.muxixyz.com/1552730712.1079993.group-product.png","commentCount":0,"content":"<p><a class=\"link\" href=\"https://github.com/kubernetes/kubernetes/blob/master/cluster/gce/gci/configure-helper.sh#L324\">k8s的 logrotate 脚本<\/a><\/p>","iflike":0,"likeCount":1,"sid":259,"time":"2019/04/28 18:35:35","title":"Logrotate for k8s","uid":22,"username":"赵鑫晖"},{"avatar":"https://static.muxixyz.com/workbench/avatar/4.png","commentCount":0,"content":"<ul><li>看CSAPP，在会前一个小时搓完第一章<\/li><\/ul><p><\/p><p><\/p>","iflike":0,"likeCount":0,"sid":258,"time":"2019/04/27 23:22:54","title":"4.27","uid":73,"username":"章茗超"},{"avatar":"http://ossworkbench.muxixyz.com/1553345313.4236598.d4628535e5dde71100ac80a1a4efce1b9d16616f.jpg","commentCount":0,"content":"<ul><li>最近在学习写星球中的动态评论<\/li><li>做了pat中的题<\/li><li>再看《深入了解计算机系统》<\/li><\/ul><p><\/p>","iflike":0,"likeCount":0,"sid":257,"time":"2019/04/27 20:33:18","title":"4月27日","uid":71,"username":"张敏跃"},{"avatar":"http://ossworkbench.muxixyz.com/1553091093.241192.jpeg","commentCount":0,"content":"<ul><li>写python爬虫作业，异步爬取<\/li><li>leetcode+1<\/li><\/ul><p><\/p>","iflike":0,"likeCount":1,"sid":256,"time":"2019-04-27 00:37:19","title":"4.26","uid":40,"username":"messi-wpy"},{"avatar":"https://static.muxixyz.com/workbench/avatar/9.png","commentCount":0,"content":"<ul><li>改﻿了几个api<\/li><li>学﻿go，go有好多外形类似而功能略有不同的函数<\/li><\/ul><p><\/p>","iflike":0,"likeCount":0,"sid":255,"time":"2019/04/26 19:05:42","title":"4.26","uid":50,"username":"胡嘉旻"},{"avatar":"http://ossworkbench.muxixyz.com/1553091093.241192.jpeg","commentCount":0,"content":"<h2>4.25<\/h2><p><a class=\"link\" href=\"https://messi-wpy.github.io/2019/04/25/AndroidFragment%E5%AD%A6%E4%B9%A0/\">总结了一篇关于fragment管理的博客，之前这里一直很迷fragment<\/a><\/p>","iflike":0,"likeCount":0,"sid":254,"time":"2019/04/26 10:24:25","title":"4.25","uid":40,"username":"messi-wpy"},{"avatar":"http://ossworkbench.muxixyz.com/1553777738.5420315.109951163709393286.jpg","commentCount":1,"content":"<ul><li>看了看go，补了上周的一道题，正则那道不太懂。<\/li><li>MySQL必知必会，看了一点小册发现要用MySQL，打算学一下MySQL和redis。<\/li><\/ul><p><\/p>","iflike":0,"likeCount":1,"sid":253,"time":"2019/04/26 10:13:58","title":"2019-04-26","uid":53,"username":"余鸿奇"},{"avatar":"http://ossworkbench.muxixyz.com/1553355777.8214488.02b4587254d466323a21a21963161eec.jpg","commentCount":0,"content":"<ul><li>最近几天看了《深入理解计算机系统》的第一章<\/li><li>学会了怎么在一个imageview里重叠放两张图片，但是好像不能设置图片大小，只能填充。<\/li><li>尝试使用学长推给我的material-dialogs，网上的教程没跟上它更新的速度，github上的示例也是用kotlin写的，原来的.show()方法本来没有参数的，现在要填一个FragmentActivity或者FragmentManager，我就不懂了，然后就尝试看它的源码找找思路，找到了gridview，这个控件的适配器网上的例子写的都不太一样，搞得我也是懵了很久。后来写好适配器之后，我发现我的代码逻辑异常混乱，这个页面的主要功能是在recyclerview的item里实现的，所以在recyclerview的adapter里要添一系列的方法和实例，中间还有各种回调，我需要理一下我的逻辑了。。。<\/li><li>深深的感受到了黔驴技穷的绝望。<\/li><\/ul><p><\/p>","iflike":0,"likeCount":1,"sid":251,"time":"2019/04/26 07:07:09","title":"**_**","uid":47,"username":"zyflool"}]
     */

    private int count;
    private int page;
    private List<StatuListBean> statuList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<StatuListBean> getStatuList() {
        return statuList;
    }

    public void setStatuList(List<StatuListBean> statuList) {
        this.statuList = statuList;
    }

    public static class StatuListBean {
        /**
         * avatar : http://ossworkbench.muxixyz.com/1553091093.241192.jpeg
         * commentCount : 0
         * content : <ul><li>写了一个类似qq条目左滑出删除按钮的自定义view，主要练习理解Android view的事件传递机制，坑还是蛮多的，多亏这篇博客<a class="link" href="https://blog.csdn.net/sonnyjack/article/details/79376683">Android事件机制深入探讨</a>，总的来说就是 当一个事件被该view/viewgroup/activity消费后，该事件序列后续所有都自动交由它来处理</li></ul><ul><li>写工作台</li></ul><ul><li> 参考这篇博客<a class="link" href="https://juejin.im/post/5cc3a7495188252e784498b4#heading-7">手把手叫你实现一个mini-retrofit框架</a> 写了一个简单的retrofit框架，还在继续完善中，加深对retrofit的理解，其中主要用到了    java的注解和java的动态代理</li><li>leetcode+2</li></ul><p></p>
         * iflike : 0
         * likeCount : 0
         * sid : 271
         * time : 2019/05/05 23:39:24
         * title : 一周总结
         * uid : 40
         * username : messi-wpy
         */

        private String avatar;
        private int commentCount;
        private String content;
        private int iflike;
        private int likeCount;
        private int sid;
        private String time;
        private String title;
        private int uid;
        private String username;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
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

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
