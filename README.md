# 数据结构与算法分析
[![Security Status](https://www.murphysec.com/platform3/v3/badge/1610448892957601792.svg?t=1)](https://www.murphysec.com/accept?code=03c88fca1ad0c22dcb19f8b908880791&type=1&from=2&t=2)
## 一 . 数据结构与算法的概述

### 1.1 数据结构和算法的关系

- 数据data结构(structure)是一门研究组织数据方式的学科，有了编程语言也就有了数据结构.学好数据结构可以编写出更加漂亮,更加有效率的代码。
- 要学习好数据结构就要多多考虑如何将生活中遇到的问题,用程序去实现解决。
- 程序 = 数据结构 + 算法。
- 数据结构是算法的基础, 换言之，想要学好算法，需要把数据结构学到位。

### 1.2 线性结构与非线性结构

#### 1.2.1 线性结构

1. 线性结构作为最常用的数据结构，其特点是数据元素之间存在==一对一==的线性关系。
2. 线性结构有两种不同的存储结构，即==顺序存储结构==和==链式存储结构==。==顺序存储的线性表==称为==顺序表==，顺序表中的存储元素是连续的。
3. ==链式存储的线性表==称为==链表==，链表中的存储元素不一定是连续的，元素节点中存放数据元素以及相邻元素的地址信息。
4. 线性结构常见的有：数组、队列、链表和栈。

#### 1.2.2 非线性结构

- 非线性结构包括：二维数组，多维数组，广义表，树结构，图结构。

## 二.稀疏数组和队列

### 2.1 稀疏数组

- 当一个数组中大部分元素为０，或者为同一个值的数组时，可以使用稀疏数组来保存该数组。
- 稀疏数组的处理方法是:
  1. 记录数组一共有几行几列，有多少个不同的值。
  2. 把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模。

![image-20220915012003215](https://my-typroa-image.oss-cn-hangzhou.aliyuncs.com/typroaImage/image-20220915012003215.png)

#### 2.1.1 稀疏数组实现分析

![image-20220915160850021](https://my-typroa-image.oss-cn-hangzhou.aliyuncs.com/typroaImage/image-20220915160850021.png)

- 数组保存：

1. 遍历原始数组，得到有效数值sum
2. 根据sum创建稀疏数组 sparseArray Int\[sum + 1\]\[3\]
3. 将二维数组有效数值存入到稀疏数组。

- 数组恢复：

1. 读取稀疏数组第一行，根据第一行数据创建原始数组 array
2. 读取稀疏数组后几行的数据，并赋值给原始数组。

### 2.2 队列

- 队列是一个有序列表，可以用数组或是链表来实现。
- 遵循先入先出的原则。即：先存入队列的数据，要先取出。后存入的要后取出

#### 2.2.1 数组模拟队列思路分析

![image-20220916095101429](https://my-typroa-image.oss-cn-hangzhou.aliyuncs.com/typroaImage/image-20220916095101429.png)

- 创建QueueAarry类，构造初始化数组。
  - front =-1   rear=-1 
- addQueue添加 将尾指针往后移：rear + 1。
- getQueue获取  将头指针往后移 ：front + 1
- isEmpty 判空 rear  =  front  则队列数组为空。
- isFull 判满 rear =  MaxSize - 1则队列数组为满。
- showQueue 获取所有队列数值。
- getHeader 获取 数组队列头一个数值。
- exitSys 退出系统

#### 2.2.2 数组模拟队列问题分析

![image-20220916113345352](https://my-typroa-image.oss-cn-hangzhou.aliyuncs.com/typroaImage/image-20220916113345352.png)

#### 2.2.3 数组模拟环形队列问题分析

- 在数组模拟队列不能重复问题优化算法。

![image-20220917215627941](https://my-typroa-image.oss-cn-hangzhou.aliyuncs.com/typroaImage/image-20220917215627941.png)

参考：[https://blog.csdn.net/qq_41473905/article/details/103480136](https://blog.csdn.net/qq_41473905/article/details/103480136)

[https://blog.csdn.net/u013926385/article/details/125587222]()
