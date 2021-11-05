package effectivejava.chapter4.item23.n1_taggedclass;

// Tagged class - vastly inferior to a class hierarchy! (Page 109)
// 标签类冗长、容易出错和低效，
// 优先使用类层次结构，而不是带标签的类
class Figure {
    enum Shape {RECTANGLE, CIRCLE}

    // Tag field - the shape of this figure
    // 标签字段
    final Shape shape;

    // These fields are used only if shape is RECTANGLE
    double length;
    double width;

    // This field is used only if shape is CIRCLE
    double radius;

    // Constructor for circle
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // Constructor for rectangle
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}
