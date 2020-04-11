package com.zhouyq.study.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Description 使用Socket 搞了一个聊天小程序
 * @Date 2020/4/10 20:54
 * @Author zhouyq
 */
public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1",9999);

        // 从控制台读取数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 给服务端写数据
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        // 从服务端读取数据
        BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String readline;
        readline = reader.readLine();
        while(!"bye".equals(readline)) {
            out.println(readline);
            out.flush();
            System.out.println("Server: " + is.readLine());
            readline = reader.readLine();
        }
        reader.close();
        out.close();
        is.close();
    }
}
