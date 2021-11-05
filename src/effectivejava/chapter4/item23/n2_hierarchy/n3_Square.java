package effectivejava.chapter4.item23.n2_hierarchy;

// Class hierarchy replacement for a tagged class  (Page 110-11)
class n3_Square extends n2_2Rectangle {
    n3_Square(double side) {
        super(side, side);
    }
}
