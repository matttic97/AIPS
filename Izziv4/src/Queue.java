public interface Queue<T> extends Collection {
    T front() throws CollectionException;
    void enqueue(T x) throws CollectionException;
    T dequeue() throws CollectionException;
    int getPrimerjave();
    int getPrirejanje();
}
