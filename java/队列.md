## java 队列

### 方法

| 方法    | 作用                     | 异常                                               |
| ------- | ------------------------ | -------------------------------------------------- |
| add     | 增加一个元索             | 如果队列已满，则抛出一个IIIegaISlabEepeplian异常   |
| remove  | 移除并返回队列头部的元素 | 如果队列为空，则抛出一个NoSuchElementException异常 |
| element | 返回队列头部的元素       | 如果队列为空，则抛出一个NoSuchElementException异常 |
| offer   | 添加一个元素并返回true   | 如果队列已满，则返回false                          |
| poll    | 移除并返问队列头部的元素 | 如果队列为空，则返回null                           |
| peek    | 返回队列头部的元素       | 如果队列为空，则返回null                           |
| put     | 添加一个元素             | 如果队列满，则阻塞                                 |
| take    | 移除并返回队列头部的元素 | 如果队列为空，则阻塞                               |

### 注意

- Queue接口 add, offer 方法建议不能添加null元素（poll和peek方法出错进返回null。因此，向队列中插入null值是不合法的），否则报空指针。但是大部分实现类遵守了这个规定（ArrayBlockingQueue，PriorityBlockingQueue 等等），有的却没有（LinkedList）

