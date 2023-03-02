网上大多数的方式都是这样的：https://www.jianshu.com/p/eefe3877650f，
但我实际测试的时候没有成功，
最后通过这个帖子中的方式测试成功了：https://apple.stackexchange.com/questions/230209/how-do-i-drop-outgoing-packets-to-specific-host-port/230556#230556?newreg=28ebe6b90db44c1a9f506548025856e9

方式如下：
1、Add this line to /etc/pf.conf to drop all packets to the given ip:port
```
block drop out quick proto tcp  to 192.168.1.103 port 80
```
2、After changing pf.conf you should reload it with
```
sudo pfctl -f /etc/pf.conf
```
3、Eventually you will have to enable it with
```
sudo pfctl -e
```