public class LinkedListDeque<T> {
    private class Node {
        private Node pre;
        private T item;
        private Node next;
        // public Node(T item) {
        //     this.pre = null;
        //     this.item = item;
        //     this.next = null;
        // }

        public Node(LinkedListDeque<T>.Node pre, T item, LinkedListDeque<T>.Node next) {
            this.pre = pre;
            this.item = item;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, (T)new Object(), null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;

        size = 0;
    }

    // public LinkedListDeque(T item) {
    //     LinkedListDeque();
    //     addFirst(item);
    // }

    public void addFirst(T item) {
        Node head = new Node(sentinel, item, sentinel.next);
        
        //head的下一个指向head
        sentinel.next.pre = head;
        //哨兵指向head
        sentinel.next = head;

        size += 1;
    }

    public void addLast(T item) {
        Node tail = new Node(sentinel.pre, item, sentinel);
        // head.pre = sentinel.pre;
        // head.next = sentinel;

        //head的上一个指向head
        sentinel.pre.next = tail;
        //head指向哨兵
        sentinel.pre = tail;

        size += 1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node tmp = sentinel;
        while(tmp.next != sentinel) {
            tmp = tmp.next;
            System.out.print(tmp.item);
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T tmp = sentinel.next.item;

        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return tmp;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        T tmp = sentinel.pre.item;

        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size -= 1;
        return tmp;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        int cnt = 0;
        Node tmp = sentinel.next;
        while(cnt < size) {
            if(cnt == index) {
                return tmp.item;
            }
            cnt++;
            tmp = tmp.next;
        }
        return null;
    }

    private T getRecursive(int index, LinkedListDeque<T>.Node tmp) {
        if (index == 0) {
            return tmp.item;
        }
        return getRecursive(index - 1, tmp.next);
    }
    public T getRecursive(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        return getRecursive(index, sentinel.next);
    }
}
