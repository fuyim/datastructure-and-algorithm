import org.junit.Test;

/**
 * @author fym
 * @date 2022/9/17 17:46
 */
public class DatastructureTest {


    @Test
    public void test01(){
        int maxSize = 6;
        int rear = 1;
        int front = 0;
        rear = (rear + 1) % maxSize;
        System.out.printf("rear的值为：%d\n",rear);
        System.out.println("数组有效个数："+(rear + maxSize - front)%maxSize);
    }

}
