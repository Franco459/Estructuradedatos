package TP4;

import javax.lang.model.element.Element;
import javax.management.RuntimeErrorException;

public class QueueLinkedList<ELEMENT extends Comparable> {
    SimpleLinkedList queue;

    public QueueLinkedList(){
        queue = new SimpleLinkedList<>();
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

    public ELEMENT peek(){
        return (ELEMENT) queue.head;
    }

    public String toString(){
        return queue.toString();
    }

    
}
