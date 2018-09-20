package com.cuiwei.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * created by cuiwei on 2018/9/17
 * 用nio实现一个简单的阻塞模式IO
 */
public class NioBlockingServerDemo {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8080));

        while(true){
            //发送请求
            String req = "first request!!";
            ByteBuffer buffer = ByteBuffer.wrap(req.getBytes());
            socketChannel.write(buffer);

            //读取响应
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            int num;
            if ((num = socketChannel.read(readBuffer)) > 0){
                readBuffer.flip();
                byte[] res = new byte[num];
                readBuffer.get(res);

                String result = new String(res,"UTF-8");
                System.out.println("返回值：" + result);
            }
        }
    }
}

class Server{
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //监听8080端口进来的TCP连接
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        while(true){
            //这里会阻塞，直到有一个请求的连接进来
            SocketChannel socketChannel = serverSocketChannel.accept();

            SocketHandler handler = new SocketHandler(socketChannel);
            new Thread(handler).start();// 新建一个线程来处理这个请求
        }
    }
}

class SocketHandler implements Runnable{
    private SocketChannel channel;
    public SocketHandler(SocketChannel channel){
        this.channel = channel;
    }
    @Override
    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try{
            int num;
            while((num = channel.read(buffer)) > 0){
                //切换为读取形式
                buffer.flip();
                byte[] bytes = new byte[num];
                buffer.get(bytes);
                //提取Buffer中的数据
                String req = new String(bytes,"UTF-8");
                System.out.println("收到请求：" + req);
                //回应客户端
                String res = "我已经收到您的请求，您的请求内容是： " + req;
                ByteBuffer writeBuffer = ByteBuffer.wrap(res.getBytes());
                channel.write(writeBuffer);

                buffer.flip();
            }
        }catch (IOException E){
            E.printStackTrace();
        }finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
