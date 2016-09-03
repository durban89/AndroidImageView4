# AndroidImageView4

ImageView 从网络下载图片

## 注意点
Android最新版本的SDK是不允许在主线程中去访问网络的
因此此实例中会出现
NetworkOnMainThreadException
这个错误，解决办法，目前使用了很暴力的方式，
不过这里建议，将请求网络资源的代码使用Thread去操作。在Runnable中做HTTP请求。