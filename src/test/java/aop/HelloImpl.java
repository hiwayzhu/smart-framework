package aop;

import aop.Hello;

public class HelloImpl implements Hello {

    public void say(String name) {
        System.out.println("Hello"+name);
    }
}
