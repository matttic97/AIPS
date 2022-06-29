
public interface PriorityQueue<T extends Comparable<T>> extends Queue<T> {

	int compareTo(T x, T y);

}
