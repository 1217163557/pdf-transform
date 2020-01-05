package com.example.pdf.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
  * @description
  * @author 张人杰
  * @Date 2020/1/3 10:42
  * @Param
  * @return
  */
@ServerEndpoint(value = "/websocket/{keyword}")
@Component
public class WebSocket {
    private final static Logger logger= LoggerFactory.getLogger(WebSocket.class);
    /** 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。*/
    private static int onlineNumber = 0;
    /** 以keyword为key，WebSocket为对象保存起来 */
    private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();
    /** 会话*/
    private Session session;
    /** 用户名称*/
    private String keyword;

    /**
     * 建立连接
     * @param keyword
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("keyword") String keyword, Session session){
        onlineNumber++;
        logger.info("现在来连接id：" + session.getId() + ",编号：" + keyword);
        this.session = session;
        this.keyword = keyword;
        logger.info("有新连接加入！" + onlineNumber);
        clients.put(keyword, this);
    }

    /**
     * 服务端错误
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.info("服务端发生了错误" + error.getMessage());
    }
    /**
     * 连接关闭
     */
    @OnClose
    public void onClose()
    {
        onlineNumber--;
        clients.remove(this.keyword);
        logger.info("连接数量"+ onlineNumber);
    }

    @OnMessage
    public void onMessage(String message, Session session)  throws Exception{
        System.out.println("websocket received message:"+message);
        for (WebSocket user:clients.values()
             ) {
            user.session.getBasicRemote().sendText("这是推送测试数据！您刚发送的消息是："+message);
        }
    }

    public static void sendOperation(String type,String keyword) throws Exception {
        for (WebSocket item : clients.values()) {
            if (item.keyword.equals(keyword) ) {
                item.session.getAsyncRemote().sendText(type);
                break;
            }
        }
    }


    public static boolean getWebSocket(String keyword){
        for (WebSocket item : clients.values()) {
            if (item.keyword.equals(keyword) ) {
               return true;
            }
        }
        return false;
    }
}
