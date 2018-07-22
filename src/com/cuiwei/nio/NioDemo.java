package com.cuiwei.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * created by cuiwei on 2018/7/20
 * NIO简单demo
 * <p>
 * 一个简单（标准）的NIO输入输出一般包含如下步骤：
 * 1. 从数据源获取通道
 * 2. 分配缓冲区
 * 3. 切换缓存区为写模式
 * 4. 从通道读取数据写入缓冲区
 * 5. 切换缓冲区为读模式
 * 6. 缓冲区数据写入通道中
 * 7. 关闭资源
 */
public class NioDemo {

    public static void copyFile(String file1, String file2) {
        try {
            RandomAccessFile fromFile = new RandomAccessFile(file1, "rw");
            RandomAccessFile toFile = new RandomAccessFile(file2, "rw");

            //获取Channel
            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel = toFile.getChannel();

            //定义缓冲区大小
            int bufSize = 1024 * 4;

            //定义缓冲
            ByteBuffer byteBuffer = ByteBuffer.allocate(bufSize);

            int len = 0;

            //将数据从源channel写入到缓冲区
            while ((len = fromChannel.read(byteBuffer)) != -1) {

                //切换到读模式
                byteBuffer.flip();

                //读取缓冲区数据到目标channel
                toChannel.write(byteBuffer);

                //清空缓冲
                byteBuffer.clear();
            }

            //释放资源
            toChannel.close();
            fromChannel.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        copyFile("C:\\Users\\Lebron\\Desktop\\bookAppointment.sql",
                "C:\\Users\\Lebron\\Desktop\\book.sql");
        System.out.println("复制完成！");
    }
}
