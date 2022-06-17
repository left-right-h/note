- 查询进程内存使用情况ps -p ${pid} -o rss,vsz   （物理内存、虚拟内存单位 kb）

- 查询进程运行环境  ls -l /proc/${pid}/exe

- sh中执行另一个shell的方式：

命令 | 解释
--- | ----
fork	| 新开一个子 Shell 执行，子 Shell 可以从父 Shell 继承环境变量，但是子 Shell 中的环境变量不会带回给父 Shell。
exec |	在同一个 Shell 内执行，但是父脚本中 exec 行之后的内容就不会再执行了
source	| 在同一个 Shell 中执行，在被调用的脚本中声明的变量和环境变量, 都可以在主脚本中进行获取和使用，相当于合并两个脚本在执行。

- 查操作系统 cat /etc/issue
- 查看 CPU 物理个数 grep 'physical id' /proc/cpuinfo | sort -u | wc -l
- 查看 CPU 核心数量 grep 'core id' /proc/cpuinfo | sort -u | wc -l
- 查看 CPU 线程数 grep 'processor' /proc/cpuinfo | sort -u | wc -l

名词 | 含义
------ | ------
CPU物理个数	| 主板上实际插入的cpu数量
CPU核心数   |	单块CPU上面能处理数据的芯片组的数量，如双核、四核等 （cpu cores）
逻辑CPU数/线程数 |	一般情况下，逻辑cpu=物理CPU个数×每颗核数，如果不相等的话，则表示服务器的CPU支持超线程技术

- 查内存 free -m 

名词|	含义
---|---
Mem|	内存的使用情况总览表
Swap|	虚拟内存。即可以把数据存放在硬盘上的数据，当物理内存不足时，拿出部分硬盘空间当SWAP分区（虚拟成内存）使用，从而解决内存容量不足的情况。SWAP意思是交换，顾名思义，当某进程向OS请求内存发现不足时，OS会把内存中暂时不用的数据交换出去，放在SWAP分区中，这个过程称为SWAP OUT。当某进程又需要这些数据且OS发现还有空闲物理内存时，又会把SWAP分区中的数据交换回物理内存中，这个过程称为SWAP IN。当然，swap大小是有上限的，一旦swap使用完，操作系统会触发OOM-Killer机制，把消耗内存最多的进程kill掉以释放内存。
shared |	共享内存，即和普通用户共享的物理内存值， 主要用于进程间通信
buffers |	用于存放要输出到disk（块设备）的数据的
cached |	存放从disk上读出的数据
total |	总的物理内存，total=used+free
used	| 使用掉的内存
free	| 空闲的内存

> linux的内存管理机制的思想包括（不敢说就是）内存利用率最大化。内核会把剩余的内存申请为cached，而cached不属于free范畴。当系统运#行时间较久，会发现cached很大，对于有频繁文件读写操作的系统，这种现象会更加明显。直观的看，此时free的内存会非常小，但并不代表可##用的内存小，当一个程序需要申请较大的内存时，如果free的内存不够，内核会把部分cached的内存回收，回收的内存再分配给应用程序。所以#对于linux系统，可用于分配的内存不只是free的内存，还包括cached的内存（其实还包括buffers）。
对于操作系统：
MemFree=total-used
MemUsed  = MemTotal - MemFree
对于应用程序：
MemFree=buffers+cached+free

  
