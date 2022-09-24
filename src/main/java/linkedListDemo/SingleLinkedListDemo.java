package linkedListDemo;

import java.util.Stack;

/**
 * @author fym
 * @date 2022/9/18 14:35
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(5,"林冲","豹子头");
        HeroNode hero3 = new HeroNode(7,"吴用","智多星");
        HeroNode hero4 = new HeroNode(3,"卢俊义","玉麒麟");
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.list();

        System.out.println("=====从头到尾打印====");
        singleLinkedList.reversePrint(singleLinkedList.getHead());

        singleLinkedList.reverseList(singleLinkedList.getHead());
        singleLinkedList.list();
        /*
        HeroNode hero5 = new HeroNode(5,"小林","豹子头~~");
        singleLinkedList.update(hero5);
        singleLinkedList.list();
        singleLinkedList.del(1);
        singleLinkedList.del(7);
        singleLinkedList.list();

        int size = singleLinkedList.getLength(singleLinkedList.getHead());
        System.out.println("单项链表的节点个数为："+size);

        int index = 2;
        HeroNode lastListIndexNode = singleLinkedList.getLastListIndexNode(singleLinkedList.getHead(), index);
        System.out.println("单项链表的倒数第"+index+"的节点为："+lastListIndexNode);
        */
    }

}

class SingleLinkedList{

    /**
     * 1. 初始化头结点
     */
    private HeroNode head = new HeroNode(0,"","");


    /**
     * 从尾到头打印单链表
     * 1. 将各个节点压入栈中，利用栈的先进后出的特点遍历。
     * @param head 头节点
     */
    public void reversePrint(HeroNode head){
        if (head.next == null)
        {
            System.out.println("单项链表为空！");
            return;
        }

        Stack<HeroNode> stackHeroNode = new Stack<HeroNode>();
        HeroNode temp = head.next;
        while (true)
        {
            stackHeroNode.push(temp);
            temp = temp.next;
            if (temp == null)
            {
                break;
            }
        }

        while (stackHeroNode.size() > 0)
        {
            System.out.println(stackHeroNode.pop());
        }

    }


    /**
     * 单项链表的反转
     * 1. 定义一个新的头结点 reverseHead
     * 2. 遍历，每次遍历将节点放入reverseHead的前端
     * 3. 将head.next = reverseHead.next
     * @param head 头节点
     */
    public void reverseList(HeroNode head){
        if (head.next == null || head.next.next == null)
        {
            return;
        }

        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");
        while (true)
        {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
            if (cur == null)
            {
                break;
            }
        }
        head.next = reverseHead.next;
    }

    /**
     * 查找单链表倒数第k个节点
     * 1. 遍历链表得到size
     * 2. 再次从第一个开始遍历size-index个
     * 3. 如果找到就返回 否则返回null
     * @param head 头结点
     * @param index 倒数第index个节点
     * @return HeroNode
     */
    public HeroNode getLastListIndexNode(HeroNode head,int index){

        if (head.next == null)
        {
            System.out.println("节点为空！");
            return null;
        }

        int size = getLength(head);
        // 判断index有效性
        if (index <= 0 || index > size)
        {
            System.out.println("找不到节点为："+index+"的节点！");
            return null;
        }
        HeroNode temp = head.next;
        for (int i=0 ; i< size - index ; i++){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 获取单链表的节点个数
     * @param head 不包含头节点
     * @return size
     */
    public int getLength(HeroNode head){
        if (head.next == null)
        {
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while(true)
        {
            length++;
            temp = temp.next;
            if (temp ==null)
            {
                break;
            }
        }
        return length;
    }

    public HeroNode getHead() {
        return head;
    }

    /**
     * 2. 初始化头结点
     *   2.1. 第一种方法：添加英雄时，直接添加到链表的尾部
     *      1) 找到链表的最后一个节点：
     *      2) 将链表的最后一个节点指向新的节点；
     */
    public void add(HeroNode heroNode){

        // 添加一个辅助变量
        HeroNode temp = head;
        while(true)
        {
            if (temp.next == null)
            {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }


    /**
     *  第二种方法：第二种方式在添加英雄时，根据排名将英雄插入到指定位置
     *   1) 找到新添加节点的位置
     *   2) 将新节点.next = temp.next
     *   3) temp.next = 将新节点
     */
    public void addByOrder(HeroNode heroNode){

        HeroNode temp = head;
        Boolean flag = false;

        while (true)
        {
            if (temp.next == null)
            {
                break;
            }
            if (temp.next.no > heroNode.no)
            {
                break;
            }else if (temp.next.no == heroNode.no)
            {
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if (flag)
        {
            System.out.println("准备插入的编号："+heroNode.no+"已经存在不能再进行插入");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    /**
     * 根据节点编号进行更改
     * 1. 找到与temp.no编号相等的HeroNode 即temp.no == HeroNode.no
     * 2. 将 HeroNode.name,HeroNode.nickName赋值给temp   
     * @param heroNode 要更改的节点
     */
    public void update(HeroNode heroNode){

        if (head.next == null)
        {
            System.out.println("链表为空！");
            return;
        }

        HeroNode temp = head.next;
        Boolean flag = false;
        while (true)
        {

            if (temp.next == null)
            {
                System.out.println("链表已经遍历完毕！");
                break;
            }

            if (temp.no == heroNode.no)
            {
                flag = true;
                break;
            }

            temp = temp.next;
        }
        if (flag)
        {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }else {
            System.out.println("找不到该节点！");
        }
    }


    /**
     * 根据编号no删除节点
     * 1. 找到要删除节点的前一个节点
     * 2. 将temp.next = temp.next.next
     * @param no 要删除节点的编号
     */
    public void del(int no){

        if (head.next == null)
        {
            System.out.println("该单向列表为空！");
            return;
        }
        HeroNode temp = head;
        Boolean flag = false;
        while (true)
        {
            if (temp.next == null)
            {
                break;
            }

            if (temp.next.no == no)
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag)
        {
            temp.next = temp.next.next;
        }else {
            System.out.println("删除的节点为空！");
        }


    }

    /**
     * 遍历
     */
    public void list(){
        System.out.println("=====遍历开始======");
        if (head.next == null)
        {
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.next;

        while (true)
        {
            if (temp == null)
            {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println("=====遍历结束======");
    }

}

/**
 * HeroNode对象为一个结点
 */
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
