package TP3;

import java.util.Arrays;
 
public class Queue_generic<ELEMENT> {
 
    //region Constants
 
    private final static Integer defaulDimension = 10;
 
    //endregion
 
    //region Attributes
 
    private ELEMENT [] data;
    private int head;
    private int tail;
    private int count;
 
    //endregion
 
    //region Constructors
 
    public Queue_generic() {
        this(Queue_generic.defaulDimension);
    }
    public Queue_generic(int dimension) {
        this.data = (ELEMENT[]) new Object[dimension];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }
    //endregion
 
    //region Queue Internal Methods
    private int next(int pos) {
        if (++pos >= this.data.length) {
            pos = 0;
        }
        return pos;
    }
    //endregion
 
 
    //region Queue Methods
 
    // Operacion EnQueue en la teoría de Estructura de Datos
    //
    // Inserts the specified element into this queue if it is possible to do so
    // immediately without violating capacity restrictions, returning true upon
    // success and throwing an IllegalStateException if no space is currently
    // available.
    public boolean add(ELEMENT element) {
 
        if (this.size() >= this.data.length) {
            throw new IllegalStateException("Cola llena ...");
        }
 
        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;
 
        return true;
    }
 
    // Operacion peek en la teoría de Estructura de Datos
    //
    // Retrieves, but does not remove, the head of this queue. This method differs
    // from peek only in that it throws an exception if this queue is empty.
    public ELEMENT element() {
 
        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }
 
        return this.data[this.head];
    }
 
    // Operacion EnQueue en la teoría de Estructura de Datos
    //
    // Inserts the specified element into this queue if it is possible to do so
    // immediately without violating capacity restrictions. When using a
    // capacity-restricted queue, this method is generally preferable to add(E),
    // which can fail to insert an element only by throwing an exception.
    public boolean offer(ELEMENT element) {
 
        if (this.size() >= this.data.length) {
            return false;
        }
 
        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;
 
        return true;
    }
 
    // Retrieves, but does not remove, the head of this queue, or returns null if
    // this queue is empty.
    public ELEMENT peek() {
        if (this.size() <= 0) {
            return null;
        }
 
        return this.data[this.head];
    }
 
    // Operacion DeQueue en la teoría de Estructura de Datos
    //
    // Retrieves and removes the head of this queue, or returns null if this queue
    // is empty.
    public ELEMENT pool() {
        if (this.size() <= 0) {
            return null;
        }
 
        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;
 
        return result;
    }
 
    // Operacion DeQueue en la teoría de Estructura de Datos
    //
    // Retrieves and removes the head of this queue. This method differs from poll()
    // only in that it throws an exception if this queue is empty.
    public ELEMENT remove() {
        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }
 
        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;
 
        return result;
    }
    //endregion
 
 
    //region Override Object basic methods
 
    @Override
    public String toString() {
 
        if (this.size() <=0) {
            return "";
        }
 
        // from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/StringBuilder.html
        StringBuilder sb = new StringBuilder();
        sb.append("[" + this.data[this.head].toString());
 
        for (int cta = 1, pos = this.next(this.head); cta < this.size(); ++cta, pos = this.next(pos)) {
            sb.append(", " + this.data[pos].toString());
        }
 
        sb.append("]");
        return sb.toString();
    }
    //endregion
 
 
    //region Collection Methods
 
    public boolean isEmpty() {
        return this.count <= 0;
    }
 
    public int size() {
        return this.count;
    }
 
    public Object[] toArray() {
        Object[] result = new Object[this.count];
        for(int i = 0, pos = this.head, cta = this.size(); cta > 0; ++i, pos = this.next(pos), --cta) {
            result[i] = this.data[pos];
        }
        return result;
    }
    //endregion
 
 
    //region Caso Ejemplo b) Methods
 
    public static Queue_generic<Object> union(Queue_generic<?> stack1, Queue_generic<?> stack2) {
        Queue_generic<Object> result = new Queue_generic<Object>(stack1.size() + stack2.size());
 
        for(int pos = stack1.head, cta = stack1.size(); cta > 0; pos = stack1.next(pos), --cta) {
            result.offer( stack1.data[pos] );
        }
        for(int pos = stack2.head, cta = stack2.size(); cta > 0; pos = stack2.next(pos), --cta) {
            result.offer( stack2.data[pos] );
        }
        return result;
    }
 
    public Queue_generic<Object> union(Queue_generic<?> stack2) {
        return Queue_generic.union(this, stack2);
    }
    //endregion
 
}
