package com.zhouyq.study.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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

        Socket socket = serverSocket.accept();

        // 从控制台读取数据
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
        in.close();
        out.close();
        is.close();

    }

}
