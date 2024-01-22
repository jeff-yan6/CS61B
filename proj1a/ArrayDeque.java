public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int tail;
    private int head;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        tail = 1;
        head = 0;
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];

        if (head < tail) {
            System.arraycopy(array, 0, newArray, 0, size);
        } else if (head > tail) {
            int j = 1;
            for (int i = (head + 1)%(array.length) ; i != tail ; i = (i + 1)%(array.length), j++) {
                newArray[j] = array[i];
            }
            head = 0;
            tail = j;
        }
        array = newArray;
    }

    private boolean isFull() {
        if (size == array.length - 2) {
            return true;
        }
        return false;
    }

    public void addFirst(T item) {
        if (isFull()) {
            resize((int)(array.length*1.5));
        }
        array[head] = item;
        head = (head - 1 + array.length) % (array.length);
        size++;
    }

    public void addLast(T item) {
        if (isFull()) {
            resize((int)(array.length*1.5));
        }
        array[tail] = item;
        tail = (tail + 1)%(array.length);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    } 

    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        int index = (head + 1)%(array.length);
        while(index != tail) {
            System.out.print(array[index] + " ");
            index = (index + 1)%(array.length);
        }

    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if(tail == 0) {
            tail = array.length - 1;
        } else {
            tail -= 1;
        }
        size--;

        if (isLowUsage()) {
            resize((int)(array.length * 0.5));
        }

        return array[tail];
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        head = (head + 1)%(array.length);
        size--;

        if (isLowUsage()) {
            resize((int)(array.length * 0.5));
        }
        return array[head];
    }

    public T get(int index) {
        if (index < 0 || index >= size || isEmpty()) {
            return null;
        }
        index = (head + 1 + index)%(array.length);
        return array[index];
    }

    private boolean isLowUsage() {
        if (array.length >= 16 && size / array.length < 0.25) {
            return false;
        }
        return false;
    }
}
