package org.hello.core.singletone;

public class SingletonService {

    public static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {}

    public void logic () {
        System.out.println("싱글톤 로직 객체 호출");
    }
}
