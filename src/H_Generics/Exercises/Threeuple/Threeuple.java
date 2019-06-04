package H_Generics.Exercises.Threeuple;

class Threeuple<TypeA, TypeB, TypeC> {
    private TypeA item1;
    private TypeB item2;
    private TypeC item3;

    Threeuple(TypeA item1, TypeB item2, TypeC item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    TypeA getItem1() { return item1; }
    void setItem1(TypeA item1) { this.item1 = item1; }
    TypeB getItem2() { return item2; }
    void setItem2(TypeB item2) { this.item2 = item2; }
    TypeC getItem3() { return item3; }
    void setItem3(TypeC item3) { this.item3 = item3; }

    void print() {
        System.out.println(String.format("%s -> %s -> %s", this.item1, this.item2, this.item3));
    }
}
