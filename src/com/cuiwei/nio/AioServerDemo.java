package com.cuiwei.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * created by cuiwei on 2018/9/18
 * 用Aio实现一个服务器和客户端
 */
public class AioServerDemo {
    public static void main(String[] args) {
        AioServerDemo aioServerDemo = new AioServerDemo();
        aioServerDemo.init(8080);
    }

    public void init(int port){
        try {
            //实例化，并监听端口
            AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open()
                    .bind(new InetSocketAddress(port));
            //自己定义一个Attachement类，用于传递一些信息
            Attachement att = new Attachement();
            att.setServer(server);

            //创建一个回调函数
            server.accept(att, new CompletionHandler<AsynchronousSocketChannel, Attachement>() {
                        @Override
                        public void completed(AsynchronousSocketChannel client, Attachement attachment) {
                            try {
                                SocketAddress clientAddress = client.getRemoteAddress();
                                System.out.println("收到新的连接：【" + clientAddress  +"】" );
                                //收到新的连接后，server应该重新调用accept方法等待新的的连接
                                att.getServer().accept(att,this);

                                Attachement newAtt = new Attachement();
                                newAtt.setServer(server);
                                newAtt.setClient(client);
                                newAtt.setReadMode(true);
                                newAtt.setBuffer(ByteBuffer.allocate(1024));
                                //异步处理客户端的请求
                                client.read(newAtt.getBuffer(),newAtt,new ChannelHandler());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void failed(Throwable exc, Attachement attachment) {
                            System.out.println("accept failed");
                        }
                    }
            );
            try {
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class ChannelHandler implements CompletionHandler<Integer,Attachement>{
    @Override
    public void completed(Integer result, Attachement att) {
        if (att.isReadMode()){
            ByteBuffer buffer = att.getBuffer();
            buffer.flip();
            byte bytes[] = new byte[buffer.limit()];
            buffer.get(bytes);
            String msg = new String(buffer.array()).trim();
            System.out.println("收到来自客户端的数据：" + msg);
            //响应客户端请求
            buffer.clear();
            buffer.put("Response from server!".getBytes(Charset.forName("UTF-8")));
            att.setReadMode(false);
            buffer.flip();
            //写数据到客户端也是异步
            att.getClient().write(buffer,att,this);
        }else{
            // 到这里，说明往客户端写数据也结束了，有以下两种选择:
            // 1. 继续等待客户端发送新的数据过来
            // att.setReadMode(true);
            // att.getBuffer().clear();
            // att.getClient().read(att.getBuffer(), att, this);
            // 2. 既然服务端已经返回数据给客户端，断开这次的连接
            try {
                att.getClient().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void failed(Throwable exc, Attachement att) {
        System.out.println("连接断开！");
    }
}

class Attachement{
    private AsynchronousServerSocketChannel server;
    private AsynchronousSocketChannel client;
    private boolean isReadMode;
    private ByteBuffer buffer;

    public AsynchronousServerSocketChannel getServer() {
        return server;
    }

    public void setServer(AsynchronousServerSocketChannel server) {
        this.server = server;
    }

    public AsynchronousSocketChannel getClient() {
        return client;
    }

    public void setClient(AsynchronousSocketChannel client) {
        this.client = client;
    }

    public boolean isReadMode() {
        return isReadMode;
    }

    public void setReadMode(boolean readMode) {
        isReadMode = readMode;
    }

    public ByteBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(ByteBuffer buffer) {
        this.buffer = buffer;
    }
}

class Client{
    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    public void start(){
        try {
            AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
            Future<?> future = client.connect(new InetSocketAddress("localhost",8080));
            //阻塞一下，等待连接成功
            future.get();

            Attachement att = new Attachement();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            att.setClient(client);
            att.setReadMode(false);
            att.setBuffer(buffer);
            byte[] data = "I am robot!".getBytes();
            buffer.put(data);
            buffer.flip();
            //异步发送数据到服务端
            client.write(buffer,att,new ClientChannelHandler());
            // 这里休息一下再退出，给出足够的时间处理数据
            Thread.sleep(2000);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class ClientChannelHandler implements CompletionHandler<Integer,Attachement>{
    @Override
    public void completed(Integer result, Attachement att) {
        ByteBuffer buffer = att.getBuffer();
        //读取响应操作
        if (att.isReadMode()){
            buffer.flip();
            byte[] bytes = new byte[buffer.limit()];
            buffer.get(bytes);
            String msg = new String(bytes,Charset.forName("UTF-8"));
            System.out.println("收到来自服务器的响应数据： " + msg);
//             接下来，有以下两种选择:
//             1. 向服务端发送新的数据
//            att.setReadMode(false);
//            buffer.clear();
//            Scanner sc = new Scanner(System.in);
//            String newMsg = "afdfas";
//            byte[] data = newMsg.getBytes(Charset.forName("UTF-8"));
//            sc.close();
//            buffer.put(data);
//            buffer.flip();
//            att.getClient().write(buffer, att, this);
//            2.关闭连接
            try {
                att.getClient().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            //请求操作：写操作完成，设置为读模式
            att.setReadMode(true);
            buffer.clear();
            att.getClient().read(buffer,att,this);
        }
    }

    @Override
    public void failed(Throwable exc, Attachement att) {
        System.out.println("服务器无响应");
    }
}