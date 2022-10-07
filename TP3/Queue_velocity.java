package TP3;
import java.util.NoSuchElementException;
 
public class Queue_velocity<ELEMENT> {
    
    private ELEMENT[] queue;
    private int size, front, last;
    
    @SuppressWarnings("unchecked")
    public Queue_velocity(int size)
    {
        this.size = size;
        this.front = this.last = -1;
        this.queue = (ELEMENT[]) new Object[size];
    }
    
    public ELEMENT getFront() {
        if(isEmpty()) return null;
        return queue[front];
    }
    
    public ELEMENT getLast() {
        if(isEmpty()) return null;
        return queue[last-1];
    }
    
    public ELEMENT[] getQueueArray()
    {
        return this.queue;
    }
    public int getSize()
    {
        return this.size;
    }
    public boolean isEmpty() {
        return this.front == this.last;
    }
    
    public boolean isFull()
    {
        return this.next(last) == this.front;
    }
    
    protected int next(int pos) {
        if (++pos >= this.queue.length) {
            pos = 0;
        }
        return pos;
    }

    public void enqueue(ELEMENT element)
    {
        if(isFull()) throw new IllegalStateException("Queue is full");
        if(element == null) throw new NullPointerException("The new is null!");
        else
        {
            
            if(isEmpty())
            {
                front = last = 0;
            }
            queue[last++] = element;
        }
    }
    
    public ELEMENT dequeue()
    {
        if(isEmpty()) throw new NoSuchElementException("Empty queue.");
        ELEMENT retElement = queue[front];
        queue[front++] = null;
        return retElement;
    }
    
}