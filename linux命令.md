- 查询进程内存使用情况ps -p ${pid} -o rss,vsz   （物理内存、虚拟内存单位 kb）

- 查询进程运行环境  ls -l /proc/${pid}/exe

- sh中执行另一个shell的方式：
  fork	新开一个子 Shell 执行，子 Shell 可以从父 Shell 继承环境变量，但是子 Shell 中的环境变量不会带回给父 Shell。
  exec	在同一个 Shell 内执行，但是父脚本中 exec 行之后的内容就不会再执行了
  source	在同一个 Shell 中执行，在被调用的脚本中声明的变量和环境变量, 都可以在主脚本中进行获取和使用，相当于合并两个脚本在执行。

  
