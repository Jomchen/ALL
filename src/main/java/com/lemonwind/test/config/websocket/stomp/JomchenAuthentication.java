package com.lemonwind.test.config.websocket.stomp;


import javax.security.auth.Subject;
import java.security.Principal;

/**
 * create by lemonwind on 12/31/18
 */
public class lemonwindAuthentication implements Principal {

    private String name;

    public lemonwindAuthentication(String name) {
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
