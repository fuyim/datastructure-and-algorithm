package queueArrayDemo;

import java.util.Scanner;

/**
 * @author fym
 * @date 2022/9/16 10:50
 */
public class QueueArrayDemo {
    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(3);
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
                        queueArray.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    int num = scanner.nextInt();
                    queueArray.addQueue(num);
                    break;
                case 'g':
                    try {
                        int queue = queueArray.getQueue();
                        System.out.printf("取出的队列为：%d",queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int header = queueArray.getHeader();
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
 * - 创建QueueAarry类，构造初始化数组。
 *   - front =-1   rear=-1
 *
 * - addQueue添加 将尾指针往后移：rear + 1。
 * - getQueue获取  将头指针往后移 ：front + 1
 * - isEmpty 判空 rear  =  front  则队列数组为空。
 * - isFull 判满 rear =  MaxSize - 1则队列数组为满。
 * - showQueue 获取所有队列数值。
 * - getHeader 获取 数组队列头一个数值。
 * - exitSys 退出系统
 *
 */

class QueueArray{

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    /**
     * 构造初始化数组
     */
    public QueueArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
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
        if (rear == maxSize - 1)
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
        rear++;
        arr[rear] = n;
    }

    /**
     * 数组队列获取
     */
    public int getQueue(){
        if (isEmpty())
        {
            throw new RuntimeException("数组队列为空！");
        }
        front++;
        return arr[front];
    }


    /**
     * 获取所有队列数值。
     */
    public void showQueue(){
        if (isEmpty())
        {
            throw new RuntimeException("数组队列为空！"); 
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    /**
     * 取 数组队列头一个数值。
     * @return
     */
    public int getHeader(){
        if (isEmpty())
        {
            throw new RuntimeException("数组队列为空！");
        }
        return arr[front + 1];
    }




}
