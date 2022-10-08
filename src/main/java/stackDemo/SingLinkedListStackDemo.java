package stackDemo;

/**
 * @author fym
 * @date 2022/10/8 16:28
 * 单向链模拟栈
 * */
public class SingLinkedListStackDemo {
    public static void main(String[] args) {
        Node node1 = new Node(2);
        Node node2 = new Node(4);
        Node node3 = new Node(6);
        Node node4 = new Node(8);
        SingLinkedListStack singLinkedListStack = new SingLinkedListStack();
        singLinkedListStack.push(node1);
        singLinkedListStack.push(node2);
        singLinkedListStack.push(node3);
        singLinkedListStack.push(node4);
        int pop = singLinkedListStack.pop();
        System.out.println(pop);
        singLinkedListStack.list();
    }
}

class SingLinkedListStack{
    private Node top = new Node(-1);


    /**
     * 判空
     * @return Boolean
     */
    public Boolean isEmpty(){
        if (top.next == null)
        {
            return true;
        }
        return false;
    }

    /**
     * 入栈
     * @param node 节点
     */
    public void push(Node node){
        Node temp = top.next;
        top.next = node;
        node.next = temp;
    }

    /**
     * 出栈
     * @return int
     */
    public int pop(){
        if (top.next == null)
        {
            throw new RuntimeException("栈空！");
        }
        int value = top.next.value;
        top.next = top.next.next;
        return value;
    }

    public void list(){
        if (isEmpty()){
            System.out.println("栈空！");
            return;
        }
        while (top.next !=null)
        {
            System.out.println(top.next.value);
            top = top.next;
        }
    }


}

class Node{
    public int value;

    public Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SingLinkedListStack{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
