import java.util.Comparator;

/**
 * Created by Raphael on 22/03/2017.
 */
public class TimedKey<K> {

    private K key;
    private long exp;

    public TimedKey(K key, long duration) {
        this.key = key;
        this.exp = System.currentTimeMillis() + duration;
    }

    public long getExp() {
        return this.exp;
    }

    public K getKey() {
        return this.key;
    }

//    public int compareTo(TimedKey other){
//        if (exp == other.getExp()) {
//            return 0;
//        } else if (exp < other.getExp()) {
//            return -1;
//        } else {
//            return 1;
//        }
//    }
//
//    @Override
//    public int compare(TimedKey o1, TimedKey o2) {
//        if (o1.getExp() == o2.getExp()) {
//            return 0;
//        } else if (o1.getExp() < o2.getExp()) {
//            return 1;
//        } else {
//            return -1;
//        }
//    }

    public boolean equals(Object other) {
        // Two <TimedKey>s are equal if they have the same key
        return this.getKey().equals(((TimedKey) other).getKey());
    }

    public int hashCode() {
        return key.hashCode();
    }
}
