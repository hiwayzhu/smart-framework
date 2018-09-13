package aop;

public class Client {
    public static void main(String[] args){
        Hello hello = CGLibDynamicProxy.getInstance().getProxy(HelloImpl.class);
        hello.say("hiway");
    }
}
