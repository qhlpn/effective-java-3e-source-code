package effectivejava.chapter6.item34;

// Enum type with data and behavior  (159-160)

// 用枚举类型代替 int 常量

// Java 枚举类型背后的基本思想很简单：
// 它们是通过 public static final 修饰的字段为每个枚举常量导出一个实例的类。
// 枚举类型实际上是 final 类型，
// 因为没有可访问的构造函数。客户端既不能创建枚举类型的实例，也不能继承它，
// 所以除了声明的枚举常量之外，不能有任何实例。
// 换句话说，枚举类型是实例受控的类（参阅第 6 页，Item-1）。它们是单例（Item-3）的推广应用，单例本质上是单元素的枚举。
public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6),
    EARTH(5.975e+24, 6.378e6),
    MARS(6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN(5.685e+26, 6.027e7),
    URANUS(8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.477e7);

    private final double mass;           // In kilograms
    private final double radius;         // In meters
    private final double surfaceGravity; // In m / s^2

    // Universal gravitational constant in m^3 / kg s^2
    private static final double G = 6.67300E-11;

    // Constructor
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;  // F = ma
    }

    public static void main(String[] args) {
        for (Planet p : Planet.values()) {
            System.out.println(p.ordinal());
        }
        System.out.println(Planet.MERCURY.toString());
        System.out.println(Planet.valueOf("MERCURY") == Planet.MERCURY);
    }

}

