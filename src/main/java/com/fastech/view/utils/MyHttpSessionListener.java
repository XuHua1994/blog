package com.fastech.view.utils;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

    public static int online = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("创建session");
        online ++;
        System.out.println("在线人数:"+online);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("销毁session");
    }
    
    

}
