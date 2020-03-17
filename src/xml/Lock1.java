package xml;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Lock1 {
    public static void main(String[] args) {
        RW rw=new RW ();
        Map<String,String> map=new TreeMap<> ();
        map.put ("user","zm12");
        map.put ("user","zm11");
        map.put ("user1","zm10");
        map.put ("user2","zm0");
        map.put ("user3","zm99");
        map.put ("user4","zm9");
        map.put ("user5","zm8");
        map.put ("user6","zm7");
        map.put ("user7","zm6");
        map.put ("user8","zm5");
        map.put ("user9","zm4");
        map.put ("user10","zm3");
        map.put ("user11","zm2");
        map.put ("user12","zm1");
        ExecutorService executorService= Executors.newFixedThreadPool (2);
            map.forEach ((k,v)->{
                rw.put (k,v);
            });
        List<String> list= Arrays.asList (rw.allKeys ());
        executorService.execute (()->{
            list.forEach (e->{
                System.out.println (e);
            });
        });
        executorService.shutdown ();
    }
}

class RW{
    private final Map<String,String> m=new TreeMap<>  ();
    private final ReentrantReadWriteLock rwl=new ReentrantReadWriteLock ();
    private final Lock r=rwl.readLock ();
    private final Lock w=rwl.writeLock ();

    public String get(String key) {
        r.lock();
        try { return m.get(key); }
        finally { r.unlock(); }
    }
    public String[] allKeys() {
        r.lock();
        String[] s=new String[m.keySet ().size ()];
        try {
            return  m.keySet().toArray (s);
        }
        finally { r.unlock(); }
    }
    public String put(String key, String value) {
        w.lock();
        try { return m.put(key, value); }
        finally { w.unlock(); }
    }
    public void clear() {
        w.lock();
        try { m.clear(); }
        finally { w.unlock(); }
    }
}