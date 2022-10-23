package TP4;

public interface ILinkedList<ELEMENT> extends Iterable<ELEMENT> {
 
    // Returns the number of elements in this list.
    public int size();
 
    // Inserts the specified element at the beginning of this list.
    public void addFirst(ELEMENT item);
    // Appends the specified element to the end of this list.
    public void addLast(ELEMENT item);
    // Appends the specified element in order.
    public void addInOrder(ELEMENT item);
    // Removes and returns the first element from this list.
    public ELEMENT removeFirst();
    // Removes and returns the last element from this list.
    public ELEMENT removeLast();
 
}
