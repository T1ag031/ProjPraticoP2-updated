package BLL;

import java.util.concurrent.locks.ReentrantLock;

public class Singleton {
    private String info;

    private Singleton(){}

    private static Singleton _objeto = null;

    public static Singleton obtemInstancia(){
        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        if (_objeto==null){
            _objeto = new Singleton();
        }
        lock.unlock();

        return _objeto;
    }
}
