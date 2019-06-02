//03. Generic Scale
package H_Generics.Lab.GenericScale;

class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    T getHeavier() {
        int c = this.left.compareTo(this.right);
        return c > 0 ? this.left : c < 0 ? this.right : null;
    }
}
