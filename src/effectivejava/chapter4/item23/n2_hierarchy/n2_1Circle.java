package effectivejava.chapter4.item23.n2_hierarchy;

// Class hierarchy replacement for a tagged class  (Page 110-11)
class n2_1Circle extends n1_Figure {
    final double radius;

    n2_1Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}
