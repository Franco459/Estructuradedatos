package TP4;

public class QueueLinkedList<ELEMENT> {
    private SimpleLinkedList<ELEMENT> queue;

    public QueueLinkedList(){
        this.queue = new SimpleLinkedList<ELEMENT>();
    }

    public void enqueue(ELEMENT element){
        queue.addLast(element);
    }

    public Object dequeue(){
        if(queue.size() > 0) return queue.removeFirst();
        throw new RuntimeException("La lista de la cola está vacia");
    }

    public int size(){
        return queue.count;
    }

    public boolean isEmpty(){
        return (queue.count == 0) ? true : false;
    }

    public String toString(){
        if (queue.size() <= 0 ) return "[Cola vacia]";
        return queue.toString();
    }

    
}
