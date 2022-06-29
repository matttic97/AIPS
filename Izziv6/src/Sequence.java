public interface Sequence<T extends Comparable> extends Collection {
    static final String ERR_MSG_INDEX = "Wrong index in sequence.";
    T get(int i) throws CollectionException;
    void set(int i, T x) throws CollectionException;
    void insert(int i, T x) throws CollectionException;
    T delete(int i) throws CollectionException;
}
