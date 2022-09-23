package TP2;

public class Stack<ELEMENT> {

    //region Constants

    private final static Integer defaulDimension = 10;

    //endregion

    //region Attributes

    private ELEMENT [] data;
    private Integer count;

    //endregion

    //region Constructors

    public Stack() {
        this(Stack.defaulDimension);
    }
    
    public Stack(Integer dimension) {
        if (dimension <= 0) {
            throw new RuntimeException("La cantidad de elementos en la  pila debe ser positiva");
        }
        this.data = (ELEMENT []) new Object[dimension];
        this.count = 0;
    }

    //endregion

    //region Stack Methods

    // Test if this stack is empty.
    public boolean empty() {
        return this.count <= 0;
    }

    // Looks at the object at the top of this stack without removing it from the stack.
    public ELEMENT peek() {
        if (this.empty()) {
            throw new RuntimeException("La pila está vacía...");
        }
        return this.data[this.count - 1];
    }

    // Removes the object at the top of this stack and returns that object as the value of this function.
    public ELEMENT pop() {
        if (this.empty()) {
            throw new RuntimeException("La pila está vacía...");
        }
        --this.count;
        return this.data[this.count];
    }

    // Pushes an item onto the top of this stack.
    public ELEMENT push(ELEMENT element) {
        if (this.size() >= this.data.length) {
//            throw new RuntimeException("La pila está llena...");

            ELEMENT [] temp = (ELEMENT []) new Object[this.data.length * 2];
            for (int i = 0; i < this.data.length; ++i) {
                temp[i] = this.data[i];
            }
            this.data = temp;
        }
        this.data[this.count] = element;
        ++this.count;
        return element;
    }

    // Returns the 1-based position where an object is on this stack.
    public int search(Object object) {
        for (int pos = this.count - 1; pos >= 0; --pos) {
            if (this.data[pos].equals(object)) {
                return this.count - pos;
            }
        }
        return -1;
    }
    //endregion

    //region Inherited Methods

    // from https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Vector.html
    // Returns the number of components in this vector.
    public int size() {
        return this.count;
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
        sb.append("[" + this.data[0].toString());
        for (int i = 1; i < this.size(); ++i) {
            sb.append(", " + this.data[i].toString());
        }
        sb.append("]");
        return sb.toString();
    }
    //endregion

    
}

