package H_Generics.Exercises.Tuple;

class Tuple<TypeA, TypeB> {
    private TypeA item1;
    private TypeB item2;

    Tuple(TypeA item1, TypeB item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    TypeA getItem1() { return item1; }
    void setItem1(TypeA item1) { this.item1 = item1; }
    TypeB getItem2() { return item2; }
    void setItem2(TypeB item2) { this.item2 = item2; }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.item1, this.item2);
    }
}
