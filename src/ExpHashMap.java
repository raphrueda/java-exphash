import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by Raphael on 22/03/2017.
 */
public class ExpHashMap<K, V> implements Runnable {
    private PriorityQueue<TimedKey<K>> pq;
    private HashMap<K, V> hm;
    private final Thread t;
    private final Object lock = new Object();

    public ExpHashMap() {
        t = new Thread(this);
        hm = new HashMap<>();
        Comparator<TimedKey> comparator = new TimedKeyComparator();
        pq = new PriorityQueue<>(comparator);
    }

    public void put(K key, V val, long dur) {
        synchronized (lock) {
            TimedKey<K> expKey = new TimedKey<>(key, dur);
            if (hm.containsKey(key)) pq.remove(expKey);     // remove current entry for key in pq
            pq.add(expKey);                                 // replace with new key + dur in pq
            hm.put(key, val);
        }
    }

    public V get(K key) {
        return hm.get(key);
    }

    public void start() {
        t.start();
    }

    @Override
    public void run() {
        while(true){
            while(true) {
                synchronized (lock) {
                    if (hm.keySet().size() != 0) {
                        break;
                    }
                }
            }
            TimedKey<K> nextKey = pq.peek();
            while(System.currentTimeMillis() < nextKey.getExp()) {
                synchronized (lock) {
                    // Ensure we have the key with the next exp time
                    nextKey = pq.peek();
                }
                // Loop until that exp time is reached
            }
            synchronized (lock) {
                System.out.println("Key <" + nextKey.getKey() + "> has expired");
                pq.remove(nextKey);
                hm.remove(nextKey.getKey());
            }
        }
    }

    public void print() {
        synchronized (lock) {
            for (K key : hm.keySet()) {
                System.out.println("<" + key.toString() + "> --> <" + hm.get(key) + ">");
            }
        }
    }
}
