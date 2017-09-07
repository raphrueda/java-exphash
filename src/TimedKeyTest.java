import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Raphael on 22/03/2017.
 */
public class TimedKeyTest {
    public static void main(String[] args) {
        Comparator<TimedKey> comparator = new TimedKeyComparator();
        PriorityQueue<TimedKey<String>> pq = new PriorityQueue<>(comparator);
        TimedKey<String> key1 = new TimedKey<>("apple", 10000);
        TimedKey<String> key2 = new TimedKey<>("orange", 20000);
        TimedKey<String> key3 = new TimedKey<>("banana", 15000);
        pq.add(key1);
        pq.add(key2);
        pq.add(key3);
        while(!pq.isEmpty()) {
            TimedKey<String> next = pq.poll();
            System.out.println(next.getKey() + " -> " + next.getExp());
        }
    }
}
