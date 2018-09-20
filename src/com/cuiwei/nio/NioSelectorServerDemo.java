package com.cuiwei.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * created by cuiwei on 2018/9/17
 * 用nio实现的简单非阻塞服务器
 */
public class NioSelectorServerDemo {
    int port;//监听端口
    Selector selector;
    ServerSocketChannel serverSocketChannel;

    public NioSelectorServerDemo(int port){
        this.port = port;
    }

    public void start(){
        try {
            selector = Selector.open();

            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));//绑定端口
            serverSocketChannel.configureBlocking(false);//设置为非阻塞模式
            //将serverSocketChannel注册到selector，将返回一个SelectionKey对象
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

            run();//运行服务器
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run(){
        while(true){
            try {
                //不断调用select()方法获取最新准备好的通道
                int readyChannels = selector.select();
                if (readyChannels == 0) continue;
                Set<SelectionKey> readyKeys = selector.selectedKeys();
                //遍历已经准备好的通道
                Iterator<SelectionKey> iterator = readyKeys.iterator();
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();//从selected set中移除这个key，因为它已经被处理过了

                    if (key.isAcceptable()){//如果已经接受到新的客户端的连接
                        doAcceptableJob();
                    } else if (key.isReadable()){
                        doReadableJob(key);
                    } else if (key.isWritable()){
                        doWritableJob(key);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //如果已经接受到新的客户端的连接
    private void doAcceptableJob() throws IOException {
       SocketChannel socketChannel = serverSocketChannel.accept();//获取连接的客户端channel
       socketChannel.configureBlocking(false);//配置为非阻塞模式
       socketChannel.register(selector,SelectionKey.OP_READ);//将该通道注册为可读事件
    }

    //如果监听到可读事件，获取请求数据，执行相应逻辑，并注册写事件
    private void doReadableJob(SelectionKey key) throws IOException{
        SocketChannel socketChannel = (SocketChannel) key.channel();//获取该通道
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int num = socketChannel.read(readBuffer);
        if (num > 0){
            String req = new String(readBuffer.array(),"UTF-8");
            System.out.println("收到数据： " + req );
            //注册可写事件，并将处理结果绑定到这个key上。
            SelectionKey selectionKey = socketChannel.register(selector,SelectionKey.OP_WRITE);
            selectionKey.attach(req);
        }else if (num == -1){
            socketChannel.close();
        }
    }

    //如果监听到可写事件，则返回响应数据，并注册读事件
    private void doWritableJob(SelectionKey key) throws IOException{
        SocketChannel socketChannel = (SocketChannel) key.channel();
        String req = (String) key.attachment();//获取处理结果
        String res = "返回数据，收到您的请求：【" + req + "】";
        ByteBuffer writeBuffer = ByteBuffer.wrap(res.getBytes());
        socketChannel.write(writeBuffer);
        //注册可读事件
        socketChannel.register(selector,SelectionKey.OP_READ);
    }

    public static void main(String[] args) {
        NioSelectorServerDemo server = new NioSelectorServerDemo(8080);
        server.start();
    }

}
