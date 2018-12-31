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

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }
}
