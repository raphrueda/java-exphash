import java.util.ArrayList;

/**
 * Created by Raphael on 7/03/2017.
 */
public class CustomQueue<T> {

    private ArrayList<T> queue;

    public CustomQueue() {
        queue = new ArrayList<>();
    }

    public void add(T item) {
        queue.add(item);
    }

    public T dequeue() {
        T item = queue.remove(0);
        return item;
    }

    public void showQueue() {
        System.out.println(queue.toString());
    }

    public int getSize() {
        return queue.size();
    }
}
