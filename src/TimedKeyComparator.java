import java.util.Comparator;

/**
 * Created by Raphael on 22/03/2017.
 */
public class TimedKeyComparator implements Comparator<TimedKey> {

    @Override
    public int compare(TimedKey o1, TimedKey o2) {
        return (int) (o1.getExp() - o2.getExp());
    }
}
