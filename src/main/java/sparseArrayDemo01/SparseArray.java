package sparseArrayDemo01;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;

import java.io.*;

/**
 * @author fym
 * @date 2022/9/15 16:28
 */
public class SparseArray {

    /**
     *
     * 前提：
     * - 创建一个11行 11列的原始二维数组 orginArray
     * - 为原始二维数组保存有效值
     *
     * - 数组保存：
     *
     * 1. 遍历原始数组，得到有效数值sum
     * 2. 根据sum创建稀疏数组 sparseArray Int\[sum + 1\]\[3\]
     * 3. 将二维数组有效数值存入到稀疏数组。
     *
     * - 数组恢复：
     *
     * 1. 读取稀疏数组第一行，根据第一行数据创建原始数组 array
     * 2. 读取稀疏数组后几行的数据，并赋值给原始数组。
     *
     */

    public static void sparseArray(){

        // 1.创建原始二维数组 orginArray
        int orginArray[][] = new int[11][11];
        orginArray[1][2] = 1;
        orginArray[2][3] = 2;
        orginArray[5][6] = 2;

        // 2遍历原始数组，得到有效数值sum
        System.out.println("=====打印原始数组=====");
        for (int[] ints : orginArray) {
            System.out.print("\n");
            for (int data : ints) {
                System.out.print(data + "\t");
            }
        }

        System.out.print("\n======遍历原始数组======");
        int sum = 0;
        for (int col = 0; col < 11; col++) {
            for (int row = 0; row < 11; row++) {
                if (orginArray[col][row] != 0){
                    sum++;
                }
            }
        }
        System.out.println("\n有效值个数为："+sum);

        // 3.根据sum创建稀疏数组 sparseArray
        int sparseArray[][] = new int[sum+1][3];
        // 4.将二维数组有效数值存入到稀疏数组。
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int col = 0; col < 11; col++) {
            for (int row = 0; row < 11; row++) {
                if (orginArray[col][row] != 0){
                    count++;
                    sparseArray[count][0] = col;
                    sparseArray[count][1] = row;
                    sparseArray[count][2] = orginArray[col][row];
                }
            }
        }
        System.out.println("\n=====遍历稀疏数组=====");
        // 将稀疏数组写入到文件
        byte[] serialize = serialize(sparseArray);
        FileWriter fileWriter = new FileWriter("map.data");
        for (byte b : serialize) {
            fileWriter.write(serialize,0,serialize.length);
        }

        for (int[] ints : sparseArray) {
            System.out.print("\n");
            for (int data : ints) {
                System.out.print(data + "\t");
            }
        }
        FileReader fileReader = new FileReader("map.data");
        byte[] bytes = fileReader.readBytes();
        int array[][] =(int[][]) unSerialize(bytes);

        System.out.println("\n====原始数组的恢复=====");
        // 5.读取稀疏数组第一行，根据第一行数据创建原始数组 array2
        int orginArray2[][] = new int[array[0][0]][array[0][1]];

        // 6.读取稀疏数组后几行的数据，并赋值给原始数组。
        for (int i = 1; i < array.length; i++) {
            orginArray2[array[i][0]][array[i][1]] = array[i][2];
        }
        for (int[] ints : orginArray2) {
            System.out.print("\n");
            for (int data : ints) {
                System.out.print(data + "\t");
            }
        }

    }

    public static byte[] serialize(Object obj){
        ObjectOutputStream objectOutputStream = null;
        ByteArrayOutputStream bao = null;
        try {
            bao = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(bao);

            objectOutputStream.writeObject(obj);
            byte[] byteArray = bao.toByteArray();
            return byteArray;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static Object unSerialize(byte[] bytes){

        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);

            ObjectInputStream objectInputStream = new ObjectInputStream(bais);
            Object o = objectInputStream.readObject();
            return o;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }



    public static void main(String[] args) {
        sparseArray();
    }

}
