package H_Generics.Exercises.GenericBox;

class Box<T> {
    private T element;

    Box(T element) {
        this.element = element;
    }

    T getElement() {
        return element;
    }

    void setElement(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return this.element.getClass().getName() + ": " + this.element;
    }
}
