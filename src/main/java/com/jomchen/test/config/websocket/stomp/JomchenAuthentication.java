package com.jomchen.test.config.websocket.stomp;


import javax.security.auth.Subject;
import java.security.Principal;

/**
 * create by Jomchen on 12/31/18
 */
public class JomchenAuthentication implements Principal {

    private String name;

    public JomchenAuthentication(String name) {
        this.name = name;
    }

    // 如果有对这个类注入验证用户，则这里一定要重写获取相应的用户能够获取 name，否则报错gigi
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }
}
