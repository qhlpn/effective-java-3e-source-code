package effectivejava.chapter4.item23.n2_hierarchy;

// Class hierarchy replacement for a tagged class  (Page 110-11)
class n2_2Rectangle extends n1_Figure {
    final double length;
    final double width;

    n2_2Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}