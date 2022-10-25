package TP4;

public class StackLinkedList<ELEMENT extends Comparable> {
    private SimpleLinkedList<ELEMENT> stack;

    public StackLinkedList(){
        this.stack = new SimpleLinkedList<ELEMENT>();
    }

    public void add(ELEMENT data){
        stack.addLast(data);
    }

    public ELEMENT pop(){
        if(stack.size() > 0) return (ELEMENT) stack.removeLast();
        throw new RuntimeException("La lista deL stack está vacia");
    }

    public Object peek(){
        if (stack.size() <= 0 ) return null;
        return (Object) stack.tail;
    }

    public int size(){
        return stack.count;
    }

    public boolean isEmpty(){
        return (stack.count == 0) ? true : false;
    }

    public String toString(){
        if (stack.size() <= 0 ) return "[Stack vacio]";
        return stack.toString();
    }
}
