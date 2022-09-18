package linkedListDemo;

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
    }

}

class SingleLinkedList{

    /**
     * 1. 初始化头结点
     */
    private HeroNode head = new HeroNode(0,"","");

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
     * 遍历
     */
    public void list(){
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
