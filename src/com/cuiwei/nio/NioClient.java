package com.cuiwei.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * created by cuiwei on 2018/9/17
 * nio实现的简单客户端
 */
public class NioClient {
    SocketChannel socketChannel = null;

    public NioClient(String host,int port) throws IOException {
        socketChannel = SocketChannel.open();
        connect(host,port);
    }

    public void connect(String host,int port) throws IOException {
        socketChannel.connect(new InetSocketAddress(host,8080));
    }

    public void close(){
        try {
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sendRequest(String req){
        ByteBuffer buffer = ByteBuffer.wrap(req.getBytes());
        try {
            socketChannel.write(buffer);
            return getResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getResponse(){
        //读取响应
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int num;
        try {
            if ((num = socketChannel.read(readBuffer)) > 0){
                readBuffer.flip();
                byte[] res = new byte[num];
                readBuffer.get(res);

                return new String(res,"UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String req = sc.next();
            try {
                NioClient client = new NioClient("localhost",8080);
                if (req.equals("close")) {
                   sc.close();
                   client.close();
                }
                System.out.println(client.sendRequest(req));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
