import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private int prev = 0;
    private int curr = 1;


    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        int nextValue = curr;
        int temp = curr;
        curr = curr + prev;
        prev = temp;
        return nextValue;
    }
}
