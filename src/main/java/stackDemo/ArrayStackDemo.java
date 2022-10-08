package stackDemo;


import java.util.Scanner;

/**
 * @author fym
 * @date 2022/10/8 13:30
 * 数组模拟栈
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(6);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        Boolean loop = true;
        while (loop)
        {
            System.out.println("s(show)：查看栈");
            System.out.println("a(add)：添加栈");
            System.out.println("p(pop)：获取队列");
            System.out.println("e(exit)：退出系统");
            key = scanner.next().charAt(0);
            switch (key)
            {
                case 's':
                    arrayStack.list();
                    break;
                case 'a':
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case 'p':
                    try {
                        int res = arrayStack.pop();
                        System.out.printf("取出的栈为：%d",res);
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


class ArrayStack{

    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 判断栈满
     * @return Boolean
     */
    public Boolean isFull(){
        if(top == maxSize - 1)
        {
            return true;
        }
        return false;
    }

    /**
     * 判断栈空
     * @return Boolean
     */
    public Boolean isEmpty(){
        if (top == -1){
            return true;
        }
        return false;
    }

    /**
     * 添加栈
     * @param value 值
     */
    public void push(int value){
        if (isFull()){
            System.out.println("栈满！");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 取出栈
     */
    public int pop(){
        if (isEmpty())
        {
            throw new RuntimeException("栈空！");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 栈的遍历
     */
    public void list(){
        if (isEmpty())
        {
            System.out.println("栈空！");
            return;
        }
        for (int i = top ; i >= 0 ; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }
}