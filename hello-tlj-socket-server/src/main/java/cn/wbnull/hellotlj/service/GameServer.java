package cn.wbnull.hellotlj.service;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 游戏Socket服务
 *
 * @author dukunbiao(null)  2020-02-06
 * https://github.com/dkbnull/HelloTljServer
 */
public class GameServer {

    //存储客户端连接
    public static List<GameClient> gameClients = new ArrayList<>();

    public GameServer() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8082);
        } catch (BindException e) {
            System.out.println("port is used.");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (serverSocket == null) {
            return;
        }

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                GameClient gameClient = new GameClient(socket);
                System.out.println("a client connected.");
                new Thread(gameClient).start();
                gameClients.add(gameClient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
