package linkedListDemo;

/**
 * @author fym
 * @date 2022/9/18 14:35
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"林冲","豹子头");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"卢俊义","玉麒麟");
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
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
     *   2.1. 第一种方法：使用带head头的单向链表实现
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
