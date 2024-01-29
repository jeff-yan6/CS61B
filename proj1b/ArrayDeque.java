/**
 * Deque implemented by array.
 * @param <T>
 */

public class ArrayDeque<T> implements Deque<T> {
    private T[] array;
    private int size;
    private int tail;
    private int head;
    public ArrayDeque() {
        array = (T[]) new Object[15];
        size = 0;
        tail = 0;
        head = 0;
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        int j = 0;
        for (int i = head ; i != tail ; i = (i + 1) % (array.length), j++) {
            newArray[j] = array[i];
        }
        head = 0;
        tail = j;
        array = newArray;
    }

    private boolean isFull() {
        if (size == array.length - 1) {
            return true;
        }
        return false;
    }

    @Override
    public void addFirst(T item) {
        if (isFull()) {
            resize((int )(array.length*2));
        }
        head = (head - 1 + array.length) % (array.length);
        array[head] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (isFull()) {
            resize((int )(array.length*2));
        }
        array[tail] = item;
        tail = (tail + 1) % (array.length);
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    } 

    @Override
    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        int index = head;
        while (index != tail) {
            System.out.print(array[index] + " ");
            index = (index + 1) % (array.length);
        }

    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        tail = (tail - 1 + array.length) % (array.length);
        T ret = array[tail];
        size--;

        while (isLowUsage()) {
            resize((int) (array.length * 0.5));
        }

        return ret;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T ret = array[head];
        head = (head + 1) % (array.length);
        size--;

        while (isLowUsage()) {
            resize((int) (array.length * 0.5));
        }
        
        return ret;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size || isEmpty()) {
            return null;
        }
        index = (head + index) % (array.length);
        return array[index];
    }

    private boolean isLowUsage() {
        if (array.length >= 16 && size / ((double) array.length) < 0.25) {
            return true;
        }
        return false;
    }
}
