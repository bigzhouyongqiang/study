package com.zhouyq.study.socket.impl;

import java.io.*;
import java.net.Socket;

/**
 * @Description TODO
 * @Date 2020/4/10 21:40
 * @Author zhouyq
 */
public class Service implements Runnable {

    private Socket socket;

    public Service(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 从控制台读取数据
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            // 给客户端回写数据
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 从客户端读取数据
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String readline = is.readLine();
            while(!"bye".equals(readline) && null != readline) {
                System.out.println("Client: "+ readline);
                String outStr = in.readLine();
                out.println(outStr);
                out.flush();
                readline = is.readLine();
            }
            System.out.println("监听到客户端断开连接, IP： "+socket.getRemoteSocketAddress() + "\t端口："+socket.getPort());
            in.close();
            out.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
