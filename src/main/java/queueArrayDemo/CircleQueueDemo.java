package queueArrayDemo;

import java.util.Scanner;

/**
 * @author fym
 * @date 2022/9/17 18:21
 */
public class CircleQueueDemo {
    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(6);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        Boolean loop = true;
        while (loop)
        {
            System.out.println("s(show)：查看队列");
            System.out.println("a(add)：添加队列");
            System.out.println("g(get)：获取队列");
            System.out.println("h(head)：获取头队列");
            System.out.println("e(exit)：退出系统");
            key = scanner.next().charAt(0);
            switch (key)
            {
                case 's':
                    try {
                        circleQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    int num = scanner.nextInt();
                    circleQueue.addQueue(num);
                    break;
                case 'g':
                    try {
                        int queue = circleQueue.getQueue();
                        System.out.printf("取出的队列为：%d",queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int header = circleQueue.getHeader();
                        System.out.printf("取出的头队列为：%d",header);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("===程序退出===");
    }

}

/**
 * maxSize = 6
 * 判空：rear == front
 * rear 指向队列的最后一个元素的后一个位置（流出一个空间做约定） 初始值为0
 * rear == （rear + 1）% maxSize
 * 判满：(rear + 1) % maxSize == front
 * front 指向队列的第一个元素 初始值为0
 * front == (front + 1) % maxSize 
 * 有效数据个数：（rear + maxSize - front）% maxSize
 */

class CircleQueue{

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;


    /**
     * 构造初始化数组
     */
    public CircleQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    /**
     * 数组队列判空
     * @return boolean
     */
    public Boolean isEmpty(){
        if (rear == front)
        {
            return true;
        }
        return false;
    }

    /**
     * 数组队列判满
     * @return boolean
     */
    public Boolean isFull(){
        if ((rear + 1) % maxSize == front)
        {
            return true;
        }
        return false;
    }

    /**
     * 数值队列添加
     * @param n 数值
     */
    public void addQueue(int n){
        if (isFull())
        {
            System.out.println("======数值队列为满 不能进行添加======");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
        System.out.printf("rear的值为%d\n",rear);
    }

    /**
     * 数组队列获取
     */
    public int getQueue(){
        if (isEmpty())
        {
            throw new RuntimeException("数组队列为空！");
        }
        // 保留front对应的数值、
        int value = arr[front];
        front = (front + 1) % maxSize;
        System.out.printf("front的值为%d\n",front);
        return value;
    }

    /**
     * 获取所有队列数值。
     */
    public void showQueue(){
        if (isEmpty())
        {
            throw new RuntimeException("数组队列为空！");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    /**
     *
     * @return 队列中有效的数据个数
     */
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    /**
     *
     * @return 取数组队列头一个数值。
     */
    public int getHeader(){
        if (isEmpty())
        {
            throw new RuntimeException("数组队列为空！");
        }
        return arr[front];
    }

}
