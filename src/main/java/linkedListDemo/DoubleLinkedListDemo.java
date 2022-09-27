package linkedListDemo;

/**
 * @author fym
 * @date 2022/9/27 17:04
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(5,"林冲","豹子头");
        HeroNode2 hero3 = new HeroNode2(7,"吴用","智多星");
        HeroNode2 hero4 = new HeroNode2(3,"卢俊义","玉麒麟");

        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.add(hero2);
        doubleLinkedList.list();

        HeroNode2 hero5 = new HeroNode2(5,"小林","豹子头~~");
        doubleLinkedList.update(hero5);
        doubleLinkedList.list();

//        doubleLinkedList.del(1);
        doubleLinkedList.del(7);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList{

    /**
     * 1. 初始化头结点
     */
    private HeroNode2 head = new HeroNode2(0,"","");

    public void del(int no){

        if (head.next == null)
        {
            System.out.println("该双向列表为空！");
            return;
        }
        HeroNode2 temp = head.next;
        Boolean flag = false;
        while (true)
        {
            if (temp == null)
            {
                break;
            }

            if (temp.no == no)
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag)
        {
            temp.pre.next = temp.next;
            if (temp.next != null)
            {
                temp.next.pre = temp.pre;
            }

        }else {
            System.out.println("删除的节点为空！");
        }
    }


    /**
     * 双向链表的修改
     * @param heroNode 要修改的节点
     */
    public void update(HeroNode2 heroNode){

        if (head.next == null)
        {
            System.out.println("链表为空！");
            return;
        }

        HeroNode2 temp = head.next;
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
     * 双向链表的新增
     * @param heroNode 要添加的节点
     */
    public void add(HeroNode2 heroNode){

        // 添加一个辅助变量
        HeroNode2 temp = head;
        while(true)
        {
            if (temp.next == null)
            {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 双向链表顺序添加
     * @param heroNode 要添加的节点
     */
//    public void addByOrder(HeroNode2 heroNode){
//
//        HeroNode2 temp = head;
//        Boolean flag = false;
//
//        while (true)
//        {
//            if (temp.next == null)
//            {
//                break;
//            }
//            if (temp.next.no > heroNode.no)
//            {
//                break;
//            }else if (temp.next.no == heroNode.no)
//            {
//                flag = true;
//                break;
//            }
//            temp = temp.next;
//
//        }
//        if (flag)
//        {
//            System.out.println("准备插入的编号："+heroNode.no+"已经存在不能再进行插入");
//        }else {
//            heroNode.next = temp.next;
//            temp.next = heroNode;
//        }
//
//    }

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
        HeroNode2 temp = head.next;

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
class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
