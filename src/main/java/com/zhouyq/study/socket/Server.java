package com.zhouyq.study.socket;

import com.zhouyq.study.socket.impl.Service;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description TODO
 * @Date 2020/4/10 20:55
 * @Author zhouyq
 */
public class Server {

    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(9999);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("监听到客户端连接到本机, IP： "+socket.getRemoteSocketAddress() + "\t端口："+socket.getPort());
            new Thread(new Service(socket)).start();
        }

    }

}
