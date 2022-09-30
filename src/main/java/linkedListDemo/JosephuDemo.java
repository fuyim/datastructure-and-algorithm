package linkedListDemo;

/**
 * @author fym
 * @date 2022/9/29 16:12
 * 约瑟夫问题的代码实现
 */
public class JosephuDemo {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1,2,5);
    }
}

class CircleSingleLinkedList{

    /**
     *  1.创建第一个节点first
     */

    Boy first = null;


    /**
     * 计算小孩出圈
     * @param startNo 开始编号
     * @param countNum 数几个
     * @param nums 一共几个
     */
    public void countBoy(int startNo,int countNum,int nums){
        if(first == null || startNo < 1 || startNo > nums)
        {
            System.out.println("你输入的参数违法！|");
            return;
        }
        // 1.创建一个辅助变量，指向环形链表的最后一个结点
        Boy helper = first;
        while (true)
        {
            if (helper.getNext() == first)
            {
                break;
            }
            helper = helper.getNext();
        }
        // 2.小孩报数之前，先让first和helper移动startNo - 1次1
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true)
        {
           if (helper == first)
           {
               break;
           }
           // 3.当小孩报数时,让first和helper指针同时移动countNum-1次
            for (int i = 0 ; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            System.out.println("小孩出圈："+first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩为："+first.getNo());
    }

    /**
     * 添加节点
     * @param nums 添加节点的个数
     */
    public void addBoy(int nums){
        if (nums<1)
        {
            System.out.println("nums值不正确！");
            return;
        }
        // 辅助指针
        Boy curBoy = null;
        // 2.循环添加一个新节点，将第一个节点指向fist
        for (int i = 1 ; i <= nums ; i++) {
            Boy boy = new Boy(i);
            if (i == 1)
            {
                // 表示当前节点为第一个节点
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历
     */
    public void showBoy(){
        if (first == null)
        {
            System.out.println("当前的环形链表为空！");
            return;
        }

        Boy curBoy = first;
        while (true)
        {
            System.out.println("当前小孩节点编号为："+curBoy.getNo());
            if (curBoy.getNext() == first)
            {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

}


/**
 * 创建一个小孩类用来代表一个新节点
 */
class Boy{

    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
