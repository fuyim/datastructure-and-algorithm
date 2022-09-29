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
    }
}

class CircleSingleLinkedList{

    /**
     *  1.创建第一个节点first
     */

    Boy first = null;

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
